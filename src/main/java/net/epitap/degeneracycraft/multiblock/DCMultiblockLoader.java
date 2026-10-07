package net.epitap.degeneracycraft.multiblock;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class DCMultiblockLoader implements PreparableReloadListener {

    private static final String NAMESPACE = "degeneracycraft";
    private static final String DIRECTORY = "multiblocks";
    private static final String EXTENSION = ".dcm";

    private final Map<ResourceLocation, DCMultiblockFile> files =
            new HashMap<>();

    @Override
    public CompletableFuture<Void> reload(
            PreparationBarrier barrier,
            ResourceManager resourceManager,
            ProfilerFiller preparationProfiler,
            ProfilerFiller reloadProfiler,
            Executor backgroundExecutor,
            Executor gameExecutor
    ) {
        return CompletableFuture
                .runAsync(() -> {
                    Map<ResourceLocation, DCMultiblockFile> loaded =
                            loadFiles(resourceManager);

                    files.clear();
                    files.putAll(loaded);

                    DCMultiblockRegistry.replaceAll(loaded);
                }, backgroundExecutor)
                .thenCompose(barrier::wait);
    }

    private Map<ResourceLocation, DCMultiblockFile> loadFiles(
            ResourceManager resourceManager
    ) {
        Map<ResourceLocation, DCMultiblockFile> loaded =
                new HashMap<>();

        Map<ResourceLocation, Resource> resources;

        try {
            resources = resourceManager.listResources(
                    DIRECTORY,
                    location ->
                            location.getNamespace().equals(NAMESPACE)
                                    && location.getPath().endsWith(EXTENSION)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return loaded;
        }

        System.out.println(
                "[DC] Found multiblock resources: " + resources.size()
        );

        for (Map.Entry<ResourceLocation, Resource> entry :
                resources.entrySet()) {

            ResourceLocation fileLocation = entry.getKey();
            Resource resource = entry.getValue();

            try {
                ResourceLocation id =
                        createIdFromFileLocation(fileLocation);

                System.out.println(
                        "[DC] Loading multiblock: "
                                + fileLocation
                                + " -> "
                                + id
                );

                String snbt;

                try (InputStream inputStream = resource.open()) {
                    snbt = new String(
                            inputStream.readAllBytes(),
                            StandardCharsets.UTF_8
                    );
                }

                CompoundTag root;

                try {
                    root = TagParser.parseTag(snbt);
                } catch (CommandSyntaxException e) {
                    throw new IOException(
                            "Failed to parse multiblock SNBT: "
                                    + fileLocation,
                            e
                    );
                }

                CompoundTag definition;

                if (root.contains("", Tag.TAG_COMPOUND)) {
                    definition = root.getCompound("");
                } else {
                    definition = root;
                }

                DCMultiblockFile file =
                        DCMultiblockFile.load(id, definition);

                loaded.put(id, file);

                System.out.println(
                        "[DC] Loaded multiblock: " + id
                );

            } catch (Exception e) {
                System.err.println(
                        "[DC] Failed to load multiblock: "
                                + fileLocation
                );

                e.printStackTrace();
            }
        }

        System.out.println(
                "[DC] Total loaded multiblocks: "
                        + loaded.size()
        );

        return loaded;
    }

    private static ResourceLocation createIdFromFileLocation(
            ResourceLocation fileLocation
    ) {
        String path = fileLocation.getPath();
        String prefix = DIRECTORY + "/";

        if (!path.startsWith(prefix)) {
            throw new IllegalArgumentException(
                    "Invalid DCM resource path: " + fileLocation
            );
        }

        path = path.substring(prefix.length());

        if (path.endsWith(EXTENSION)) {
            path = path.substring(
                    0,
                    path.length() - EXTENSION.length()
            );
        }

        return new ResourceLocation(
                fileLocation.getNamespace(),
                path
        );
    }

    public DCMultiblockFile get(ResourceLocation id) {
        return files.get(id);
    }

    public DCMultiblockFile getOrThrow(ResourceLocation id) {
        DCMultiblockFile file = files.get(id);

        if (file == null) {
            throw new IllegalArgumentException(
                    "Unknown DegeneracyCraft multiblock: " + id
            );
        }

        return file;
    }

    public boolean contains(ResourceLocation id) {
        return files.containsKey(id);
    }

    public int size() {
        return files.size();
    }

    public Map<ResourceLocation, DCMultiblockFile> getFiles() {
        return Collections.unmodifiableMap(files);
    }

    public void clear() {
        files.clear();
    }
}
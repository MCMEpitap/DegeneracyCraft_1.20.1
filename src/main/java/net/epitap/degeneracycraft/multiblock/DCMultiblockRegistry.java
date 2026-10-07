package net.epitap.degeneracycraft.multiblock;

import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DCMultiblockRegistry {

    private static final Map<ResourceLocation, DCMultiblockFile> FILES =
            new HashMap<>();

    private DCMultiblockRegistry() {
    }

    public static void replaceAll(Map<ResourceLocation, DCMultiblockFile> files) {
        FILES.clear();
        FILES.putAll(files);
        for (ResourceLocation id : FILES.keySet()) {
            System.out.println("[DC] Registry entry = " + id);
        }
    }

    public static DCMultiblockFile get(ResourceLocation id) {
        return FILES.get(id);
    }

    public static DCMultiblockFile getOrThrow(ResourceLocation id) {
        DCMultiblockFile file = FILES.get(id);

        if (file == null) {
            throw new IllegalArgumentException(
                    "Unknown DegeneracyCraft multiblock: " + id
            );
        }

        return file;
    }

    public static boolean contains(ResourceLocation id) {
        return FILES.containsKey(id);
    }

    public static int size() {
        return FILES.size();
    }

    public static Map<ResourceLocation, DCMultiblockFile> getAll() {
        return Collections.unmodifiableMap(FILES);
    }

    public static void clear() {
        FILES.clear();
    }
}
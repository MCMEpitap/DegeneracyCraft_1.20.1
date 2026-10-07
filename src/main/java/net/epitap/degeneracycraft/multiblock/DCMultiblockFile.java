package net.epitap.degeneracycraft.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DCMultiblockFile {

    public static final String DIRECTORY = "multiblocks";
    public static final String EXTENSION = ".dcm";

    private final ResourceLocation id;

    private final int x;
    private final int y;
    private final int z;

    private final int[] pattern;

    private final List<DCPlaceholder> placeholders;

    private DCMultiblockFile(ResourceLocation id, int x, int y, int z, int[] pattern, List<DCPlaceholder> placeholders) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pattern = pattern;
        this.placeholders = placeholders;
    }

    public static DCMultiblockFile load(ResourceManager resourceManager, ResourceLocation id) throws IOException {

        ResourceLocation fileLocation = new ResourceLocation(id.getNamespace(),DIRECTORY + "/" + id.getPath() + EXTENSION);

        Optional<Resource> resource =
                resourceManager.getResource(fileLocation);

        if (resource.isEmpty()) {
            throw new IOException("Multiblock file not found: " + fileLocation);
        }

        try (InputStream inputStream = resource.get().open()) {

            String snbt = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            final CompoundTag root;

            try {
                root = net.minecraft.nbt.TagParser.parseTag(snbt);
            } catch (com.mojang.brigadier.exceptions.CommandSyntaxException e) {
                throw new IOException("Failed to parse multiblock SNBT: " + fileLocation, e);
            }

            CompoundTag definition;

            if (root.contains("", Tag.TAG_COMPOUND)) {
                definition = root.getCompound("");
            } else {
                definition = root;
            }
            return load(id, definition);
        }
    }

    public static DCMultiblockFile load(ResourceLocation id, CompoundTag root) {

        if (!root.contains("placeholders", Tag.TAG_COMPOUND)) {

            throw new IllegalArgumentException("Multiblock file '" + id + "' does not contain 'placeholders'");
        }

        CompoundTag placeholdersTag =
                root.getCompound("placeholders");

        int x = placeholdersTag.getInt("x");

        int y = placeholdersTag.getInt("y");

        int z = placeholdersTag.getInt("z");

        if (x <= 0 || y <= 0 || z <= 0) {

            throw new IllegalArgumentException(
                    "Invalid multiblock size for '" +
                            id +
                            "': " +
                            x + "x" +
                            y + "x" +
                            z
            );
        }

        int[] pattern = placeholdersTag.getIntArray("pattern");

        int expectedSize = x * y * z;

        if (pattern.length != expectedSize) {

            throw new IllegalArgumentException(
                    "Invalid pattern size for '" +
                            id +
                            "': expected " +
                            expectedSize +
                            " entries, got " +
                            pattern.length
            );
        }

        List<DCPlaceholder> placeholders =
                new ArrayList<>();

        if (placeholdersTag.contains("holders", Tag.TAG_LIST)) {

            ListTag holders = placeholdersTag.getList("holders", Tag.TAG_COMPOUND);

            for (int i = 0; i < holders.size(); i++) {

                CompoundTag holderTag = holders.getCompound(i);

                placeholders.add(DCPlaceholder.load(holderTag));
            }
        }

        if (placeholders.isEmpty()) {

            throw new IllegalArgumentException(
                    "Multiblock file '" +
                            id +
                            "' does not contain any placeholders"
            );
        }

        for (int index : pattern) {

            if (index < 0 ||
                    index >= placeholders.size()) {

                throw new IllegalArgumentException(
                        "Invalid placeholder index " +
                                index +
                                " in multiblock '" +
                                id +
                                "'"
                );
            }
        }

        return new DCMultiblockFile(id, x, y, z, pattern, Collections.unmodifiableList(placeholders));
    }

    public ResourceLocation getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getSize() {
        return x * y * z;
    }

    public int[] getPattern() {
        return pattern.clone();
    }

    public List<DCPlaceholder> getPlaceholders() {
        return placeholders;
    }

    public int getPatternIndex(int x, int y, int z) {
        checkBounds(x, y, z);
        return x * this.y * this.z + y * this.z + z;
    }

    public int getPlaceholderIndex(int x, int y, int z) {
        return pattern[getPatternIndex(x, y, z)];
    }

    public DCPlaceholder getPlaceholder(int x, int y, int z) {
        return placeholders.get(getPlaceholderIndex(x, y, z));
    }

    public Optional<DCPlaceholder> getController() {
        return placeholders.stream().filter(DCPlaceholder::isController).findFirst();
    }

    public boolean hasController() {
        return getController().isPresent();
    }

    public BlockPos getControllerOffset() {
        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {
                for (int z = 0; z < this.z; z++) {

                    DCPlaceholder placeholder = getPlaceholder(x, y, z);

                    if (placeholder.isController()) {
                        return new BlockPos(x, y, z);
                    }
                }
            }
        }
        return null;
    }

    public BlockPos toRelativePos(int x, int y, int z) {

        BlockPos controller = getControllerOffset();

        if (controller == null) {
            throw new IllegalStateException(
                    "Multiblock '" +
                            id +
                            "' has no controller"
            );
        }

        return new BlockPos(
                x - controller.getX(),
                y - controller.getY(),
                z - controller.getZ()
        );
    }

    public boolean isInsideRelativeBounds(int x, int y, int z) {

        BlockPos controller = getControllerOffset();

        if (controller == null) {
            return false;
        }

        int fileX = x + controller.getX();

        int fileY = y + controller.getY();

        int fileZ = z + controller.getZ();

        return fileX >= 0 && fileX < this.x &&
                fileY >= 0 && fileY < this.y &&
                fileZ >= 0 && fileZ < this.z;
    }

    public int getPlaceholderIndexRelative(int x, int y, int z) {

        BlockPos controller = getControllerOffset();

        if (controller == null) {
            throw new IllegalStateException(
                    "Multiblock '" +
                            id +
                            "' has no controller"
            );
        }

        int fileX = x + controller.getX();

        int fileY = y + controller.getY();

        int fileZ = z + controller.getZ();

        return getPlaceholderIndex(fileX, fileY, fileZ);
    }

    public DCPlaceholder getPlaceholderRelative(int x, int y, int z) {

        return placeholders.get(
                getPlaceholderIndexRelative(x, y, z)
        );
    }

    private void checkBounds(int x, int y, int z) {

        if (x < 0 || x >= this.x || y < 0 || y >= this.y || z < 0 || z >= this.z) {

            throw new IndexOutOfBoundsException(
                    "Position outside multiblock: " +
                            x + ", " +
                            y + ", " +
                            z +
                            " / size " +
                            this.x + "x" +
                            this.y + "x" +
                            this.z
            );
        }
    }

    @Override
    public String toString() {

        return "DCMultiblockFile{" +
                "id=" + id +
                ", size=" +
                x + "x" +
                y + "x" +
                z +
                ", placeholders=" +
                placeholders.size() +
                '}';
    }

    public static class DCPlaceholder {

        private final List<DCPredicate> predicates;
        private final Direction facing;
        private final boolean controller;

        private DCPlaceholder(List<DCPredicate> predicates, Direction facing, boolean controller) {
            this.predicates = predicates;
            this.facing = facing;
            this.controller = controller;
        }

        /**
         * CompoundTagからPlaceholderをロードする。
         */
        public static DCPlaceholder load(CompoundTag tag) {

            List<DCPredicate> predicates = new ArrayList<>();

            if (tag.contains("predicates", Tag.TAG_LIST)) {

                ListTag predicateList = tag.getList("predicates", Tag.TAG_COMPOUND);

                for (int i = 0; i < predicateList.size(); i++) {
                    predicates.add(DCPredicate.load(predicateList.getCompound(i)));
                }
            }

            int facingId = tag.contains("facing", Tag.TAG_BYTE) ? tag.getByte("facing")
                            : Direction.NORTH.get3DDataValue();

            Direction facing;

            try {
                facing = Direction.from3DDataValue(facingId);
            } catch (Exception ignored) {
                facing = Direction.NORTH;
            }


            boolean controller = tag.getBoolean("isController");

            return new DCPlaceholder(Collections.unmodifiableList(predicates), facing, controller);
        }


        public List<DCPredicate> getPredicates() {
            return predicates;
        }

        public Direction getFacing() {
            return facing;
        }

        public boolean isController() {
            return controller;
        }

        public boolean hasPredicate(String key) {
            return predicates.stream().anyMatch(predicate -> predicate.isBuiltin(key));
        }

        @Override
        public String toString() {
            return "DCPlaceholder{" +
                    "predicates=" +
                    predicates +
                    ", facing=" +
                    facing +
                    ", controller=" +
                    controller +
                    '}';
        }
    }


    public static class DCPredicate {

        private final String type;
        private final String key;

        private DCPredicate(String type, String key) {

            this.type = type;
            this.key = key;
        }


        public static DCPredicate load(CompoundTag tag) {

            String type = tag.getString("type");

            String key = tag.getString("key");

            return new DCPredicate(type, key);
        }


        public String getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public boolean isBuiltin() {
            return "builtin".equals(type);
        }

        public boolean isBuiltin(String key) {
            return isBuiltin() && this.key.equals(key);
        }

        public boolean isAny() {
            return isBuiltin("any");
        }

        public boolean isAir() {
            return isBuiltin("air");
        }

        public boolean isBlock() {
            return isBuiltin() && !isAir() && !isAny();
        }

        public ResourceLocation getBlockId() {
            if (!isBlock()) {
                return null;
            }
            return ResourceLocation.tryParse(key);
        }


        @Override
        public String toString() {
            return "DCPredicate{" +
                    "type='" +
                    type +
                    '\'' +
                    ", key='" +
                    key +
                    '\'' +
                    '}';
        }
    }
}
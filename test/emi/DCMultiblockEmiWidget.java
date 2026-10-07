package net.epitap.degeneracycraft.integration.emi;

import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.Widget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DCMultiblockEmiWidget extends Widget {

    private final int widgetX;
    private final int widgetY;
    private final int widgetWidth;
    private final int widgetHeight;

    private final DCMultiblockDisplayData data;
    private final DCMultiblockPreviewRenderer renderer;

    // -1 = All、それ以外はYレイヤー
    private int selectedLayer = -1;

    // =========================
    // Layer
    // =========================

    private static final int LAYER_BUTTON_WIDTH = 18;
    private static final int LAYER_BUTTON_HEIGHT = 14;

    private static final int LAYER_BUTTON_TOP = 4;

    private static final int LAYER_LABEL_HEIGHT = 14;
    private static final int LAYER_GAP = 1;

    // =========================
    // Required Blocks
    // =========================

    private int blockScrollRow = 0;

    private static final int BLOCKS_PER_ROW = 9;
    private static final int BLOCKS_VISIBLE_ROWS = 2;
    private static final int BLOCK_SLOT_SIZE = 18;

    private static final int BLOCK_GRID_LEFT = 3;
    private static final int BLOCK_GRID_TOP_GAP = 4;

    private static final int SCROLL_BUTTON_WIDTH = 18;
    private static final int SCROLL_BUTTON_HEIGHT = 14;
    private static final int SCROLL_BUTTON_GAP = 2;

    /**
     * 現在画面に表示しているRequired BlockのSlotWidget。
     *
     * 最大で
     * 9 × 2 = 18
     * 個。
     */
    private final List<SlotWidget> requiredBlockSlots =
            new ArrayList<>();

    // =========================
    // Layout
    // =========================

    private static final int PREVIEW_HEIGHT = 100;

    private static final int BLOCK_GRID_HEIGHT =
            BLOCKS_VISIBLE_ROWS * BLOCK_SLOT_SIZE;

    private static final int BLOCK_AREA_HEIGHT =
            BLOCK_GRID_TOP_GAP
                    + BLOCK_GRID_HEIGHT
                    + SCROLL_BUTTON_GAP
                    + SCROLL_BUTTON_HEIGHT
                    + 4;

    public static final int TOTAL_WIDGET_HEIGHT =
            PREVIEW_HEIGHT + BLOCK_AREA_HEIGHT;

    /*
     * 9 × 18 = 162
     * 左右に少し余白を確保。
     */
    public static final int TOTAL_WIDGET_WIDTH = 168;

    public DCMultiblockEmiWidget(
            int x,
            int y,
            int width,
            int height,
            DCMultiblockDisplayData data
    ) {
        super();

        this.widgetX = x;
        this.widgetY = y;

        this.widgetWidth =
                Math.max(width, TOTAL_WIDGET_WIDTH);

        this.widgetHeight =
                Math.max(height, TOTAL_WIDGET_HEIGHT);

        this.data = data;
        this.renderer = new DCMultiblockPreviewRenderer();

        /*
         * 最初に表示するRequired Blocksの
         * SlotWidgetを作成する。
         */
        rebuildRequiredBlockSlots();
    }

    // =========================
    // Bounds
    // =========================

    @Override
    public Bounds getBounds() {
        return new Bounds(
                widgetX,
                widgetY,
                widgetWidth,
                widgetHeight
        );
    }

    public boolean isMouseOver(
            double mouseX,
            double mouseY
    ) {
        return mouseX >= widgetX
                && mouseX < widgetX + widgetWidth
                && mouseY >= widgetY
                && mouseY < widgetY + widgetHeight;
    }

    public DCMultiblockPreviewRenderer getRenderer() {
        return renderer;
    }

    public int getSelectedLayer() {
        return selectedLayer;
    }

    // =========================
    // Mouse
    // =========================

    /**
     * Mixinから呼び出す。
     *
     * true
     *  = このWidgetがクリックを処理した
     *
     * false
     *  = 通常のEMI処理を続行する
     */
    public boolean mousePressed(
            double mouseX,
            double mouseY,
            int button
    ) {
        if (!isMouseOver(mouseX, mouseY)) {
            return false;
        }

        // =========================
        // Required Blocks
        // =========================

        if (isInsideRequiredBlockArea(
                mouseX,
                mouseY
        )) {
            if (handleRequiredBlockClick(
                    mouseX,
                    mouseY,
                    button
            )) {
                return true;
            }
        }

        // =========================
        // Required Blocks scroll
        // =========================

        if (isBlockScrollUpButton(
                mouseX,
                mouseY
        )) {
            scrollBlocksUp();
            return true;
        }

        if (isBlockScrollDownButton(
                mouseX,
                mouseY
        )) {
            scrollBlocksDown();
            return true;
        }

        // =========================
        // Layer
        // =========================

        if (isPreviousButton(
                mouseX,
                mouseY
        )) {
            previousLayer();
            return true;
        }

        if (isNextButton(
                mouseX,
                mouseY
        )) {
            nextLayer();
            return true;
        }

        // =========================
        // 3D Preview
        // =========================

        if (isInsidePreview(
                mouseX,
                mouseY
        )) {
            renderer.mousePressed(
                    mouseX,
                    mouseY
            );

            return true;
        }

        return false;
    }

    /**
     * Mixinからカメラドラッグ中に呼び出す。
     */
    public void mouseDragged(
            double mouseX,
            double mouseY
    ) {
        renderer.mouseDragged(
                mouseX,
                mouseY
        );
    }

    public void mouseReleased() {
        renderer.mouseReleased();
    }

    public void mouseScrolled(double amount) {
        renderer.mouseScrolled(amount);
    }

    // =========================
    // Layer
    // =========================

    private void previousLayer() {
        int layerCount =
                data.getLayerCount();

        if (layerCount <= 0) {
            selectedLayer = -1;
            return;
        }

        if (selectedLayer == -1) {
            selectedLayer = layerCount - 1;
        } else if (selectedLayer == 0) {
            selectedLayer = -1;
        } else {
            selectedLayer--;
        }
    }

    private void nextLayer() {
        int layerCount =
                data.getLayerCount();

        if (layerCount <= 0) {
            selectedLayer = -1;
            return;
        }

        if (selectedLayer == -1) {
            selectedLayer = 0;
        } else if (selectedLayer >= layerCount - 1) {
            selectedLayer = -1;
        } else {
            selectedLayer++;
        }
    }

    // =========================
    // Layer position
    // =========================

    private int getLayerButtonX() {
        return widgetX
                + widgetWidth
                - LAYER_BUTTON_WIDTH
                - 4;
    }

    private int getLayerPreviousButtonY() {
        return widgetY
                + LAYER_BUTTON_TOP;
    }

    private int getLayerLabelY() {
        return getLayerPreviousButtonY()
                + LAYER_BUTTON_HEIGHT
                + LAYER_GAP;
    }

    private int getLayerNextButtonY() {
        return getLayerLabelY()
                + LAYER_LABEL_HEIGHT
                + LAYER_GAP;
    }

    private boolean isPreviousButton(
            double mouseX,
            double mouseY
    ) {
        int x = getLayerButtonX();
        int y = getLayerPreviousButtonY();

        return mouseX >= x
                && mouseX < x + LAYER_BUTTON_WIDTH
                && mouseY >= y
                && mouseY < y + LAYER_BUTTON_HEIGHT;
    }

    private boolean isNextButton(
            double mouseX,
            double mouseY
    ) {
        int x = getLayerButtonX();
        int y = getLayerNextButtonY();

        return mouseX >= x
                && mouseX < x + LAYER_BUTTON_WIDTH
                && mouseY >= y
                && mouseY < y + LAYER_BUTTON_HEIGHT;
    }

    // =========================
    // Required Blocks position
    // =========================

    private int getBlockGridX() {
        return widgetX
                + BLOCK_GRID_LEFT;
    }

    private int getBlockGridY() {
        return widgetY
                + PREVIEW_HEIGHT
                + BLOCK_GRID_TOP_GAP;
    }

    private int getBlockGridWidth() {
        return BLOCKS_PER_ROW
                * BLOCK_SLOT_SIZE;
    }

    private int getBlockGridHeight() {
        return BLOCK_GRID_HEIGHT;
    }

    private int getBlockScrollButtonY() {
        return getBlockGridY()
                + getBlockGridHeight()
                + SCROLL_BUTTON_GAP;
    }

    // =========================
    // Required Blocks data
    // =========================

    private List<Map.Entry<Block, Integer>>
    getRequiredBlocks() {

        return data.getBlockCounts()
                .entrySet()
                .stream()
                .sorted(
                        Comparator.comparing(
                                entry ->
                                        BuiltInRegistries.BLOCK
                                                .getKey(entry.getKey())
                                                .toString()
                        )
                )
                .toList();
    }

    private int getMaxBlockScrollRow() {
        int totalRows =
                (getRequiredBlocks().size()
                        + BLOCKS_PER_ROW
                        - 1)
                        / BLOCKS_PER_ROW;

        return Math.max(
                0,
                totalRows
                        - BLOCKS_VISIBLE_ROWS
        );
    }

    private void scrollBlocksUp() {
        int oldRow = blockScrollRow;

        blockScrollRow =
                Math.max(
                        0,
                        blockScrollRow - 1
                );

        if (oldRow != blockScrollRow) {
            rebuildRequiredBlockSlots();
        }
    }

    private void scrollBlocksDown() {
        int oldRow = blockScrollRow;

        blockScrollRow =
                Math.min(
                        getMaxBlockScrollRow(),
                        blockScrollRow + 1
                );

        if (oldRow != blockScrollRow) {
            rebuildRequiredBlockSlots();
        }
    }

    // =========================
    // Required Blocks SlotWidget
    // =========================

    /**
     * 現在のスクロール位置に応じて
     * Required Blocks用のSlotWidgetを作り直す。
     */
    private void rebuildRequiredBlockSlots() {
        requiredBlockSlots.clear();

        List<Map.Entry<Block, Integer>> entries =
                getRequiredBlocks();

        int startIndex =
                blockScrollRow
                        * BLOCKS_PER_ROW;

        int visibleCount =
                BLOCKS_PER_ROW
                        * BLOCKS_VISIBLE_ROWS;

        int gridX =
                getBlockGridX();

        int gridY =
                getBlockGridY();

        for (int i = 0;
             i < visibleCount;
             i++) {

            int index =
                    startIndex + i;

            if (index >= entries.size()) {
                break;
            }

            Map.Entry<Block, Integer> entry =
                    entries.get(index);

            Block block =
                    entry.getKey();

            int count =
                    entry.getValue();

            /*
             * Required Blocksの個数を
             * ItemStackそのものに持たせる。
             *
             * これによりSlotWidget / EMI側で
             * 個数表示が行われる。
             */
            ItemStack stack =
                    new ItemStack(
                            block,
                            Math.max(1, count)
                    );

            EmiStack emiStack =
                    EmiStack.of(stack);

            int col =
                    i % BLOCKS_PER_ROW;

            int row =
                    i / BLOCKS_PER_ROW;

            int x =
                    gridX
                            + col
                            * BLOCK_SLOT_SIZE;

            int y =
                    gridY
                            + row
                            * BLOCK_SLOT_SIZE;

            SlotWidget slot =
                    new SlotWidget(
                            emiStack,
                            x,
                            y
                    );

            /*
             * EMI標準の18×18スロットを使用。
             */
            slot.drawBack(true);

            requiredBlockSlots.add(slot);
        }
    }

    /**
     * マウス位置にあるRequired Blockの
     * SlotWidgetを取得する。
     */
    private SlotWidget getRequiredBlockSlotAt(
            double mouseX,
            double mouseY
    ) {
        for (SlotWidget slot :
                requiredBlockSlots) {

            if (slot.getBounds().contains(
                    (int) mouseX,
                    (int) mouseY
            )) {
                return slot;
            }
        }

        return null;
    }

    // =========================
    // Required Blocks hit test
    // =========================

    private boolean isInsideRequiredBlockArea(
            double mouseX,
            double mouseY
    ) {
        int x =
                getBlockGridX();

        int y =
                getBlockGridY();

        return mouseX >= x
                && mouseX < x
                + getBlockGridWidth()
                && mouseY >= y
                && mouseY < y
                + getBlockGridHeight();
    }

    /**
     * Required Blocksを
     * EMIのSlotWidgetとして操作する。
     *
     * 左クリック / 右クリックなどは
     * SlotWidget自身に処理させる。
     */
    private boolean handleRequiredBlockClick(
            double mouseX,
            double mouseY,
            int button
    ) {
        SlotWidget slot =
                getRequiredBlockSlotAt(
                        mouseX,
                        mouseY
                );

        if (slot == null) {
            return false;
        }

        return slot.mouseClicked(
                (int) mouseX,
                (int) mouseY,
                button
        );
    }

    // =========================
    // Required Blocks tooltip
    // =========================

    /**
     * SlotWidgetのTooltipを
     * DCMultiblockEmiWidgetからEMIへ返す。
     */
    @Override
    public List<ClientTooltipComponent> getTooltip(
            int mouseX,
            int mouseY
    ) {
        SlotWidget slot =
                getRequiredBlockSlotAt(
                        mouseX,
                        mouseY
                );

        if (slot == null) {
            return List.of();
        }

        return slot.getTooltip(
                mouseX,
                mouseY
        );
    }

    // =========================
    // Scroll button hit test
    // =========================

    private boolean isBlockScrollUpButton(
            double mouseX,
            double mouseY
    ) {
        int x =
                getBlockGridX();

        int y =
                getBlockScrollButtonY();

        return mouseX >= x
                && mouseX < x
                + SCROLL_BUTTON_WIDTH
                && mouseY >= y
                && mouseY < y
                + SCROLL_BUTTON_HEIGHT;
    }

    private boolean isBlockScrollDownButton(
            double mouseX,
            double mouseY
    ) {
        int x =
                getBlockGridX()
                        + SCROLL_BUTTON_WIDTH
                        + SCROLL_BUTTON_GAP;

        int y =
                getBlockScrollButtonY();

        return mouseX >= x
                && mouseX < x
                + SCROLL_BUTTON_WIDTH
                && mouseY >= y
                && mouseY < y
                + SCROLL_BUTTON_HEIGHT;
    }

    // =========================
    // Preview
    // =========================

    public boolean isInsidePreview(
            double mouseX,
            double mouseY
    ) {
        return mouseX >= widgetX
                && mouseX < widgetX
                + widgetWidth
                && mouseY >= widgetY
                && mouseY < widgetY
                + PREVIEW_HEIGHT;
    }

    // =========================
    // Render
    // =========================

    @Override
    public void render(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {
        // =========================
        // 3D Preview
        // =========================

        renderer.render(
                graphics,
                data,
                widgetX,
                widgetY,
                widgetWidth,
                PREVIEW_HEIGHT,
                selectedLayer
        );

        // =========================
        // Layer
        // =========================

        renderLayerControls(
                graphics
        );

        // =========================
        // Required Blocks
        // =========================

        renderRequiredBlockSlots(
                graphics,
                mouseX,
                mouseY,
                delta
        );

        // =========================
        // Scroll
        // =========================

        renderBlockScrollControls(
                graphics
        );
    }

    // =========================
    // Layer rendering
    // =========================

    private void renderLayerControls(
            GuiGraphics graphics
    ) {
        Minecraft minecraft =
                Minecraft.getInstance();

        int x =
                getLayerButtonX();

        // =========================
        // ▲
        // =========================

        int previousY =
                getLayerPreviousButtonY();

        renderLayerButton(
                graphics,
                x,
                previousY,
                "▲"
        );

        // =========================
        // All / Y
        // =========================

        String layerText =
                selectedLayer == -1
                        ? "All"
                        : String.valueOf(
                        selectedLayer + 1
                );

        int labelY =
                getLayerLabelY();

        graphics.fill(
                x,
                labelY,
                x + LAYER_BUTTON_WIDTH,
                labelY + LAYER_LABEL_HEIGHT,
                0xFF303030
        );

        graphics.drawCenteredString(
                minecraft.font,
                layerText,
                x + LAYER_BUTTON_WIDTH / 2,
                labelY + 3,
                0xFFFFFFFF
        );

        // =========================
        // ▼
        // =========================

        int nextY =
                getLayerNextButtonY();

        renderLayerButton(
                graphics,
                x,
                nextY,
                "▼"
        );
    }

    private void renderLayerButton(
            GuiGraphics graphics,
            int x,
            int y,
            String text
    ) {
        Minecraft minecraft =
                Minecraft.getInstance();

        graphics.fill(
                x,
                y,
                x + LAYER_BUTTON_WIDTH,
                y + LAYER_BUTTON_HEIGHT,
                0xFF404040
        );

        graphics.drawCenteredString(
                minecraft.font,
                text,
                x + LAYER_BUTTON_WIDTH / 2,
                y + 3,
                0xFFFFFFFF
        );
    }

    // =========================
    // Required Blocks rendering
    // =========================

    /**
     * Required Blocksは自前でItemStackを描画せず、
     * EMIのSlotWidgetそのものを描画する。
     */
    private void renderRequiredBlockSlots(
            GuiGraphics graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {
        for (SlotWidget slot :
                requiredBlockSlots) {

            slot.render(
                    graphics,
                    mouseX,
                    mouseY,
                    delta
            );
        }
    }

    // =========================
    // Scroll buttons
    // =========================

    private void renderBlockScrollControls(
            GuiGraphics graphics
    ) {
        int x =
                getBlockGridX();

        int y =
                getBlockScrollButtonY();

        int maxRow =
                getMaxBlockScrollRow();

        renderScrollButton(
                graphics,
                x,
                y,
                "▲",
                blockScrollRow > 0
        );

        renderScrollButton(
                graphics,
                x
                        + SCROLL_BUTTON_WIDTH
                        + SCROLL_BUTTON_GAP,
                y,
                "▼",
                blockScrollRow < maxRow
        );
    }

    private void renderScrollButton(
            GuiGraphics graphics,
            int x,
            int y,
            String text,
            boolean enabled
    ) {
        Minecraft minecraft =
                Minecraft.getInstance();

        int color =
                enabled
                        ? 0xFF505050
                        : 0xFF303030;

        graphics.fill(
                x,
                y,
                x + SCROLL_BUTTON_WIDTH,
                y + SCROLL_BUTTON_HEIGHT,
                color
        );

        graphics.drawCenteredString(
                minecraft.font,
                text,
                x + SCROLL_BUTTON_WIDTH / 2,
                y + 3,
                enabled
                        ? 0xFFFFFFFF
                        : 0xFF777777
        );
    }
}
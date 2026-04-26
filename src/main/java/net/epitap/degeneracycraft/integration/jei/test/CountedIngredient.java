package net.epitap.degeneracycraft.integration.jei.test;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class CountedIngredient {
    private final Ingredient ingredient;
    private final int count;

    public CountedIngredient(Ingredient ingredient, int count) {
        this.ingredient = ingredient;
        this.count = count;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack[] getItems() {
        return ingredient.getItems();
    }

    public int getCount() {
        return count;
    }

    public boolean test(ItemStack stack) {
        return ingredient.test(stack) && stack.getCount() >= count;
    }

    public static CountedIngredient fromJson(JsonObject json) {
        Ingredient ingredient = Ingredient.fromJson(json);
        int count = GsonHelper.getAsInt(json, "count", 1);
        return new CountedIngredient(ingredient, count);
    }

    public void toNetwork(FriendlyByteBuf buf) {
        ingredient.toNetwork(buf);
        buf.writeInt(count);
    }

    public static CountedIngredient fromNetwork(FriendlyByteBuf buf) {
        Ingredient ingredient = Ingredient.fromNetwork(buf);
        int count = buf.readInt();
        return new CountedIngredient(ingredient, count);
    }
}
package net.gurken.recurrencemod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.gurken.recurrencemod.RecurrenceMod;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class LunaticFactionForgeRecipe  implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final FluidStack fluidStack;

    public LunaticFactionForgeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputItems, int craftTime, FluidStack fluidStack) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.fluidStack = fluidStack;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0)) && inputItems.get(1).test(pContainer.getItem(1))
                && inputItems.get(2).test(pContainer.getItem(2)) && inputItems.get(3).test(pContainer.getItem(3));
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    public int getCraftTime() {
        return craftTime;
    }

    public FluidStack getFluidStack() {
        return fluidStack;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LunaticFactionForgeRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return LunaticFactionForgeRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<LunaticFactionForgeRecipe> {
        private Type() { }
        public static final LunaticFactionForgeRecipe.Type INSTANCE = new LunaticFactionForgeRecipe.Type();
        public static final String ID = "lunatic_faction_forge";
    }

    public static class Serializer implements RecipeSerializer<LunaticFactionForgeRecipe> {
        public static final LunaticFactionForgeRecipe.Serializer INSTANCE = new LunaticFactionForgeRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(RecurrenceMod.MOD_ID,"lunatic_faction_forge");

        @Override
        public LunaticFactionForgeRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            //not 1.20.2 compatible
            FluidStack fluidStack = new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(json.get("fluidType").getAsString())),
                    json.get("fluidAmount").getAsInt());

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(4, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            int craftTime = json.get("craftTime").getAsInt();

            return new LunaticFactionForgeRecipe(id, output, inputs, craftTime, fluidStack);
        }

        @Override
        public LunaticFactionForgeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            FluidStack fluidStack = buf.readFluidStack();

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int craftTime = buf.readInt();

            ItemStack output = buf.readItem();
            return new LunaticFactionForgeRecipe(id, output, inputs, craftTime, fluidStack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, LunaticFactionForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            buf.writeFluidStack(recipe.fluidStack);

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeInt(recipe.craftTime);

            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}

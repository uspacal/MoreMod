package me._pacal.moremod.init;

import me._pacal.moremod.MoreMod;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import javax.swing.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = MoreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MoreMod.MOD_ID)
public class ItemInit {
    public static final Item ruby = null;
    public static final Item ruby_shard = null;
    public static final Item ruby_cookie = null;
    public static final Item ruby_sword = null;
    public static final Item ruby_pickaxe = null;
    public static final Item ruby_axe = null;
    public static final Item ruby_shovel = null;
    public static final Item ruby_hoe = null;
    public static final Item ruby_double_sword = null;
    public static final Item ruby_doubel_pickaxe = null;
    public static final Item ruby_double_axe = null;
    public static final Item ruby_double_shovel = null;
    public static final Item ruby_double_hoe = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby"));
        event.getRegistry().register(new Item(new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_shard"));
        event.getRegistry().register(new Item(new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB).
                food(new Food.Builder().
                        hunger(20).
                        saturation(20).
                        effect(new EffectInstance(Effects.INSTANT_HEALTH, 255), 1f).build()))
                .setRegistryName("ruby_cookie"));
        //tools
        event.getRegistry().register(new SwordItem(ModItemTier.RUBY, 8, -0.8F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.RUBY, 5, -1.6F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.RUBY, 10, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_axe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.RUBY, 5.5F, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_shovel"));
        event.getRegistry().register(new HoeItem(ModItemTier.RUBY, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_hoe"));
        //double Tools
        event.getRegistry().register(new SwordItem(ModItemTier.DOUBLERUBY, 8, -0.8F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_double_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.DOUBLERUBY, 6, -1.6F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_double_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.DOUBLERUBY, 10, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_double_axe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.DOUBLERUBY, 6.5F, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_double_shovel"));
        event.getRegistry().register(new HoeItem(ModItemTier.DOUBLERUBY, -2.0F, new Item.Properties().
                group(MoreMod.MoreModItemGroup.TAB)).setRegistryName("ruby_double_hoe"));
    }

    public enum ModItemTier implements IItemTier {
        RUBY(4, 3122, 15.0F, 1, 100, () -> {
            return Ingredient.fromItems(ItemInit.ruby);
        }),
        DOUBLERUBY(4, 6244, 30.0F, 1, 150, () -> {
            return Ingredient.fromItems(ItemInit.ruby);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;


        private ModItemTier(int harvestLevel, int maxUses,
                            float efficiency, float attackDamage, int enchantability,
                            Supplier<Ingredient> repairMaterial) {

            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }


        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

}

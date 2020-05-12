package me._pacal.moremod.init;

import me._pacal.moremod.MoreMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static net.minecraft.block.Block.*;

@ObjectHolder(MoreMod.MOD_ID)
@Mod.EventBusSubscriber(modid = MoreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final Block ruby_block = null;
    public static final Block ruby_ore = null;
    public static final Block weird_cube = null;

    @SubscribeEvent
    public static  void registerBlock(final RegistryEvent.Register<Block> event) {
        //Ruby Block
        event.getRegistry().register(new Block( Block.Properties.create(Material.IRON).
                hardnessAndResistance(7, 50).
                harvestTool(ToolType.PICKAXE).
                harvestLevel(3).
                sound(SoundType.STONE)).setRegistryName("ruby_block"));
        //Ruby Ore
        event.getRegistry().register(new Block( Block.Properties.create(Material.IRON).
                hardnessAndResistance(7, 1200).
                harvestTool(ToolType.PICKAXE).
                harvestLevel(3).
                sound(SoundType.STONE)).setRegistryName("ruby_ore"));
        // Weird Cube
        event.getRegistry().register(new Block( Block.Properties.create(Material.IRON).
                hardnessAndResistance(1000, 5000).
                harvestTool(ToolType.AXE).
                harvestLevel(3).
                sound(SoundType.METAL)).setRegistryName("weird_cube"));
    }
    @SubscribeEvent
    public static  void registerBlockItems(final RegistryEvent.Register<Item> event) {
        //Ruby Block
        event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(MoreMod.MoreModItemGroup.TAB))
                .setRegistryName("ruby_block"));
        //Roby Ore
        event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(MoreMod.MoreModItemGroup.TAB))
                .setRegistryName("ruby_ore"));
        //Weird Cube
        event.getRegistry().register(new BlockItem(weird_cube, new Item.Properties().group(MoreMod.MoreModItemGroup.TAB))
                .setRegistryName("weird_cube"));
    }

}

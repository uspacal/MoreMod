package me._pacal.moremod.world.gen;


import me._pacal.moremod.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {

                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(25, 0, 5, 10));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig
                                .FillerBlockType.NATURAL_STONE, BlockInit.ruby_ore.
                                getDefaultState(), 10))
                        .withPlacement(customConfig));

        }
    }
}


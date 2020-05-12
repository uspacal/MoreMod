package me._pacal.moremod;


import me._pacal.moremod.init.BlockInit;
import me._pacal.moremod.init.ItemInit;
import me._pacal.moremod.world.gen.ModOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;


@Mod("moremod")
@Mod.EventBusSubscriber (modid = MoreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreMod {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "moremod";
    public static MoreMod instance;

    public MoreMod() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
 @SubscribeEvent
  public static void loadCompleteEvent(FMLLoadCompleteEvent event){
     ModOreGen.generateOre();
    }

    public static class MoreModItemGroup extends ItemGroup {
        public static final MoreModItemGroup TAB =
                new MoreModItemGroup(ItemGroup.GROUPS.length, "MoreMod");

        private MoreModItemGroup(int index, String label) {
            super(index, label);

        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.weird_cube);
        }
    }

}

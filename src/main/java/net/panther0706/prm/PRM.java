package net.panther0706.prm;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.panther0706.prm.items.*;
import net.panther0706.prm.tabs.PRMCreativeTabs;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PRM.MODID)
public class PRM
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "prm";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PRM()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        PRMBows.Register(modEventBus);
        PRMCreativeTabs.Register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            //Stone
            event.getEntries().putAfter(Items.STONE_SWORD.getDefaultInstance(),
                    PRMBows.STONE_BOW.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            //Gold
            event.getEntries().putAfter(Items.GOLDEN_SWORD.getDefaultInstance(),
                    PRMBows.GOLD_BOW.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            //Iron
            event.getEntries().putAfter(Items.IRON_SWORD.getDefaultInstance(),
                    PRMBows.IRON_BOW.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            //Diamond
            event.getEntries().putAfter(Items.DIAMOND_SWORD.getDefaultInstance(),
                    PRMBows.DIAMOND_BOW.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            //Netherite
            event.getEntries().putAfter(Items.NETHERITE_SWORD.getDefaultInstance(),
                    PRMBows.NETHERITE_BOW.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            PRMStoneBowProperties.addBowProperties();
            PRMGoldBowProperties.addBowProperties();
            PRMIronBowProperties.addBowProperties();
            PRMDiamondBowProperties.addBowProperties();
            PRMNetheriteBowProperties.addBowProperties();
        }
    }
}

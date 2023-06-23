package net.panther0706.prm.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.panther0706.prm.PRM;
import net.panther0706.prm.items.PRMBows;

public class PRMCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PRM.MODID);
    public static final RegistryObject<CreativeModeTab> PRM_TAB = TABS.register("prm_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Panther's Ranged Mod"))
                    .icon(PRMBows.STONE_BOW.get()::getDefaultInstance)
                    .displayItems((displayParameters, displayOutput) -> {
                        displayOutput.accept(PRMBows.STONE_BOW.get());
                        displayOutput.accept(PRMBows.GOLD_BOW.get());
                        displayOutput.accept(PRMBows.IRON_BOW.get());
                        displayOutput.accept(PRMBows.DIAMOND_BOW.get());
                        displayOutput.accept(PRMBows.NETHERITE_BOW.get());
                    })
                    .build()
    );

    public static void Register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}

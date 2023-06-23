package net.panther0706.prm.items.bows;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.panther0706.prm.PRM;

public class PRMBows {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PRM.MODID);

    public static final RegistryObject<PRMStoneBow> STONE_BOW = ITEMS.register("stone_bow",
            () -> new PRMStoneBow(new Item.Properties()));
    public static final RegistryObject<PRMGoldBow> GOLD_BOW = ITEMS.register("gold_bow",
            () -> new PRMGoldBow(new Item.Properties()));
    public static final RegistryObject<PRMIronBow> IRON_BOW = ITEMS.register("iron_bow",
            () -> new PRMIronBow(new Item.Properties()));
    public static final RegistryObject<PRMDiamondBow> DIAMOND_BOW = ITEMS.register("diamond_bow",
            () -> new PRMDiamondBow(new Item.Properties()));
    public static final RegistryObject<PRMNetheriteBow> NETHERITE_BOW = ITEMS.register("netherite_bow",
            () -> new PRMNetheriteBow(new Item.Properties()));

    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

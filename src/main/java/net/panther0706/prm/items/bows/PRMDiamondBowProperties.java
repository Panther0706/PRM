package net.panther0706.prm.items.bows;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class PRMDiamondBowProperties {
    public static void addBowProperties() {

        makeBow(PRMBows.DIAMOND_BOW.get());
    }

    public static void makeBow(Item bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"), ((p_174676_, p_174677_, p_174678_, p_174679_) -> {
            if (p_174678_ == null) {
                return 0.0f;
            } else {
                return p_174678_.getUseItem() != p_174676_ ? 0.0f : (float)(p_174676_.getUseDuration()
                        - p_174678_.getUseItemRemainingTicks()) / 25.0f;
            }
        }));
        ItemProperties.register(bow, new ResourceLocation("pulling"), (p_174676_, p_174677_, p_174678_, p_174679_) -> {
            return p_174678_ != null && p_174678_.isUsingItem() && p_174678_.getUseItem() == p_174676_ ? 1.0f : 0.0f;
        });

    }
}

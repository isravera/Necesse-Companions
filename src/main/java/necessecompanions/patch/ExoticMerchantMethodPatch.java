package necessecompanions.patch;

import necesse.engine.modLoader.annotations.ModConstructorPatch;
import necesse.entity.mobs.friendly.human.humanShop.ExoticMerchantHumanMob;
import necesse.entity.mobs.friendly.human.humanShop.SellingShopItem;
import net.bytebuddy.asm.Advice;

@ModConstructorPatch(target = ExoticMerchantHumanMob.class, arguments = {})
public class ExoticMerchantMethodPatch {
    @Advice.OnMethodExit
    static void onExit(@Advice.This ExoticMerchantHumanMob merchant) {

        merchant.shop.addSellingItem(
            "pet_certificate",
            new SellingShopItem(10, 5)
                .setRandomPrice(50, 100)
        );
    }
}
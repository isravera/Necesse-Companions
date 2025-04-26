package necessecompanions.buffs;

import necesse.engine.localization.message.LocalMessage;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.VicinityBuff;
import necesse.gfx.gameTexture.GameTexture;

public class MaxResilienceBuff extends VicinityBuff {
    public MaxResilienceBuff() {
        this.isImportant = true;
        this.canCancel = false;
        this.isVisible = true;
    }

    public void init(ActiveBuff activeBuff, BuffEventSubscriber subscriber) {
        activeBuff.setModifier(BuffModifiers.MAX_RESILIENCE_FLAT, 10);
        activeBuff.setModifier(BuffModifiers.SPEED, 0.2F);
    }

    @Override
    public void updateLocalDisplayName() {
        this.displayName = new LocalMessage("buff", this.getStringID());
    }

    @Override
    public void loadTextures() {
        this.iconTexture = GameTexture.fromFile("buffs/default_pet_buff");
    }
}

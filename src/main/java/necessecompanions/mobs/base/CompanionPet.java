package necessecompanions.mobs.base;

import necesse.engine.util.GameUtils;
import necesse.entity.mobs.Attacker;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.leaves.PlayerFollowerAINode;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.entity.mobs.summon.summonFollowingMob.petFollowingMob.PetFollowingMob;

import java.awt.*;
import java.util.function.Function;

public class CompanionPet extends PetFollowingMob {
    public Function<Mob, Buff> buff;

    public CompanionPet(int maxHealth, Buff buff) {
        super(maxHealth);
        this.buff = (mob) -> buff;
        setSpeed(300.0F);
        setFriction(2.0F);
        moveAccuracy  = 10;

        collision = new Rectangle(-12, -9, 24, 18);
        hitBox = new Rectangle(-16, -12, 32, 24);
        selectBox = new Rectangle(-18, -30, 36, 36);
    }

    public void applyBuffs(Mob mob) {
        Buff buff = (Buff) this.buff.apply(mob);

        if(buff != null) {
            ActiveBuff activeBuff = new ActiveBuff(buff, mob, 100, (Attacker) null);
            mob.buffManager.addBuff(activeBuff, false);
        }
    }

    @Override
    public void clientTick() {
        super.clientTick();
        GameUtils.streamNetworkClients(this.getLevel()).filter((client) -> {
            return client.playerMob.getDistance(this.x, this.y) <= 300.0F;
        }).forEach((client) -> {
            this.applyBuffs(client.playerMob);
        });
    }

    @Override
    public void init() {
        super.init();
        this.ai = new BehaviourTreeAI<>(this, new PlayerFollowerAINode<>(450, 64));
    }

}
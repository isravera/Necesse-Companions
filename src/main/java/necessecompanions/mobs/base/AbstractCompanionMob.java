package necessecompanions.mobs.base;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.buffs.staticBuffs.Buff;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.level.maps.Level;

import java.util.List;

public abstract class AbstractCompanionMob extends CompanionPet {

    public AbstractCompanionMob(int health, Buff buff) {
        super(health, buff);
        this.setSpeed(50.0F);
        this.setFriction(2.0F);
    }

    public abstract void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective);
}
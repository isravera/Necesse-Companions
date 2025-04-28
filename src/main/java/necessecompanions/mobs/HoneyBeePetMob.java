package necessecompanions.mobs;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.engine.util.GameRandom;
import necesse.engine.util.GameUtils;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.texture.TextureDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;
import necessecompanions.ModEntryPoint;
import necessecompanions.mobs.base.AbstractCompanionMob;

import java.awt.*;
import java.util.List;

public class HoneyBeePetMob extends AbstractCompanionMob {
    public static GameTexture texture;
    public static boolean hasMultipleSprites;

    public HoneyBeePetMob() {
        super(100, ModEntryPoint.ATTACK_SPEED_BUFF);
    }

    @Override
    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {

        GameLight light = level.getLightLevel(x / 32, y / 32);
        int drawX = camera.getDrawX(x) - 16;
        int drawY = camera.getDrawY(y) - 22;
        int dir = this.getDir();
        int animationTime = 1000;
        long time = level.getTime();
        time += (long)(new GameRandom((long)this.getUniqueID())).nextInt(animationTime);
        Point sprite = this.getAnimSprite(x, y, dir);
        TextureDrawOptions shadow = MobRegistry.Textures.honeyBee.shadow.initDraw().sprite(0, dir, 32).light(light).pos(drawX, drawY);
        tileList.add((tm) -> {
            shadow.draw();
        });
        float bobbingFloat = GameUtils.getBobbing(time, animationTime);
        drawY -= 6;
        drawY = (int)((float)drawY + bobbingFloat * 5.0F);
        final DrawOptions options = texture.initDraw().sprite(sprite.x, sprite.y, 32).light(light).pos(drawX, drawY);
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                options.draw();
            }
        });
    }

    public Point getAnimSprite(int x, int y, int dir) {
        long time = this.getTime();
        time += (new GameRandom(this.getUniqueID())).nextInt(200);
        return new Point(GameUtils.getAnim(time, 2, 200), dir);
    }
}

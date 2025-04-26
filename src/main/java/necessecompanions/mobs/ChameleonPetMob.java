package necessecompanions.mobs;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;
import necessecompanions.ModEntryPoint;
import necessecompanions.mobs.base.AbstractCompanionMob;

import java.awt.*;
import java.util.List;

public class ChameleonPetMob extends AbstractCompanionMob {
    public static GameTexture texture;
    public static boolean hasMultipleSprites;

    public ChameleonPetMob() {
        super(100, ModEntryPoint.ATTACK_SPEED_BUFF);
    }

    @Override
    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {

        GameLight light = level.getLightLevel(getTileX(), getTileY());

        // === Draw Pet ===
        list.add(new MobDrawable() {
            @Override
            public void draw(TickManager tickManager) {
            int drawX = camera.getDrawX(x) - 32;
            int drawY = camera.getDrawY(y) - 51;
            drawY += getBobbing(x, y);
            drawY += level.getTile(getTileX(), getTileY()).getMobSinkingAmount(ChameleonPetMob.this);

            int dir = getDir();

            Point sprite;

            if (!hasMultipleSprites) { dir = (dir <= 1) ? 1 : 3; }

            sprite = getAnimSprite(x, y, dir);

            texture.initDraw()
                .sprite(sprite.x, sprite.y, 64)
                .light(light)
                .pos(drawX, drawY)
                .draw();
            }
        });

        // === Draw Shadow ===
        tileList.add(new MobDrawable() {
            @Override
            public void draw(TickManager tickManager) {
            GameTexture shadowTexture = MobRegistry.Textures.human_baby_shadow;
            int res = shadowTexture.getHeight();
            int drawX = camera.getDrawX(x) - res / 2;
            int drawY = camera.getDrawY(y) - res / 2;
            drawY += getBobbing(x, y);

            shadowTexture.initDraw()
                .sprite(getDir(), 0, res)
                .light(light)
                .pos(drawX, drawY)
                .draw();
            }
        });
    }
}

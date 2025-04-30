package necessecompanions.mobs;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.registries.MobRegistry;
import necesse.entity.mobs.MaskShaderOptions;
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

public class DeerPetMob extends AbstractCompanionMob {
    public static GameTexture texture;
    public static boolean hasMultipleSprites;

    public DeerPetMob() {
        super(100, ModEntryPoint.ARMOR_PENETRATION_BUFF);
    }

    @Override
    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        GameLight light = level.getLightLevel(x / 32, y / 32);

        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        drawY += getBobbing(x, y);

        int dir = getDir();
        if (!hasMultipleSprites) {
            dir = (dir <= 1) ? 1 : 3;
        }

        Point sprite = getAnimSprite(x, y, dir);

        // === Shadow Drawing ===
        final TextureDrawOptions shadow = MobRegistry.Textures.rooster_shadow
            .initDraw()
            .sprite(0, dir, 64)
            .light(light)
            .pos(drawX, drawY);

        tileList.add(new MobDrawable() {
            @Override
            public void draw(TickManager tickManager) {
                shadow.draw();
            }
        });

        // === Mob Drawing ===
        drawY += getLevel().getTile(x / 32, y / 32).getMobSinkingAmount(this);

        final MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        final DrawOptions options = texture.initDraw()
            .sprite(sprite.x, sprite.y, 64)
            .light(light)
            .addMaskShader(swimMask)
            .pos(drawX, drawY);

        list.add(new MobDrawable() {
            @Override
            public void draw(TickManager tickManager) {
                swimMask.use();
                options.draw();
                swimMask.stop();
            }
        });
    }
}

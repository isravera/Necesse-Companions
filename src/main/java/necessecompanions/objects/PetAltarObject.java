package necessecompanions.objects;

import necessecompanions.ModEntryPoint;
import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.localization.Localization;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.util.GameUtils;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.texture.TextureDrawOptions;
import necesse.gfx.drawables.LevelSortedDrawable;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item.Rarity;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Tech;
import necesse.level.gameObject.container.CraftingStationObject;
import necesse.level.gameObject.container.CraftingStationUpgrade;
import necesse.level.gameObject.ObjectHoverHitbox;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

import java.awt.*;
import java.util.List;

public class PetAltarObject extends CraftingStationObject {
    public GameTexture texture;
    private final String altarType;

    public PetAltarObject(String altarType) {
        super(new Rectangle(6, 6, 20, 20));
        this.displayMapTooltip = true;
        this.stackSize = 1;
        this.objectHealth = 100;
        this.isLightTransparent = true;

        if(altarType.equals("stone")) {
            this.mapColor = new Color(107, 101, 137);
            this.rarity = Rarity.UNCOMMON;
        } else if(altarType.equals("demonic")) {
            this.mapColor = new Color(88, 74, 127);
            this.rarity = Rarity.RARE;
        } else {
            this.mapColor = new Color(53, 54, 69);
            this.rarity = Rarity.EPIC;
        }

        this.altarType = altarType;
    }

    @Override
    public void addDrawables(List<LevelSortedDrawable> list, OrderableDrawables tileList, Level level, int tileX, int tileY, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        GameLight light = level.getLightLevel(tileX, tileY);
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        int sprite = GameUtils.getAnim(level.getWorldEntity().getTime() + getTileSeed(tileX, tileY, 52), 4, 1200);
        final TextureDrawOptions options = this.texture.initDraw().sprite(sprite, 0, 64, this.texture.getHeight()).light(light).pos(drawX - 16, drawY - (this.texture.getHeight() - 32));
        list.add(new LevelSortedDrawable(this, tileX, tileY) {
            @Override
            public int getSortY() {
                return 16;
            }

            @Override
            public void draw(TickManager tickManager) {
                options.draw();
            }
        });
    }

    @Override
    public void drawPreview(Level level, int tileX, int tileY, int rotation, float alpha, PlayerMob player, GameCamera camera) {
        int drawX = camera.getTileDrawX(tileX);
        int drawY = camera.getTileDrawY(tileY);
        this.texture.initDraw().sprite(0, 0, 64, this.texture.getHeight()).alpha(alpha).draw(drawX - 16, drawY - (this.texture.getHeight() - 32));
    }

    @Override
    public Tech[] getCraftingTechs() {

        if(this.altarType.equals("stone")) return new Tech[]{ModEntryPoint.PET_ALTAR_STONE};

        if(this.altarType.equals("demonic")) return new Tech[]{ModEntryPoint.PET_ALTAR_DEMONIC, ModEntryPoint.PET_ALTAR_STONE};

        return new Tech[]{ModEntryPoint.PET_ALTAR_TUNGSTEN, ModEntryPoint.PET_ALTAR_DEMONIC, ModEntryPoint.PET_ALTAR_STONE};
    }

    @Override
    public List<ObjectHoverHitbox> getHoverHitboxes(Level level, int layerID, int tileX, int tileY) {
        List<ObjectHoverHitbox> list = super.getHoverHitboxes(level, layerID, tileX, tileY);
        list.add(new ObjectHoverHitbox(layerID, tileX, tileY, 0, -32, 32, 64));
        return list;
    }

    @Override
    public ListGameTooltips getItemTooltips(InventoryItem item, PlayerMob perspective) {
        ListGameTooltips tooltips = super.getItemTooltips(item, perspective);
        tooltips.add(Localization.translate("tooltip", "pet_altar_tip"));
        tooltips.add(Localization.translate("global", "name"));
        return tooltips;
    }

    @Override
    public CraftingStationUpgrade getStationUpgrade() {

        if(this.altarType.equals("stone")) {
            return new CraftingStationUpgrade(
                    ObjectRegistry.getObject("demonic_pet_altar"), new Ingredient[]{
                    new Ingredient("demonicbar", 5)
            }
            );
        }

        if(this.altarType.equals("demonic")) {
            return new CraftingStationUpgrade(
                    ObjectRegistry.getObject("tungsten_pet_altar"), new Ingredient[]{
                    new Ingredient("tungstenbar", 15)
            }
            );
        }

        return null;
    }

    @Override
    public void loadTextures() {
        super.loadTextures();
        this.texture = GameTexture.fromFile("objects/" + this.altarType + "_altar");
    }
}

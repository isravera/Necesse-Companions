package necessecompanions.items;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.matItem.MatItem;
import necessecompanions.utils.CustomCategories;

public class PetCraftItem extends MatItem {

    private final String tooltip;

    public PetCraftItem(Rarity rarity, int stackSize, String tooltip) {
        super(stackSize, rarity);
        this.tooltip = tooltip;
        this.setItemCategory(ItemCategory.craftingManager, CustomCategories.Ingredients);
    }

    public PetCraftItem(Rarity rarity, String tooltip) {
        super(100, rarity);
        this.tooltip = tooltip;
        this.setItemCategory(ItemCategory.craftingManager, CustomCategories.Ingredients);
    }

    public PetCraftItem(String tooltip) {
        super(100, Rarity.RARE);
        this.tooltip = tooltip;
        this.setItemCategory(ItemCategory.craftingManager, CustomCategories.Ingredients);
    }

    @Override
    public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
        ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
        tooltips.add(Localization.translate("tooltip", this.tooltip));
        tooltips.add(Localization.translate("global", "name"));
        return tooltips;
    }

    @Override
    protected void loadItemTextures()  {
        this.itemTexture = GameTexture.fromFile("items/pet_ingredients/" + this.getStringID());
    }
}
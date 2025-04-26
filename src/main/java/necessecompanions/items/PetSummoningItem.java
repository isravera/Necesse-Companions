package necessecompanions.items;

import necesse.engine.localization.Localization;
import necesse.entity.mobs.Attacker;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.ItemCategory;
import necesse.inventory.item.placeableItem.followerSummonItem.petFollowerPlaceableItem.PetFollowerPlaceableItem;
import necessecompanions.utils.CustomCategories;

public class PetSummoningItem extends PetFollowerPlaceableItem {

    public PetSummoningItem(String petToSummon, String...categories) {
        super(petToSummon, Rarity.RARE);
        this.setItemCategory(CustomCategories.baseCategory, categories[0]);
        this.setItemCategory(ItemCategory.craftingManager, categories);
        this.keyWords.add("pet");
    }

    @Override
    protected ListGameTooltips getAnimalTooltips(InventoryItem item, Attacker attacker) {
        ListGameTooltips tooltips = super.getAnimalTooltips(item, attacker);
        tooltips.add(Localization.translate("global", "name"));
        return tooltips;
    }

    @Override
    protected void loadItemTextures()  {
        this.itemTexture = GameTexture.fromFile("items/summon_items/" + this.getStringID());
    }
}

package com.project.rpg.models.items.enhancement.healing;

import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.powers.Life;

/**
 * Created by laetitia on 4/27/15.
 */
public abstract class AbstractHealing extends AbstractItem {

    private static final long serialVersionUID = -373216204069937455L;
    
    private Life mLifePower;

    protected AbstractHealing(String name, int lifePointsRestored) {
        super(name);
        mLifePower = new Life(lifePointsRestored);
    }

    // TODO the healing power!!

    @Override
    protected void setItemType() {
        mItemType = ItemType.HEALING;
    }

    public int getRestoredLifePoints(){
        return (int) mLifePower.getPowerEffect();
    }

    @Override
    public void use(AbstractCharacter character) {
        ((AbstractFighter)character).addLife(getRestoredLifePoints());
    }
}

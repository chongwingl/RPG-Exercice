package com.project.rpg.activities;

import com.project.rpg.models.characters.fighters.AbstractFighter;

/**
 * Created by laetitia on 6/29/15.
 */
public class FighterBagActivity extends AbstractBagActivity {

    @Override
    protected int getCharacterLife() {
        return ((AbstractFighter)getCharacter()).getLife();
    }
}

package com.project.rpg.activities;

import com.project.rpg.adapters.CharacterActionPagerAdapter;
import com.project.rpg.adapters.FighterActionPagerAdapter;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActivity extends CharacterActivity {

    @Override
    protected CharacterActionPagerAdapter getCharacterAdapter() {
        return new FighterActionPagerAdapter(mFragmentManager, this);
    }
}

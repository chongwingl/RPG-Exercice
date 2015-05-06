package com.project.rpg.activities;

import com.project.rpg.adapters.AbstractCharacterActionPagerAdapter;
import com.project.rpg.adapters.FighterActionPagerAdapter;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActivity extends AbstractCharacterActivity {

    @Override
    protected AbstractCharacterActionPagerAdapter getCharacterAdapter() {
        return new FighterActionPagerAdapter(mFragmentManager, this);
    }
}

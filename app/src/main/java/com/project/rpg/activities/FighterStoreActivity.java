package com.project.rpg.activities;

import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.adapters.FighterStorePagerAdapter;
import com.project.rpg.models.stores.FighterStoreBuilder;

/**
 * Created by laetitia on 5/6/15.
 */
public class FighterStoreActivity extends AbstractStoreActivity {


    @Override
    public void setStoreBuilder() {
        builder = new FighterStoreBuilder(this);
    }

    @Override
    protected AbstractItemCategoryPagerAdapter getAdapter() {
        return new FighterStorePagerAdapter(getSupportFragmentManager(), this, (FighterStoreBuilder) builder);
    }
}

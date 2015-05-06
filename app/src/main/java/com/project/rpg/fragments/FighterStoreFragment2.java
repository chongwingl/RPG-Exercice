package com.project.rpg.fragments;

import com.project.rpg.adapters.FighterStorePagerAdapter;
import com.project.rpg.adapters.ItemCategoryPagerAdapter;
import com.project.rpg.models.stores.FighterStoreBuilder;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterStoreFragment2 extends StoreFragment2 {

    @Override
    protected ItemCategoryPagerAdapter getAdapter() {
        return new FighterStorePagerAdapter(getFragmentManager(), getActivity(), (FighterStoreBuilder) builder);
    }

    @Override
    public void setStoreBuilder() {
        builder = new FighterStoreBuilder(getActivity());
    }
}

package com.project.rpg.fragments;

import com.project.rpg.adapters.FighterStorePagerAdapter;
import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.models.stores.FighterStoreBuilder;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterStoreFragment extends AbstractStoreFragment {

    @Override
    protected AbstractItemCategoryPagerAdapter getAdapter() {
        return new FighterStorePagerAdapter(getFragmentManager(), getActivity(), (FighterStoreBuilder) builder);
    }

    @Override
    public void setStoreBuilder() {
        builder = new FighterStoreBuilder(getActivity());
    }
}

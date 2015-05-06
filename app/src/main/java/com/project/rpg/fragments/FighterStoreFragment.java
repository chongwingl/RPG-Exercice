package com.project.rpg.fragments;

import com.project.rpg.models.stores.FighterStoreBuilder;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterStoreFragment extends StoreFragment {

    @Override
    protected void setStoreBuilder() {
        mStoreBuilder = new FighterStoreBuilder(getActivity());
    }


}

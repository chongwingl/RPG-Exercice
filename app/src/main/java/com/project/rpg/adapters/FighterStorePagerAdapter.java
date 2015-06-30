package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.project.rpg.activities.AbstractStoreActivity;
import com.project.rpg.fragments.StoreItemListFragment;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.stores.FighterStoreBuilder;

/**
 * Created by laetitia on 5/6/15.
 */
public class FighterStorePagerAdapter extends AbstractStorePagerAdapter {

    private FighterStoreBuilder mBuilder;

    public FighterStorePagerAdapter(FragmentManager fm, Activity activity, FighterStoreBuilder builder) {
        super(fm, activity, builder.getCategories());
        mBuilder = builder;
    }


    @Override
    public Fragment getItem(int position) {
        ItemType type = ItemType.getItemTypeByName(mActivity, mTitles[position]);
        StoreItemListFragment fragment =  StoreItemListFragment.newInstance(
                mBuilder.buildCategory(type)
        );
        fragment.setListener((AbstractStoreActivity)mActivity);
        return fragment;
    }

}

package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

/**
 * Created by laetitia on 5/5/15.
 */
public abstract class AbstractStorePagerAdapter extends AbstractItemCategoryPagerAdapter {

    protected Activity mActivity;

    public AbstractStorePagerAdapter(FragmentManager fm, Activity activity, String[] categories) {
        super(fm);
        mTitles = categories;
        mActivity = activity;
    }

    @Override
    protected int getCategoryNumber() {
        return mTitles.length;
    }

}

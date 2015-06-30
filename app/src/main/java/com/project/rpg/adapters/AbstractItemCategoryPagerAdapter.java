package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class AbstractItemCategoryPagerAdapter extends FragmentPagerAdapter {

    protected String [] mTitles;
    protected Activity mActivity;

    public AbstractItemCategoryPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return getCategoryNumber();
    }

    protected abstract int getCategoryNumber();

    @Override
    public CharSequence getPageTitle(int position) {
       return mTitles[position];
    }

    public void reset() {
        mTitles = null;
    }

}

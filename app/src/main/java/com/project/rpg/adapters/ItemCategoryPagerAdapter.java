package com.project.rpg.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class ItemCategoryPagerAdapter extends FragmentPagerAdapter {

    protected String [] mTitles;

    public ItemCategoryPagerAdapter(FragmentManager fm) {
        super(fm);
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

}

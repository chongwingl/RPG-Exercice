package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class AbstractCharacterActionPagerAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_NUMBER = 4;

    protected String [] titles;

    protected Activity mActivity;

    public AbstractCharacterActionPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        mActivity = activity;
        setTitleList();
    }

    @Override
    public int getCount() {
        return FRAGMENT_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return titles[position];
    }

    protected abstract void setTitleList();

}

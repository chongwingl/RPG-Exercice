package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.project.rpg.R;
import com.project.rpg.fragments.BagFragment;
import com.project.rpg.fragments.FighterStoreFragment2;
import com.project.rpg.fragments.knight.KnighStateFragment;
import com.project.rpg.fragments.knight.KnightActionFragment;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActionPagerAdapter extends CharacterActionPagerAdapter {

    public FighterActionPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm, activity);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return new KnightActionFragment();
            case 1 :
                return new KnighStateFragment();
            case 2 :
                return new BagFragment();
            case 3 :
                return new FighterStoreFragment2();
            default:
                return new KnightActionFragment();
        }
    }

    @Override
    protected void setTitleList() {
        titles = mActivity.getResources().getStringArray(R.array.fighter_tab_title);
    }
}

package com.project.rpg.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.project.rpg.activities.AbstractBagActivity;
import com.project.rpg.core.RPGApplication;
import com.project.rpg.fragments.BagItemListFragment;
import com.project.rpg.models.Bag;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.items.ItemType;

import java.util.List;


/**
 * Created by laetitia on 5/11/15.
 */
public class BagPagerAdapter extends AbstractItemCategoryPagerAdapter {

    private final int categoryNumber;

    public BagPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm, activity);
        AbstractCharacter character = ((RPGApplication) activity.getApplication()).getCharacter();
        Bag bag = character.getBag();
        List<String> itemTypeList = bag.getItemTypes(activity);
        mTitles = new String[itemTypeList.size()];
        mTitles = itemTypeList.toArray(mTitles);
        categoryNumber = mTitles.length;
    }

    @Override
    protected int getCategoryNumber() {
        return categoryNumber;
    }

    @Override
    public Fragment getItem(int position) {
        BagItemListFragment fragment =  BagItemListFragment.newInstance(
                ItemType.getItemTypeByName(mActivity, mTitles[position])
        );
        fragment.setListener((AbstractBagActivity)mActivity);
        return fragment;
    }
}

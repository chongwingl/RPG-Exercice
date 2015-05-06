package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.project.rpg.R;
import com.project.rpg.adapters.ItemCategoryPagerAdapter;
import com.project.rpg.models.enumerations.Character;
import com.project.rpg.utils.PreferencesHelper;
import com.project.rpg.widgets.SlidingTabLayout;

import butterknife.InjectView;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class ShowCategoryItemFragment extends AbstractFragment {


    @InjectView(R.id.item_list_pager)
    ViewPager mItemViewPager;

    @InjectView(R.id.item_category_sliding_layout)
    SlidingTabLayout mSlidingTabLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final PreferencesHelper preferencesHelper = PreferencesHelper.getInstance(getActivity());

        final Character character = Character.getCharacterByType(preferencesHelper.getCharacterType());

        final ItemCategoryPagerAdapter mItemCategoryAdapter = getAdapter();
        mItemViewPager.setAdapter(mItemCategoryAdapter);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(character.getColorId());
            }


        });
        mSlidingTabLayout.setViewPager(mItemViewPager);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_category_item;
    }

    @Override
    public String getTAG() {
        return getClass().getSimpleName();
    }

    protected abstract ItemCategoryPagerAdapter getAdapter();
}

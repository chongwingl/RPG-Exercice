package com.project.rpg.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.project.rpg.R;
import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.widgets.SlidingTabLayout;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public abstract class AbstractShowCategoryItemActivity extends AbstractActivity {

    @InjectView(R.id.item_list_pager)
    ViewPager mItemViewPager;

    @InjectView(R.id.item_category_sliding_layout)
    SlidingTabLayout mSlidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AbstractCharacter character = getApp().getCharacter();

        final CharacterType characterType = character.getCharacterType();

        final AbstractItemCategoryPagerAdapter mItemCategoryAdapter = getAdapter();
        if (mItemCategoryAdapter != null) {
            mItemViewPager.setAdapter(mItemCategoryAdapter);

            mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                @Override
                public int getIndicatorColor(int position) {
                    return getResources().getColor(characterType.getColorId());
                }


            });
            mSlidingTabLayout.setViewPager(mItemViewPager);
        }
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_category_item;
    }

    protected abstract AbstractItemCategoryPagerAdapter getAdapter();
}

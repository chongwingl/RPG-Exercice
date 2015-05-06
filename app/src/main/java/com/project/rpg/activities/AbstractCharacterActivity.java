package com.project.rpg.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.adapters.AbstractCharacterActionPagerAdapter;
import com.project.rpg.fragments.CharacterCreationFragment;
import com.project.rpg.interfaces.OnFragmentFinished;
import com.project.rpg.models.enumerations.Character;
import com.project.rpg.utils.PreferencesHelper;
import com.project.rpg.widgets.SlidingTabLayout;

import butterknife.InjectView;

public abstract class AbstractCharacterActivity extends AbstractActivity implements OnFragmentFinished {

    private final static String CHARACTER_CREATION = "CHARACTER_CREATION";

    private boolean mIsCreating = true;

    protected final FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mCreationFragment = null;
    private PreferencesHelper preferencesHelper;

    @InjectView(R.id.character_pager)
    ViewPager mCharacterActionViewPager;

    @InjectView(R.id.character_sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @InjectView(R.id.character_title)
    TextView mCharacterTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferencesHelper = PreferencesHelper.getInstance(this);

        final Character character = Character.getCharacterByType(preferencesHelper.getCharacterType());

        final AbstractCharacterActionPagerAdapter mAbstractCharacterActionPagerAdapter = getCharacterAdapter();

        mCharacterActionViewPager.setAdapter(mAbstractCharacterActionPagerAdapter);
//        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(character.getColorId());
            }


        });
        mSlidingTabLayout.setViewPager(mCharacterActionViewPager);

        if (!TextUtils.isEmpty(preferencesHelper.getCharacterName())) {
            mCharacterTitle.setText(preferencesHelper.getCharacterName());
        }

        if (savedInstanceState == null && TextUtils.isEmpty(preferencesHelper.getCharacterName())) {
              mCreationFragment = new CharacterCreationFragment();
        } else if (savedInstanceState != null){
            mIsCreating = savedInstanceState.getBoolean(CHARACTER_CREATION, true);
          if (mIsCreating) {
              mCreationFragment = mFragmentManager.findFragmentByTag(CharacterCreationFragment.TAG);
          }
        }

        if (mCreationFragment != null) {
            mFragmentManager.beginTransaction()
                    .add(R.id.character_container, mCreationFragment, CharacterCreationFragment.TAG)
                    .commit();
        }
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_character;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(CHARACTER_CREATION, mIsCreating);
    }

    @Override
    public void onFragmentCreationFinished() {
        mIsCreating = false;
        mCharacterTitle.setText(preferencesHelper.getCharacterName());
        mFragmentManager.beginTransaction()
                .remove(mCreationFragment)
                .commit();
    }

    protected abstract AbstractCharacterActionPagerAdapter getCharacterAdapter();
}
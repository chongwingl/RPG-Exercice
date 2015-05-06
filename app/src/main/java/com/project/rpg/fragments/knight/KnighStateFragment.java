package com.project.rpg.fragments.knight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.fragments.AbstractFragment;
import com.project.rpg.utils.PreferencesHelper;

import butterknife.InjectView;


public class KnighStateFragment extends AbstractFragment {

    @InjectView(R.id.level)
    TextView mLevel;

    @InjectView(R.id.gold)
    TextView mGold;

    @InjectView(R.id.life)
    TextView mLife;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = super.onCreateView(inflater, container, savedInstanceState);

        PreferencesHelper helper = PreferencesHelper.getInstance(getActivity());

        if (helper.getCharacterLevel() != -1) {
            mLevel.setText("" + helper.getCharacterLevel());
        }

        if (helper.getCharacterGold() != -1) {
            mGold.setText("" + helper.getCharacterGold());
        }

        if (helper.getCharacterLife() != -1) {
            mLife.setText("" + helper.getCharacterLife());
        }

        return fragmentView;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_fighter_state;
    }

    @Override
    public String getTAG() {
        return getClass().getSimpleName();
    }
}

package com.project.rpg.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.utils.PreferencesHelper;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public class StateActivity extends AbstractActivity {

    @InjectView(R.id.level)
    TextView mLevel;

    @InjectView(R.id.gold)
    TextView mGold;

    @InjectView(R.id.life)
    TextView mLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferencesHelper helper = PreferencesHelper.getInstance(this);

        if (helper.getCharacterLevel() != -1) {
            mLevel.setText("" + helper.getCharacterLevel());
        }

        if (helper.getCharacterGold() != -1) {
            mGold.setText("" + helper.getCharacterGold());
        }

        if (helper.getCharacterLife() != -1) {
            mLife.setText("" + helper.getCharacterLife());
        }
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_state;
    }
}

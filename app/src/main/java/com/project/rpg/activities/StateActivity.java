package com.project.rpg.activities;

import android.widget.TextView;

import com.project.rpg.R;

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

    @InjectView(R.id.strength)
    TextView mStrength;

    @InjectView(R.id.speed)
    TextView mSpeed;

    @InjectView(R.id.resistance)
    TextView mResistance;

    @InjectView(R.id.accuracy)
    TextView mAccuracy;

    @InjectView(R.id.head)
    TextView mHead;

    @InjectView(R.id.body)
    TextView mBody;

    @InjectView(R.id.legs)
    TextView mLegs;

    @InjectView(R.id.foot)
    TextView mFoot;

    @InjectView(R.id.left_hand)
    TextView mLeftHand;

    @InjectView(R.id.right_hand)
    TextView mRightHand;


    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_state;
    }
}

package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.intents.FightingIntent;
import com.project.rpg.models.monsters.AbstractMonster;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laetitia on 5/14/15.
 */
public class MonsterDetailFragment extends AbstractFragment {

    private static final String ARG_MONSTER = "ARG_MONSTER";

    @InjectView(R.id.life)
    TextView mLife;

    @InjectView(R.id.strength)
    TextView mStrength;

    @InjectView(R.id.accuracy)
    TextView mAccuracy;

    @InjectView(R.id.resistance)
    TextView mResistance;

    @InjectView(R.id.speed)
    TextView mSpeed;

    private AbstractMonster mMonster;

    public static MonsterDetailFragment getInstance(AbstractMonster monster) {
        MonsterDetailFragment fragment = new MonsterDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_MONSTER, monster);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMonster = (AbstractMonster) getArguments().getSerializable(ARG_MONSTER);
        mLife.setText("" + mMonster.getLife());
        mAccuracy.setText("" + mMonster.getAccuracy());
        mResistance.setText("" + mMonster.getResistance());
        mSpeed.setText("" + mMonster.getSpeed());
        mStrength.setText("" + mMonster.getStrength());
    }

    @OnClick(R.id.fight_button)
    void onFightClick(){
        FightingIntent intent = new FightingIntent(getActivity(), mMonster);
        getActivity().getSupportFragmentManager().beginTransaction()
                .remove(this)
                .commit();
        startActivity(intent);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_monster_detail;
    }

    @Override
    public String getTAG() {
        return getClass().getSimpleName();
    }
}

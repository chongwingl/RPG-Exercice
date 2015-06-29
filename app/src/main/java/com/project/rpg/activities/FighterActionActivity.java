package com.project.rpg.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.project.rpg.R;
import com.project.rpg.fragments.MonsterDetailFragment;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.models.monsters.MonsterBuilder;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by laetitia on 5/6/15.
 */
public class FighterActionActivity extends ActionActivity {

    private AbstractMonster mMonsterChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AbstractFighter fighter = (AbstractFighter) getApp().getCharacter();
        MonsterBuilder mMonsterBuilder = new MonsterBuilder(fighter.getStat());

        AbstractMonster monster1 = mMonsterBuilder.buildWeakMonster(this);
        AbstractMonster monster2 = mMonsterBuilder.buildNormalMonster(this);
        AbstractMonster monster3 = mMonsterBuilder.buildStrongMonster(this);

        mAction1.setText(monster1.getName());
        mAction1.setTag(monster1);
        mAction2.setText(monster2.getName());
        mAction2.setTag(monster2);
        mAction3.setText(monster3.getName());
        mAction3.setTag(monster3);

    }

    @OnClick(R.id.action1)
    void onAction1Selected(View v){
        mMonsterChosen = (AbstractMonster) v.getTag();
        showFragment(mMonsterChosen);
    }

    @OnClick(R.id.action2)
    void onAction2Selected(View v){
        mMonsterChosen = (AbstractMonster) v.getTag();
        showFragment(mMonsterChosen);
    }

    @OnClick(R.id.action3)
    void onAction3Selected(View v){
        mMonsterChosen = (AbstractMonster) v.getTag();
        showFragment(mMonsterChosen);
    }

    private void showFragment(AbstractMonster monster){
        MonsterDetailFragment fragment = MonsterDetailFragment.getInstance(monster);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_container, fragment, fragment.getTAG())
                .commit();
    }

    @Override
    public void onBackPressed() {
        boolean isFragmentAdded = false;
        List<Fragment> fragments =  getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof MonsterDetailFragment) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragment)
                            .commit();
                    isFragmentAdded = true;
                }
            }
        }
        if (!isFragmentAdded) {
            super.onBackPressed();
        }
    }

    @Override
    protected int getCharacterLife() {
        return ((AbstractFighter)getCharacter()).getLife();
    }
}

package com.project.rpg.activities;

import android.os.Bundle;

import com.project.rpg.R;
import com.project.rpg.models.characters.fighters.AbstractFighter;

/**
 * Created by laetitia on 5/6/15.
 */
public class FighterStateActivity extends StateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AbstractFighter character = (AbstractFighter) getApp().getCharacter();
        mStrength.setText("" + character.getStat().getStrength());
        mSpeed.setText("" + character.getStat().getSpeed());
        mResistance.setText("" + character.getStat().getResistance());
        mAccuracy.setText("" + character.getStat().getAccuracy());

        if (character.getHeadArmor() == null) {
            mHead.setText(R.string.no_equipment);
        } else {
            mHead.setText(character.getHeadArmor().getName());
        }

        if (character.getBodyArmor() == null) {
            mBody.setText(R.string.no_equipment);
        } else {
            mBody.setText(character.getBodyArmor().getName());
        }

        if (character.getLegArmor() == null) {
            mLegs.setText(R.string.no_equipment);
        } else {
            mLegs.setText(character.getLegArmor().getName());
        }

        if (character.getFootArmor() == null) {
            mFoot.setText(R.string.no_equipment);
        } else {
            mFoot.setText(character.getFootArmor().getName());
        }

        if (character.getRightWeapon() == null) {
            mRightHand.setText(R.string.no_equipment);
        } else {
            mRightHand.setText(character.getRightWeapon().getName());
        }

        if (character.getLeftWeapon() == null) {
            mLeftHand.setText(R.string.no_equipment);
        } else {
            mLeftHand.setText(character.getLeftWeapon().getName());
        }

    }

    @Override
    protected int getCharacterLife() {
        return ((AbstractFighter)getCharacter()).getLife();
    }
}

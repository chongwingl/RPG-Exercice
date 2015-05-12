package com.project.rpg.activities;

import android.os.Bundle;

import com.project.rpg.R;
import com.project.rpg.models.Equipment;
import com.project.rpg.models.characters.fighters.AbstractFighter;

/**
 * Created by laetitia on 5/6/15.
 */
public class FighterStateActivity extends StateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AbstractFighter character = (AbstractFighter) getApp().getCharacter();
        mLevel.setText("" + character.getLevel());
        mGold.setText("" + character.getGold());
        mLife.setText("" + character.getLife());
        mStrength.setText("" + character.getStat().getStrength());
        mSpeed.setText("" + character.getStat().getSpeed());
        mResistance.setText("" + character.getStat().getResistance());
        mAccuracy.setText("" + character.getStat().getAccuracy());

        Equipment equipment = character.getEquipment();

        if (equipment.getHeadArmor() == null) {
            mHead.setText(R.string.no_equipment);
        } else {
            mHead.setText(equipment.getHeadArmor().getName());
        }

        if (equipment.getBodyArmor() == null) {
            mBody.setText(R.string.no_equipment);
        } else {
            mBody.setText(equipment.getBodyArmor().getName());
        }

        if (equipment.getLegArmor() == null) {
            mLegs.setText(R.string.no_equipment);
        } else {
            mLegs.setText(equipment.getLegArmor().getName());
        }

        if (equipment.getFootArmor() == null) {
            mFoot.setText(R.string.no_equipment);
        } else {
            mFoot.setText(equipment.getFootArmor().getName());
        }

        if (equipment.getRightWeapon() == null) {
            mRightHand.setText(R.string.no_equipment);
        } else {
            mRightHand.setText(equipment.getRightWeapon().getName());
        }

        if (equipment.getLeftWeapon() == null) {
            mLeftHand.setText(R.string.no_equipment);
        } else {
            mLeftHand.setText(equipment.getLeftWeapon().getName());
        }

    }
}

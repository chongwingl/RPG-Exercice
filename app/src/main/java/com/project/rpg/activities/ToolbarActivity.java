package com.project.rpg.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.models.characters.AbstractCharacter;

import butterknife.InjectView;

/**
 * Created by laetitia on 6/29/15.
 */
public abstract class ToolbarActivity extends AbstractActivity {

    @InjectView(R.id.header_character_name)
    TextView mCharacterName;

    @InjectView(R.id.header_life)
    TextView mCharacterLife;

    @InjectView(R.id.header_gold)
    TextView mCharacterGold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AbstractCharacter character = getCharacter();

        if (character != null) {
            mCharacterName.setText(character.getName());
            mCharacterLife.setText(String.valueOf(getCharacterLife()));
            mCharacterGold.setText(String.valueOf(character.getGold()));
        }

    }

    protected abstract int getCharacterLife();

    protected void setCharacterInfo(String name, int life, int gold) {
        mCharacterName.setText(name);
        mCharacterLife.setText(String.valueOf(life));
        mCharacterGold.setText(String.valueOf(gold));
    }

    protected void setCharacterLife(int life) {
        mCharacterLife.setText(String.valueOf(life));
    }
}

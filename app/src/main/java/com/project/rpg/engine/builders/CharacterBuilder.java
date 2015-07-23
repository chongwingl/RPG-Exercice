package com.project.rpg.engine.builders;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.database.CharacterDatabaseHelper;
import com.project.rpg.engine.model.Character;
import com.project.rpg.engine.model.CharacterStat;

/**
 * Created by laetitia on 7/13/15.
 */
public class CharacterBuilder extends ContextWrapper {

    private static final int DEFAULT_STAT = 0;

    private CharacterDatabaseHelper mCharacterDbHelper;

    public CharacterBuilder(Context context) {
        super(context);
        mCharacterDbHelper = new CharacterDatabaseHelper(context);
    }

    public Character build(String name) {
        Character character = new Character(getBaseContext(), name);
        character.addGold(200);
        character.initMaxLife(100);
        character.setLevel("Debutant");
        CharacterStat stat = new CharacterStat();
        stat.addAccuracy(DEFAULT_STAT);
        stat.addAgility(DEFAULT_STAT);
        stat.addDexterity(DEFAULT_STAT);
        stat.addResistance(DEFAULT_STAT);
        stat.addSpeed(DEFAULT_STAT);
        stat.addStrength(DEFAULT_STAT);
        character.setStat(stat);
        return character;
    }

    public Character build(){
        Character character = new Character(getBaseContext());


        return character;
    }


}

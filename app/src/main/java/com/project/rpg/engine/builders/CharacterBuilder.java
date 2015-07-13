package com.project.rpg.engine.builders;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.database.CharacterDatabaseHelper;
import com.project.rpg.engine.model.Character;
import com.project.rpg.utils.RPGPreferences;

/**
 * Created by laetitia on 7/13/15.
 */
public class CharacterBuilder extends ContextWrapper {

    private CharacterDatabaseHelper mCharacterDbHelper;

    public CharacterBuilder(Context context) {
        super(context);
        mCharacterDbHelper = new CharacterDatabaseHelper(context);
    }

    public Character build() {
         RPGPreferences preferences = RPGPreferences.getInstance(getBaseContext());
        if (preferences.getCharacterId() == 1) {
            return null;
        } else {
            return null;
        }
    }


}

package com.project.rpg.models.enumerations;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.activities.FighterActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public enum CharacterClass {

    FIGHTER(R.string.character_type_fighter, FighterActivity.class),
    FARMER(R.string.character_type_farmer, null),
    MONSTER(R.string.character_type_monster, null);

    private int mTypeRefId;
    private Class<?> mCharacterActivity;

    // Constructeur
    CharacterClass(int typeRefId, Class<?> characterActivity) {
        mTypeRefId = typeRefId;
        mCharacterActivity = characterActivity;
    }

    public int getTypeRefId() {
        return mTypeRefId;
    }

    public static CharacterClass getCharacterByType(Context context, String type) {
        for (CharacterClass characterClass : values()) {
            if (context.getString(characterClass.getTypeRefId()).equals(type)) {
                return characterClass;
            }
        }
        return null;
    }

    public Class<?> getCharacterActivity() {
        return mCharacterActivity;
    }
}

package com.project.rpg.models.enumerations;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.activities.FighterActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public enum CharacterType {

    KNIGHT(R.string.character_type_knight, R.color.primary_dark_color, FighterActivity.class),
    SMITH(R.string.character_type_smith, R.color.primary_color, null),
    MONSTER(R.string.character_type_monster, R.color.accent_color, null);

    private int mTypeRefId;
    private int mColorId;
    private Class<?> mCharacterActivity;

    // Constructeur
    CharacterType(int typeRefId, int colorId, Class<?> characterActivity) {
        mTypeRefId = typeRefId;
        mColorId = colorId;
        mCharacterActivity = characterActivity;
    }

    public int getTypeRefId() {
        return mTypeRefId;
    }

    public int getColorId() {
        return mColorId;
    }

    public Class<?> getCharacterActivity() {
        return mCharacterActivity;
    }

    public static CharacterType getCharacterByType(Context context, String type) {
        for(CharacterType characterType : values()) {
            if (context.getString(characterType.getTypeRefId()).equals(type)) {
                return characterType;
            }
        }
        return null;
    }
}

package com.project.rpg.models.enumerations;

import com.project.rpg.R;
import com.project.rpg.activities.FighterActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public enum CharacterType {

    KNIGHT("Chevalier", R.color.primary_dark_color, FighterActivity.class),
    SMITH("Forgeron", R.color.primary_color, null);

    private String mType = "";
    private int mColorId;
    private Class<?> mCharacterActivity;

    // Constructeur
    CharacterType(String type, int colorId, Class<?> characterActivity) {
        mType = type;
        mColorId = colorId;
        mCharacterActivity = characterActivity;
    }

    public String getName() {
        return mType;
    }

    public int getColorId() {
        return mColorId;
    }

    public Class<?> getCharacterActivity() {
        return mCharacterActivity;
    }

    public static CharacterType getCharacterByType(String type) {
        for(CharacterType characterType : values()) {
            if (characterType.getName().equals(type)) {
                return characterType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return mType;
    }
}

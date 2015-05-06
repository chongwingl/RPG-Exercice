package com.project.rpg.models.enumerations;

import com.project.rpg.R;
import com.project.rpg.activities.FighterActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public enum Character {

    KNIGHT("Chevalier", R.color.knight_color, FighterActivity.class),
    SMITH("Forgeron", R.color.smith_color, null),
    UNKNOWN("Unknown", 0, null);

    private String mType = "";
    private int mColorId;
    private Class<?> mCharacterActivity;

    // Constructeur
    Character(String type, int colorId, Class<?> characterActivity) {
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

    public static Character getCharacterByType(String type) {
        for(Character character : values()) {
            if (character.getName().equals(type)) {
                return character;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return mType;
    }
}

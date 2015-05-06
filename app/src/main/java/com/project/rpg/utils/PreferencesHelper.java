package com.project.rpg.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

/**
 * Created by laetitia on 4/20/15.
 */
public final class PreferencesHelper extends ContextWrapper {


    public static final String APP_PREF = "rpg_Prefs";

    private static final String CHARACTER_NAME = "CHARACTER_NAME";
    private static final String CHARACTER_LIFE= "CHARACTER_LIFE";
    private static final String CHARACTER_CLASS = "CHARACTER_CLASS";
    private static final String CHARACTER_LEVEL= "CHARACTER_LEVEL";
    private static final String CHARACTER_GOLD= "CHARACTER_GOLD";

    private static SharedPreferences sPreferences;

    private PreferencesHelper(Context context){
        super(context);
        sPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context) {
        return new PreferencesHelper(context);
    }

    public void setCharacterClass(String characterClass) {
        sPreferences.edit()
                .putString(CHARACTER_CLASS, characterClass)
                .apply();
    }

    public String getCharacterType() {
        return sPreferences.getString(CHARACTER_CLASS, "");
    }

    public void setCharacterName(String name) {
        sPreferences.edit()
                .putString(CHARACTER_NAME, name)
                .apply();
    }

    public String getCharacterName() {
        return sPreferences.getString(CHARACTER_NAME, "");
    }

    public void setCharacterLife(int life) {
        sPreferences.edit()
                .putInt(CHARACTER_LIFE, life)
                .apply();
    }

    public int getCharacterLife() {
        return sPreferences.getInt(CHARACTER_LIFE, -1);
    }

    public void setCharacterLevel(int level) {
        sPreferences.edit()
                .putInt(CHARACTER_LEVEL, level)
                .apply();
    }

    public int getCharacterLevel(){
        return sPreferences.getInt(CHARACTER_LEVEL, -1);
    }

    public void setCharacterGold(int gold) {
        sPreferences.edit()
                .putInt(CHARACTER_GOLD, gold)
                .apply();
    }

    public int getCharacterGold(){
        return sPreferences.getInt(CHARACTER_GOLD, -1);
    }

}

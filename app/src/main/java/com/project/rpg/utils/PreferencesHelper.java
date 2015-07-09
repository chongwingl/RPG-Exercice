package com.project.rpg.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import com.project.rpg.models.characters.AbstractCharacter;

/**
 * Created by laetitia on 7/8/15.
 */
public class PreferencesHelper extends ContextWrapper {

    public static final String APP_PREF = "RPG";
    private static SharedPreferences sPreferences;

    private static final String CHARACTER = "CHARACTER";

    public PreferencesHelper(Context context) {
        super(context);
        sPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context) {
        return new PreferencesHelper(context);
    }

    public void saveCharacter(AbstractCharacter character) {
        sPreferences.edit()
                
                .apply();

    }
}

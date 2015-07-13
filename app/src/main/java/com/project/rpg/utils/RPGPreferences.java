package com.project.rpg.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

/**
 * Created by gguser on 12/8/14.
 */
public final class RPGPreferences extends ContextWrapper {
    public static final String APP_PREF = "rpg";

    private static final int DEFAULT_INT = -1;

    private static final String CHARACTER_ID = "CHARACTER_ID";

    private static SharedPreferences sPreferences;

    private RPGPreferences(Context context) {
        super(context);
        sPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
    }

    public static RPGPreferences getInstance(Context context) {
        return new RPGPreferences(context);
    }

    public void saveCharacterId(int characterId) {
        sPreferences.edit()
                .putInt(CHARACTER_ID, characterId)
                .apply();
    }

    public int getCharacterId() {
        return sPreferences.getInt(CHARACTER_ID, DEFAULT_INT);
    }

}

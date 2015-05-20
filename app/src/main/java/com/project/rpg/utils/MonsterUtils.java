package com.project.rpg.utils;

import android.content.Context;

import com.project.rpg.models.monsters.AbstractMonster;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laetitia on 5/14/15.
 */
public final class MonsterUtils {

    private static final String MONSTER_JSON = "monsters";

    private static List<Class<?>> monstersClass;

    public static void loadMonsters(Context context) {
        try {
            monstersClass = new ArrayList<>();
            JSONArray json = JSONLoaderUtils.getMonstersClass(context).getJSONArray(MONSTER_JSON);

            for (int i = 0; i < json.length(); i++) {
                try {
                    monstersClass.add(Class.forName(json.getString(i)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Class<?>> getMonsters() {
        return monstersClass;
    }

    public static AbstractMonster getMonsterFromClass(Context context, Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor(Context.class);
            return (AbstractMonster) constructor.newInstance(context);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }
}

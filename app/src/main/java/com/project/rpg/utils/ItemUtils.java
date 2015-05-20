package com.project.rpg.utils;

import android.content.Context;

import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laetitia on 5/5/15.
 */
public final class ItemUtils {

    private static final String ITEM_JSON = "items";
    private static final String HEALING_JSON = "healing";
    private static final String WEAPON_JSON = "weapons";
    private static final String MATERIAL_JSON = "material";
    private static final String ARMOR_JSON = "armor";

    private static final List<Class<?>> mHealingClasses = new ArrayList<>();
    private static final List<Class<?>> mWeaponClasses = new ArrayList<>();
    private static final List<Class<?>> mMaterialClasses = new ArrayList<>();
    private static final List<Class<?>> mArmorClasses = new ArrayList<>();

    public static String[] getItemTypes(Context context) {
        String[] itemTypes = new String[ItemType.values().length];
        for (int i = 0; i < itemTypes.length; i++) {
            itemTypes[i] = context.getString(ItemType.values()[i].getNameRefId());
        }

        return itemTypes;
    }

    public static void loadAllItems(Context context) {

        JSONObject json = JSONLoaderUtils.getItemsClass(context);
        try {
            JSONObject items = json.getJSONObject(ITEM_JSON);
            loadHealingItems(items.getJSONArray(HEALING_JSON));
            loadWeaponItems(items.getJSONArray(WEAPON_JSON));
            loadMaterialItems(items.getJSONArray(MATERIAL_JSON));
            loadArmorItems(items.getJSONArray(ARMOR_JSON));
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static List<Class<?>> loadWeaponItems(JSONArray json) throws JSONException {

        if (mWeaponClasses.size() < 1) {

            for (int i = 0; i < json.length(); i++) {
                try {
                    mWeaponClasses.add(Class.forName(json.getString(i)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return mWeaponClasses;
    }

    public static List<Class<?>> getWeaponItems() {
        return mWeaponClasses;
    }

    public static List<Class<?>> loadHealingItems(JSONArray json) throws JSONException {

        if (mHealingClasses.size() < 1) {

            for (int i = 0; i < json.length(); i++) {
                try {
                    mHealingClasses.add(Class.forName(json.getString(i)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return mHealingClasses;
    }

    public static List<Class<?>> getHealingItems() {
        return mHealingClasses;
    }

    public static List<Class<?>> loadArmorItems(JSONArray json) throws JSONException {

        if (mArmorClasses.size() < 1) {

            for (int i = 0; i < json.length(); i++) {
                try {
                    mArmorClasses.add(Class.forName(json.getString(i)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return mArmorClasses;
    }

    public static List<Class<?>> getArmorItems() {
        return mArmorClasses;
    }

    public static List<Class<?>> loadMaterialItems(JSONArray json) throws JSONException {

        if (mMaterialClasses.size() < 1) {

            for (int i = 0; i < json.length(); i++) {
                try {
                    mMaterialClasses.add(Class.forName(json.getString(i)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return mMaterialClasses;
    }

    public static List<Class<?>> getMaterialItems() {
        return mMaterialClasses;
    }

    public static String getItemNameFromClass(Context context, Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor(Context.class);
            AbstractItem abstractItem = (AbstractItem) constructor.newInstance(context);
            return abstractItem.getName();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }

    public static AbstractItem getItemFromClass(Context context, Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor(Context.class);
            return (AbstractItem) constructor.newInstance(context);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }
}

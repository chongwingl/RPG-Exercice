package com.project.rpg.models.stores;

import android.content.Context;
import android.util.Log;

import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterStoreBuilder extends AbstractStoreBuilder {

    public FighterStoreBuilder(Context base) {
        super(base);
    }

    @Override
    public HashMap<String, Class<?>> buildCategory(ItemType itemType) {
        final HashMap<String, Class<?>> itemsList = new HashMap<>();
        List<Class<?>> tempList = new ArrayList<>();
        switch (itemType) {
            case HEALING:
                tempList.addAll(ItemUtils.getHealingItems());
                break;
            case MATERIAL:
                tempList.addAll(ItemUtils.getMaterialItems());
                break;
            case WEAPON:
                tempList.addAll(ItemUtils.getWeaponItems());
                break;
            case ARMOR:
                tempList.addAll(ItemUtils.getArmorItems());
            default:
                break;
        }

        for (Class<?> clss : tempList) {
            itemsList.put(
                    ItemUtils.getItemNameFromClass(getBaseContext(), clss),
                    clss
            );
        }

        return itemsList;
    }

    @Override
    public AbstractItem buildItem(final Class<?> clss) {
        AbstractItem abstractItem;
        try {

            Constructor<?> constructor = clss.getConstructor(Context.class);
            abstractItem = (AbstractItem) constructor.newInstance(getBaseContext());
            return abstractItem;

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("FighterStoreBuilder", e.getMessage());
        }
        return null;
    }

    @Override
    public void setCategoriesExcluded() {
        mCategoriesExcluded = new String[]{
                getBaseContext().getString(ItemType.MATERIAL.getNameRefId())
        };
    }
}

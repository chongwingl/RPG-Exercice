package com.project.rpg.models.stores;

import android.content.Context;
import android.util.Log;

import com.project.rpg.models.enumerations.items.ArmorItem;
import com.project.rpg.models.enumerations.items.HealingItem;
import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.enumerations.items.MaterialItem;
import com.project.rpg.models.enumerations.items.WeaponItem;
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
    public void buildStore(List<String> itemType, HashMap<String, List<String>> items) {

        for (ItemType itemTypeEnum : ItemType.values()) {
            itemType.add(getBaseContext().getString(itemTypeEnum.getNameRefId()));

            List<String> itemsTemp = new ArrayList<>();
            switch (itemTypeEnum) {
                case ARMOR:
                    for (ArmorItem armorItem : ArmorItem.values()) {
                        itemsTemp.add(getBaseContext().getString(armorItem.getNameRefId()));

                    }
                    break;
                case WEAPON:
                    for (WeaponItem weaponItem : WeaponItem.values()) {
                        itemsTemp.add(getBaseContext().getString(weaponItem.getNameRefId()));

                    }
                    break;
                case HEALING:
                    for (HealingItem healingItem : HealingItem.values()) {
                        itemsTemp.add(getBaseContext().getString(healingItem.getNameRefId()));

                    }
                    break;
                case MATERIAL:
                    for (MaterialItem materialItem : MaterialItem.values()) {
                        itemsTemp.add(getBaseContext().getString(materialItem.getNameRefId()));

                    }
                    break;
            }

            items.put(getBaseContext().getString(itemTypeEnum.getNameRefId()), itemsTemp);
        }

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
    public AbstractItem buildItem(String type, String item) {
        AbstractItem abstractItem;
        Class<?> clazz;
        try {
            for (ItemType itemType : ItemType.values()) {
                if (itemType == ItemType.getItemTypeByName(getBaseContext(), type)) {
                    switch (itemType) {
                        case ARMOR:
                            ArmorItem armorItem = ArmorItem.getItemByName(getBaseContext(), item);
                            clazz = armorItem.getClazz();
                            break;
                        case WEAPON:
                            WeaponItem weaponItem = WeaponItem.getItemByName(getBaseContext(), item);
                            clazz = weaponItem.getClazz();
                            break;
                        case MATERIAL:
                            MaterialItem materialItem = MaterialItem.getItemByName(getBaseContext(), item);
                            clazz = materialItem.getClazz();
                            break;
                        case HEALING:
                            HealingItem healingItem = HealingItem.getItemByName(getBaseContext(), item);
                            clazz = healingItem.getClazz();
                            break;
                        default:
                            return null;

                    }
                    Constructor<?> constructor = clazz.getConstructor(Context.class);
                    abstractItem = (AbstractItem) constructor.newInstance(getBaseContext());
                    return abstractItem;

                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("FighterStoreBuilder", e.getMessage());
        }
        return null;
    }

    @Override
    public void setCategoriesExcluded() {
        mCategoriesExcluded = new String [] {
            getBaseContext().getString(ItemType.MATERIAL.getNameRefId())
        };
    }
}

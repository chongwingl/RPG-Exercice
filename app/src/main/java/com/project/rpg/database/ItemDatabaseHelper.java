package com.project.rpg.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.enhancement.healing.AbstractPotion;
import com.project.rpg.models.items.material.AbstractMaterial;
import com.project.rpg.models.items.weapons.AbstractWeapon;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemDatabaseHelper {

    private SQLiteDatabase mDb;
    private final DatabaseHelper mDbHelper;
    private Context mContext;

    public ItemDatabaseHelper(Context context) {
        mDbHelper = new DatabaseHelper(context);
        mContext = context;
    }

    public void saveItem(AbstractArmor armor) {
        mDb = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_NAME_RESISTANCE, armor.getResistance().getValue());
        saveItem(armor, values);

    }

    public void saveItem(AbstractMaterial material) {
        mDb = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        saveItem(material, values);

    }

    public void saveItem(AbstractPotion potion) {
        mDb = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        saveItem(potion, values);
    }

    public void saveItem(AbstractWeapon weapon) {
        mDb = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_NAME_STRENGTH, weapon.getStrength().getValue());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ACCURACY, weapon.getAccuracy().getValue());
        saveItem(weapon, values);

    }

    public void saveItem(AbstractItem item, ContentValues values) {
        values.put(ItemContract.ItemEntry.COLUMN_NAME_CLASS_NAME, item.getClass().toString());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_NAME, item.getName());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PRICE, item.getPrice());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_WEIGHT, item.getWeight().getValue());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE, item.getItemType().getNameRefId());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND, item.getProbabilityToFind().getValue());
        mDb.insert(ItemContract.ItemEntry.TABLE_NAME, null, values);
        mDbHelper.exportDB(mContext);
    }
}

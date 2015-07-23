package com.project.rpg.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.PowerContract;
import com.project.rpg.database.contracts.StatContract;
import com.project.rpg.database.model.MCharacter;
import com.project.rpg.database.model.MEquipped;
import com.project.rpg.database.model.MItemPossessed;
import com.project.rpg.database.model.MStatAttributed;
import com.project.rpg.engine.model.Character;
import com.project.rpg.engine.model.CharacterStat;
import com.project.rpg.engine.model.Item;
import com.project.rpg.models.enumerations.StatType;

import java.util.List;

/**
 * Created by laetitia on 7/8/15.
 */
public class CharacterDatabaseHelper {

    private final DatabaseHelper mDbHelper;

    public CharacterDatabaseHelper(Context context) {
        mDbHelper = new DatabaseHelper(context);
    }

    public long saveCharacter(Context context, Character character) {
        MCharacter mCharacter = new MCharacter();
        mCharacter.setName(character.getName());
        mCharacter.setGold(character.getGold());

        if (character.getAffectedByPower() != null) {
            mCharacter.setPowerId(
                    character.getAffectedByPower().getId()
            );
        }
        mCharacter.setLevelId(getLevelIdByName(character.getLevel()));
        final long characterId = mDbHelper.insertCharacter(mCharacter);

        if (character.getBag().size() > 0) {
            List<Item> items = character.getBag();
            for (Item item : items) {
                MItemPossessed mItemPossessed = new MItemPossessed();
                mItemPossessed.setNumberOfItem(item.getNumberOfItem());
                mItemPossessed.setItemId(item.getId());
                mDbHelper.insertItemPossessed(mItemPossessed);
            }
        }

        if (character.getEquipment().size() > 0) {
            List<Item> items = character.getEquipment();
            for (Item item : items) {
                MEquipped mEquipped = new MEquipped();
                mEquipped.setCharacterId(characterId);
                mEquipped.setItemPossessedId(item.getId());
                mDbHelper.insertEquipped(mEquipped);
            }
        }

        CharacterStat stat = character.getStat();
        final MStatAttributed mStatAttributed = new MStatAttributed();
        mStatAttributed.setCharacterId(characterId);
        mStatAttributed.setValue(stat.getAccuracy());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.ACCURACY.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        mStatAttributed.setValue(stat.getAgility());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.AGILITY.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        mStatAttributed.setValue(stat.getDexterity());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.DEXTERITY.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        mStatAttributed.setValue(stat.getResistance());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.RESISTANCE.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        mStatAttributed.setValue(stat.getSpeed());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.SPEED.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        mStatAttributed.setValue(stat.getStrength());
        mStatAttributed.setStatId(getStatIdByName(context.getString(StatType.STRENGTH.getRefId())));
        mDbHelper.insertStatAttributed(mStatAttributed);

        return characterId;
    }

    public void saveLevel(String name) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LevelContract.LevelEntry.COLUMN_NAME_NAME, name);
        db.insert(LevelContract.LevelEntry.TABLE_NAME, null, values);
    }

    public void saveStat(String name) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StatContract.StatEntry.COLUMN_NAME_NAME, name);
        db.insert(StatContract.StatEntry.TABLE_NAME, null, values);
    }

    public void savePower(String name, String description, int minimumRound, int maximumRound, int percentOfEffect,
                          long statAffected, int probabilityToHappen, String effect){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PowerContract.PowerEntry.COLUMN_NAME_NAME, name);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_DESCRIPTION, description);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_MINIMUM_ROUND, minimumRound);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_MAXIMUM_ROUND, maximumRound);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_PERCENT_OF_EFFECT, percentOfEffect);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_STAT_ID, statAffected);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_PROBABILITY_TO_HAPPEN, probabilityToHappen);
        values.put(PowerContract.PowerEntry.COLUMN_NAME_EFFECT, effect);
        db.insert(PowerContract.PowerEntry.TABLE_NAME, null, values);
    }

    public void saveItem(String name, String description, String itemType, String itemSubtype, int price, long powerId, String slot, int probabilityToFind){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_NAME_NAME, name);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION, description);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE, itemType);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE, itemSubtype);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND, probabilityToFind);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PRICE, price);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_POWER_ID, powerId);
        values.put(ItemContract.ItemEntry.COLUMN_NAME_SLOT, slot);
        db.insert(ItemContract.ItemEntry.TABLE_NAME, null, values);
    }

    public void getCharacter() {
        // TODO change to MCharacter, MItemPossessed, MPower, mLevel, MStatAttributted, MEquipped

    }

    public long getPowerIdByName(String name) {
        final Cursor c = mDbHelper.getPowerByName(name);
        long powerId = 0;
        if (c.moveToFirst()) {
            powerId = c.getLong(c.getColumnIndexOrThrow(PowerContract.PowerEntry._ID));
        }
        c.close();
        return powerId;

    }

    public long getLevelIdByName(String name) {
        final Cursor c = mDbHelper.getLevelByName(name);
        long levelId = 0;
        if (c.moveToFirst()) {
            levelId = c.getLong(c.getColumnIndexOrThrow(LevelContract.LevelEntry._ID));
        }
        c.close();
        return levelId;
    }

    public long getStatIdByName(String name) {
        final Cursor c = mDbHelper.getStatByName(name);
        long statId = 0;
        if (c.moveToFirst()) {
            statId = c.getLong(c.getColumnIndexOrThrow(StatContract.StatEntry._ID));
        }
        c.close();
        return statId;
    }

//    public long getItemId(Item item) {
//        long itemId = 0;
//        MItem mItem = itemToMItem(item);
//
//        final Cursor c = mDbHelper.getSingleItem(mItem);
//        if (c.moveToFirst()) {
//            itemId = c.getLong(c.getColumnIndexOrThrow(ItemContract.ItemEntry._ID));
//        }
//        c.close();
//        return itemId;
//    }
//
//    private MItem itemToMItem(Item item) {
//        MItem mItem = new MItem();
//        mItem.setName(item.getName());
//        mItem.setDescription(item.getDescription());
//        mItem.setItemSubtype(item.getItemSubType());
//        mItem.setItemType(item.getItemType());
//        mItem.setPower(getPowerIdByName(item.getPower()));
//        mItem.setProbabilityToFind(item.getProbability());
//        mItem.setPrice(item.getPrice());
//        mItem.setSlot(item.getSlot());
//        return mItem;
//    }

    public void exportDb(Context context) {
        mDbHelper.exportDB(context);
    }
}

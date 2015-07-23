package com.project.rpg.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import com.project.rpg.database.contracts.CharacterContract;
import com.project.rpg.database.contracts.EquippedContract;
import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.ItemPossessedContract;
import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.PowerContract;
import com.project.rpg.database.contracts.StatAttributedContract;
import com.project.rpg.database.contracts.StatContract;
import com.project.rpg.database.model.MCharacter;
import com.project.rpg.database.model.MEquipped;
import com.project.rpg.database.model.MItem;
import com.project.rpg.database.model.MItemPossessed;
import com.project.rpg.database.model.MStatAttributed;
import com.project.rpg.database.tables.CharacterTable;
import com.project.rpg.database.tables.EquippedTable;
import com.project.rpg.database.tables.ItemPossessedTable;
import com.project.rpg.database.tables.ItemTable;
import com.project.rpg.database.tables.LevelTable;
import com.project.rpg.database.tables.LootTable;
import com.project.rpg.database.tables.MonsterTable;
import com.project.rpg.database.tables.MonsterTypeTable;
import com.project.rpg.database.tables.PowerTable;
import com.project.rpg.database.tables.StatAtributedTable;
import com.project.rpg.database.tables.StatTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * Created by laetitia on 7/8/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "rpg.db";

    private final ArrayList<String> mTablesCreationQuery;
    private final ArrayList<String> mTablesDeletionQuery;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mTablesCreationQuery = new ArrayList<>();
        mTablesDeletionQuery = new ArrayList<>();

        mTablesCreationQuery.add(LevelTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(MonsterTypeTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(StatTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(PowerTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(CharacterTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(MonsterTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ItemTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ItemPossessedTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(StatAtributedTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(LootTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(EquippedTable.SQL_CREATE_ENTRIES);

        mTablesDeletionQuery.add(EquippedTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(LootTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(StatAtributedTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ItemPossessedTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ItemTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(MonsterTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(CharacterTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(PowerTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(StatTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(MonsterTypeTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(LevelTable.SQL_DELETE_ENTRIES);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String query : mTablesCreationQuery) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        for (String query : mTablesDeletionQuery) {
//            db.execSQL(query);
//        }
        onCreate(db);
    }

    /**
     * Write database
     **/

    public long insertCharacter(MCharacter character) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_AFFECTED_BY_POWER_ID, character.getPowerId());
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_GOLD, character.getGold());
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_LEVEL_ID, character.getLevelId());
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_LIFE, character.getLife());
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_MAX_LIFE, character.getMaxLife());
        values.put(CharacterContract.CharacterEntry.COLUMN_NAME_NAME, character.getName());

        return db.insert(CharacterContract.CharacterEntry.TABLE_NAME, null, values);
    }

    public long insertItem(MItem item) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION, item.getDescription());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PRICE, item.getPrice());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE, item.getItemSubtype());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE, item.getItemType());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_NAME, item.getName());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_POWER_ID, item.getPowerId());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND, item.getProbabilityToFind());
        values.put(ItemContract.ItemEntry.COLUMN_NAME_SLOT, item.getSlot());

        return db.insert(ItemContract.ItemEntry.TABLE_NAME, null, values);
    }

    public long insertEquipped(MEquipped equipped) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EquippedContract.EquippedEntry.COLUMN_NAME_ITEM_POSSESSED_ID, equipped.getItemPossessedId());
        values.put(EquippedContract.EquippedEntry.COLUMN_NAME_CHARACTER_ID, equipped.getCharacterId());

        return db.insert(EquippedContract.EquippedEntry.TABLE_NAME, null, values);
    }

    public long insertItemPossessed(MItemPossessed itemPossessed) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_ITEM_ID, itemPossessed.getItemId());
        values.put(ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_NUMBER_OF_ITEM, itemPossessed.getNumberOfItem());

        return db.insert(ItemPossessedContract.ItemPossessedEntry.TABLE_NAME, null, values);
    }

    public long insertStatAttributed(MStatAttributed statAttributed) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StatAttributedContract.StatAttributedEntry.COLUMN_NAME_CHARACTER_ID, statAttributed.getCharacterId());
        values.put(StatAttributedContract.StatAttributedEntry.COLUMN_NAME_ITEM_ID, statAttributed.getItemId());
        values.put(StatAttributedContract.StatAttributedEntry.COLUMN_NAME_MONSTER_ID, statAttributed.getMonsterId());
        values.put(StatAttributedContract.StatAttributedEntry.COLUMN_NAME_STAT_ID, statAttributed.getStatId());
        values.put(StatAttributedContract.StatAttributedEntry.COLUMN_NAME_VALUE, statAttributed.getValue());

        return db.insert(StatAttributedContract.StatAttributedEntry.TABLE_NAME, null, values);
    }

    /**
     * Read database
     **/

    public Cursor getPowerByName(String name) {
        final SQLiteDatabase db = getReadableDatabase();
        final String[] projection = new String[]{
                PowerContract.PowerEntry._ID,
                PowerContract.PowerEntry.COLUMN_NAME_DESCRIPTION,
                PowerContract.PowerEntry.COLUMN_NAME_EFFECT,
                PowerContract.PowerEntry.COLUMN_NAME_MAXIMUM_ROUND,
                PowerContract.PowerEntry.COLUMN_NAME_MINIMUM_ROUND,
                PowerContract.PowerEntry.COLUMN_NAME_NAME,
                PowerContract.PowerEntry.COLUMN_NAME_PERCENT_OF_EFFECT,
                PowerContract.PowerEntry.COLUMN_NAME_PROBABILITY_TO_HAPPEN,
                PowerContract.PowerEntry.COLUMN_NAME_STAT_ID
        };
        final String[] selectionArgs = new String[]{
                name
        };
        return db.query(
                PowerContract.PowerEntry.TABLE_NAME,
                projection,
                PowerContract.PowerEntry.COLUMN_NAME_NAME + "=?",
                selectionArgs,
                null,
                null,
                null
        );
    }

    public Cursor getLevelByName(String name) {
        final SQLiteDatabase db = getReadableDatabase();
        final String[] projection = new String[]{
                LevelContract.LevelEntry._ID,
                LevelContract.LevelEntry.COLUMN_NAME_NAME
        };
        final String[] selectionArgs = new String[]{
                name
        };
        return db.query(
                LevelContract.LevelEntry.TABLE_NAME,
                projection,
                LevelContract.LevelEntry.COLUMN_NAME_NAME + "=?",
                selectionArgs,
                null,
                null,
                null
        );
    }

    public Cursor getStatByName(String name) {
        final SQLiteDatabase db = getReadableDatabase();
        final String[] projection = new String[]{
                StatContract.StatEntry._ID,
                StatContract.StatEntry.COLUMN_NAME_NAME
        };
        final String[] selectionArgs = new String[]{
                name
        };
        return db.query(
                StatContract.StatEntry.TABLE_NAME,
                projection,
                StatContract.StatEntry.COLUMN_NAME_NAME + "=?",
                selectionArgs,
                null,
                null,
                null
        );
    }

    public Cursor getStat() {
        final SQLiteDatabase db = getReadableDatabase();
        final String[] projection = new String[]{
                StatContract.StatEntry._ID,
                StatContract.StatEntry.COLUMN_NAME_NAME
        };
        return db.query(
                StatContract.StatEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getSingleItem(MItem item) {
        final SQLiteDatabase db = getReadableDatabase();
        final String[] projection = new String[]{
                ItemContract.ItemEntry._ID,
                ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION,
                ItemContract.ItemEntry.COLUMN_NAME_PRICE,
                ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE,
                ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE,
                ItemContract.ItemEntry.COLUMN_NAME_NAME,
                ItemContract.ItemEntry.COLUMN_NAME_POWER_ID,
                ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND,
                ItemContract.ItemEntry.COLUMN_NAME_SLOT
        };
        final String [] selectionArgs = new String[]{
                item.getName(),
                item.getSlot(),
                String.valueOf(item.getPowerId()),
                item.getDescription(),
                item.getItemSubtype(),
                item.getItemType(),
                String.valueOf(item.getPrice()),
                String.valueOf(item.getProbabilityToFind())
        };

        final String whereClause = "WHERE " + ItemContract.ItemEntry.COLUMN_NAME_NAME + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_PRICE + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_NAME + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND + "=?" +
                " AND " + ItemContract.ItemEntry.COLUMN_NAME_SLOT + "=?";

        return db.query(
                ItemContract.ItemEntry.TABLE_NAME,
                projection,
                whereClause,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public Cursor getItemPossessed() {
        final SQLiteDatabase db = getReadableDatabase();
        String query = ItemTable.SQL_ITEM_ITEM_POSSESSED_INNER_JOIN;
        return db.rawQuery(query, null);
    }

    public void exportDB(Context context) {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String currentDBPath = "/data/com.project.rpg.fighter/databases/" + DATABASE_NAME;
        String backupDBPath = "arpg.sqlite";
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(context, "DB Exported!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

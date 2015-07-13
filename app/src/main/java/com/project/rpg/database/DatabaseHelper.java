package com.project.rpg.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import com.project.rpg.database.tables.ItemPossessedTable;
import com.project.rpg.database.tables.CharacterTable;
import com.project.rpg.database.tables.ClassTable;
import com.project.rpg.database.tables.EffectTable;
import com.project.rpg.database.tables.EquippedTable;
import com.project.rpg.database.tables.ItemSubtypeTable;
import com.project.rpg.database.tables.ItemTable;
import com.project.rpg.database.tables.ItemTypeTable;
import com.project.rpg.database.tables.LevelTable;
import com.project.rpg.database.tables.LootTable;
import com.project.rpg.database.tables.MonsterTable;
import com.project.rpg.database.tables.MonsterTypeTable;
import com.project.rpg.database.tables.PowerTable;
import com.project.rpg.database.tables.ProbabilityTable;
import com.project.rpg.database.tables.SlotTable;
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

        mTablesCreationQuery.add(ClassTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(LevelTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(EffectTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ItemSubtypeTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ItemTypeTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(MonsterTypeTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ProbabilityTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(SlotTable.SQL_CREATE_ENTRIES);
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
        mTablesDeletionQuery.add(SlotTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ProbabilityTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(MonsterTypeTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ItemTypeTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ItemSubtypeTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(EffectTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(LevelTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(ClassTable.SQL_DELETE_ENTRIES);
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

    public void exportDB(Context context) {
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String currentDBPath = "/data/com.project.rpg/databases/" + DATABASE_NAME;
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

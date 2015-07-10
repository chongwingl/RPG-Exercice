package com.project.rpg.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;

import com.project.rpg.database.tables.ItemTable;
import com.project.rpg.database.tables.PowerTable;

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
        mTablesCreationQuery.add(PowerTable.SQL_CREATE_ENTRIES);
        mTablesCreationQuery.add(ItemTable.SQL_CREATE_ENTRIES);
        mTablesDeletionQuery.add(ItemTable.SQL_DELETE_ENTRIES);
        mTablesDeletionQuery.add(PowerTable.SQL_DELETE_ENTRIES);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String query : mTablesCreationQuery) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String query : mTablesDeletionQuery) {
            db.execSQL(query);
        }
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

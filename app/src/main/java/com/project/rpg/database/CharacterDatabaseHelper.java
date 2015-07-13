package com.project.rpg.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.project.rpg.database.contracts.ClassContract;
import com.project.rpg.database.model.Character;

/**
 * Created by laetitia on 7/8/15.
 */
public class CharacterDatabaseHelper {

    private SQLiteDatabase mDb;
    private final DatabaseHelper mDbHelper;
    private Context mContext;

    public CharacterDatabaseHelper(Context context) {
        mDbHelper = new DatabaseHelper(context);
        mContext = context;
    }

//    public Character getCharacter(int characterId){
//        mDb = mDbHelper.getReadableDatabase();
//
//    }

    public int saveCharacter(){
        mDb = mDbHelper.getWritableDatabase();
        return 0;
    }

    public void saveClass(String name) {
        mDb = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ClassContract.ClassEntry.COLUMN_NAME_NAME, name);
        mDb.insert(ClassContract.ClassEntry.TABLE_NAME, null, values);
    }
}

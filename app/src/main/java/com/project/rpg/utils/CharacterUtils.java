package com.project.rpg.utils;

import android.content.Context;
import android.os.Environment;

import com.project.rpg.models.characters.AbstractCharacter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by laetitia on 5/11/15.
 */
public final class CharacterUtils {

    private static final String RPG_FOLDER_NAME = "RPG/";
    private static final String RPG_FILE_NAME = "character";

    public static void saveCharacter(Context context, AbstractCharacter character) throws IOException {
//        File file = getFile();
        FileOutputStream fos = context.openFileOutput(RPG_FILE_NAME, Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(character);
        os.close();
        fos.close();
    }

    public static AbstractCharacter retrieveCharacter(Context context) throws IOException, ClassNotFoundException {
//        File file = getFile();
        FileInputStream fis = context.openFileInput(RPG_FILE_NAME);
        ObjectInputStream is = new ObjectInputStream(fis);
        AbstractCharacter character = (AbstractCharacter) is.readObject();
        is.close();
        fis.close();
        return character;
    }

    private static File getFile() throws IOException {
        final File file = new File(Environment.getExternalStorageDirectory(), RPG_FILE_NAME);
        // Create the storage directory if it does not exist
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Fail to create the RPG folder.");
        }
        return file;
    }

    private static File getStorageDirectory() throws IOException {
        final File storageDir = new File(Environment.getExternalStorageDirectory(), RPG_FOLDER_NAME);
        // Create the storage directory if it does not exist
        if (!storageDir.exists() && !storageDir.mkdirs()) {
            throw new IOException("Fail to create the RPG folder.");
        }
        return storageDir;
    }

}

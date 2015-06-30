package com.project.rpg.utils;

import android.content.Context;

import com.project.rpg.models.characters.AbstractCharacter;

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
        FileOutputStream fos = context.openFileOutput(RPG_FILE_NAME, Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(character);
        os.close();
        fos.close();
    }

    public static AbstractCharacter retrieveCharacter(Context context) throws IOException, ClassNotFoundException {
        FileInputStream fis = context.openFileInput(RPG_FILE_NAME);
        ObjectInputStream is = new ObjectInputStream(fis);
        AbstractCharacter character = (AbstractCharacter) is.readObject();
        is.close();
        fis.close();
        return character;
    }
}

package com.project.rpg.core;

import android.app.Application;
import android.util.Log;

import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.characters.fighters.Knight;
import com.project.rpg.utils.CharacterUtils;

import java.io.IOException;

/**
 * Created by laetitia on 5/11/15.
 */
public class RPGApplication extends Application {

    private AbstractCharacter abstractCharacter;

    public void createKnight(String name) {
        abstractCharacter = Knight.getKnight(name);
    }

    public AbstractCharacter getCharacter(){
        if (abstractCharacter == null) {
            AbstractCharacter character;
            try {
                character = CharacterUtils.retrieveCharacter(this);
                abstractCharacter = character;
            } catch (IOException | ClassNotFoundException e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }
        return abstractCharacter;
    }

    public void setCharacter(AbstractCharacter character) {
        abstractCharacter = character;
    }

}

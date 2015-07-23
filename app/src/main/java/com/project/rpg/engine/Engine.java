package com.project.rpg.engine;

import android.content.Context;

import com.project.rpg.engine.builders.CharacterBuilder;
import com.project.rpg.engine.model.Character;

/**
 * Created by laetitia on 7/13/15.
 */
public class Engine {

    private static Engine mInstance;

    private CharacterBuilder mCharacterBuilder;

    private Engine(Context context) {
        mCharacterBuilder = new CharacterBuilder(context);
    }

    public static Engine getInstance(Context context){
        if (mInstance == null) {
            mInstance = new Engine(context);
        }
        return mInstance;
    }

    public Character createCharacter(String name){
        return mCharacterBuilder.build(name);
    }

    public Character getCharacter(){
        return mCharacterBuilder.build();
    }
}

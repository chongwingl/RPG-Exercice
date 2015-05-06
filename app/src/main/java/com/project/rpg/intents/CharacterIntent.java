package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.models.enumerations.Character;

/**
 * Created by laetitia on 4/20/15.
 */
public class CharacterIntent extends Intent {


    public CharacterIntent(Context context, String characterType) {
        super();
        Character character = Character.getCharacterByType(characterType);
        setClass(context, character.getCharacterActivity());

    }

}

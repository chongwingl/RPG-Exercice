package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.models.enumerations.CharacterType;

/**
 * Created by laetitia on 4/20/15.
 */
public class CharacterIntent extends Intent {


    public CharacterIntent(Context context, CharacterType characterType) {
        super();
        setClass(context, characterType.getCharacterActivity());

    }

}

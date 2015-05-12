package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

/**
 * Created by laetitia on 5/6/15.
 */
public class StateIntent extends Intent{

    public StateIntent(Context packageContext, Class<?> clss) {
        super(packageContext, clss);
    }
}

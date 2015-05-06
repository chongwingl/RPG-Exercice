package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.StateActivity;

/**
 * Created by laetitia on 5/6/15.
 */
public class StateIntent extends Intent{

    public StateIntent(Context packageContext) {
        super(packageContext, StateActivity.class);
    }
}

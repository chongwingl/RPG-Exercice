package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.ActionActivity;

/**
 * Created by laetitia on 5/6/15.
 */
public class ActionIntent extends Intent{

    public ActionIntent(Context packageContext) {
        super(packageContext, ActionActivity.class);
    }
}

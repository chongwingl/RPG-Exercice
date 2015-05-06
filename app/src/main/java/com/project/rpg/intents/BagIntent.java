package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.BagActivity;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagIntent extends Intent{

    public BagIntent(Context packageContext) {
        super(packageContext, BagActivity.class);
    }
}

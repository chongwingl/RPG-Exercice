package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.AbstractStoreActivity;

/**
 * Created by laetitia on 5/6/15.
 */
public class StoreIntent extends Intent{

    public StoreIntent(Context packageContext, Class<?> clss) {
        super(packageContext, clss);
    }
}

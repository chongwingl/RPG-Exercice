package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.AbstractBagActivity;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagIntent extends Intent{

    public BagIntent(Context packageContext, Class clzz) {
        super(packageContext, clzz);
    }
}

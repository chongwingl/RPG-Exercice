package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.HomeActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public class HomeIntent extends Intent {

    public HomeIntent(Context context) {
        super(context, HomeActivity.class);
    }

}

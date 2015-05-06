package com.project.rpg.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;

/**
 * Created by laetitia on 4/20/15.
 */
public abstract class AbstractActivity extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        ButterKnife.inject(this);
    }

    public abstract int getLayoutResourceId();
}

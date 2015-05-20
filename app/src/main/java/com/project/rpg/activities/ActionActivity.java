package com.project.rpg.activities;

import android.widget.Button;

import com.project.rpg.R;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public class ActionActivity extends AbstractActivity {

    @InjectView(R.id.action1)
    Button mAction1;

    @InjectView(R.id.action2)
    Button mAction2;

    @InjectView(R.id.action3)
    Button mAction3;


    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_action;
    }
}

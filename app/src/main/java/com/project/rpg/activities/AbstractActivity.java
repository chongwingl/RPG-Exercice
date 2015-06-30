package com.project.rpg.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.project.rpg.core.RPGApplication;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.utils.CharacterUtils;

import java.io.IOException;

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

    protected RPGApplication getApp() {
        return (RPGApplication) getApplication();
    }

    @Override
    protected void onStop() {
        super.onStop();
        AbstractCharacter character = getCharacter();
        if (character != null) {
            try {
                CharacterUtils.saveCharacter(this, character);
            } catch (IOException e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }
    }

    protected AbstractCharacter getCharacter() {
        return getApp().getCharacter();
    }
}

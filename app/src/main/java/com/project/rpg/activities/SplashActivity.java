package com.project.rpg.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.appcompat.BuildConfig;

import com.project.rpg.R;
import com.project.rpg.core.RPGApplication;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.intents.HomeIntent;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.utils.ItemUtils;
import com.project.rpg.utils.MonsterUtils;

public class SplashActivity extends Activity {

    public static final long DEFAULT_TIMEOUT = 1600;
    public static final long DEBUG_TIMEOUT = DEFAULT_TIMEOUT / 2;

    private static final String STATE_FINISH_TIME = "STATE_FINISH_TIME";

    private static FinishHandler sHandler;

    private long mFinishTime;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        if (savedInstanceState != null) {
            mFinishTime = savedInstanceState.getLong(STATE_FINISH_TIME);
        } else if (BuildConfig.DEBUG) {
            mFinishTime = SystemClock.uptimeMillis() + DEBUG_TIMEOUT;
        } else {
            mFinishTime = SystemClock.uptimeMillis() + DEFAULT_TIMEOUT;
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(STATE_FINISH_TIME, mFinishTime);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sHandler == null) {
            sHandler = new FinishHandler();
        }

        sHandler.setSplashActivity(this);
        sHandler.sendEmptyMessageAtTime(FinishHandler.MSG_FINISH, mFinishTime);
    }

    @Override
    protected void onStop() {
        super.onStop();

        sHandler.setSplashActivity(null);
        sHandler.removeMessages(FinishHandler.MSG_FINISH);

        if (isFinishing()) {
            sHandler = null;
        }
    }

    private static class FinishHandler extends Handler {

        public static final int MSG_FINISH = 1;

        private SplashActivity mSplashActivity;

        public void setSplashActivity(final SplashActivity splashActivity) {
            mSplashActivity = splashActivity;
        }

        @Override
        public void handleMessage(final Message msg) {
            if (msg.what == MSG_FINISH && mSplashActivity != null) {
                ItemUtils.loadAllItems(mSplashActivity);
                MonsterUtils.loadMonsters(mSplashActivity);
                Intent intent;
                AbstractCharacter character = ((RPGApplication)mSplashActivity.getApplication()).getCharacter();
                if (character == null) {
                    intent = new HomeIntent(mSplashActivity);
                } else {
                    intent = new CharacterIntent(mSplashActivity, character.getCharacterType());
                }
                mSplashActivity.startActivity(intent);
                mSplashActivity.finish();
                mSplashActivity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            }
        }
    }
}


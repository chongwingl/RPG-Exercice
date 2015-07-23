package com.project.rpg.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.appcompat.BuildConfig;

import com.project.rpg.R;
import com.project.rpg.core.RPGApplication;
import com.project.rpg.database.CharacterDatabaseHelper;
import com.project.rpg.intents.CharacterCreationIntent;
import com.project.rpg.intents.CharacterIntent;
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
                fillDB(mSplashActivity);
                ItemUtils.loadAllItems(mSplashActivity);
                MonsterUtils.loadMonsters(mSplashActivity);
                Intent intent;
                AbstractCharacter character = ((RPGApplication) mSplashActivity.getApplication()).getCharacter();
                if (character == null) {
                    intent = new CharacterCreationIntent(mSplashActivity);
                } else {
                    intent = new CharacterIntent(mSplashActivity);
                }
                mSplashActivity.startActivity(intent);
                mSplashActivity.finish();
                mSplashActivity.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            }
        }
    }

    private static void fillDB(Context context) {
        CharacterDatabaseHelper helper = new CharacterDatabaseHelper(context);
        helper.saveLevel("Debutant");
        helper.saveLevel("Intermediaire");
        helper.saveLevel("Avance");
        helper.saveLevel("Expert");

        helper.saveStat("Force");
        helper.saveStat("Vitesse");
        helper.saveStat("Résistance");
        helper.saveStat("Précision");
        helper.saveStat("Dextérité");
        helper.saveStat("Agilité");
        helper.saveStat("Vie");

        helper.savePower("Poison", "Permet d'empoisonner l'adversaire", 2, 5, 20, helper.getStatIdByName("Vie"), 30, "substract");
        helper.savePower("Sleep", "Endort l'adversaire", 2, 5, 0, 0, 30, "");
        helper.savePower("Paralysie", "Ralentit l'adversaire", 2, 5, 20, helper.getStatIdByName("Vitesse"), 30, "substract");
        helper.savePower("Life", "Redonne de la vie", 1, 1, 100, helper.getStatIdByName("Vie"), 100, "add");

        helper.saveItem("Potion", "Rend 20 points de vie", "healing", "", 40, helper.getPowerIdByName("Vie"), "bag", 80);
        helper.saveItem("Super Potion", "Rend 50 points de vie", "healing", "", 80, helper.getPowerIdByName("Vie"), "bag", 70);
        helper.saveItem("Armure en cuir", "Une armure simple en cuir", "armor", "", 50, 0, "body", 70);
        helper.saveItem("Epee", "Epee simple", "weapon", "", 50, 0, "body", 70);

        helper.exportDb(context);
    }
}


package com.project.rpg.activities;

import com.project.rpg.R;
import com.project.rpg.intents.ActionIntent;
import com.project.rpg.intents.BagIntent;
import com.project.rpg.intents.StateIntent;
import com.project.rpg.intents.StoreIntent;

import butterknife.OnClick;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActivity extends AbstractCharacterActivity {

    @OnClick(R.id.character_button_action)
    void onActionClick(){
        startActivity(new ActionIntent(this));
    }

    @OnClick(R.id.character_button_state)
    void onStateClick(){
        startActivity(new StateIntent(this));
    }

    @OnClick(R.id.character_button_bag)
    void onBagClick(){
        startActivity(new BagIntent(this));
    }

    @OnClick(R.id.character_button_store)
    void onStoreClick(){
        startActivity(new StoreIntent(this, FighterStoreActivity.class));
    }
}

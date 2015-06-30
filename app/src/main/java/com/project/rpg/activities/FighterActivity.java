package com.project.rpg.activities;

import android.widget.Button;

import com.project.rpg.R;
import com.project.rpg.intents.ActionIntent;
import com.project.rpg.intents.BagIntent;
import com.project.rpg.intents.StateIntent;
import com.project.rpg.intents.StoreIntent;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.items.armor.body.BasicArmor;
import com.project.rpg.models.items.armor.foot.BasicBoot;
import com.project.rpg.models.items.armor.head.BasicHelmet;
import com.project.rpg.models.items.armor.legs.BasicLegArmor;
import com.project.rpg.models.items.weapons.protection.BasicShield;
import com.project.rpg.models.items.weapons.swords.BasicSword;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActivity extends AbstractCharacterActivity {

    @InjectView(R.id.character_button_action)
    Button mActionButton;

    @Override
    protected void onResume() {
        super.onResume();
        AbstractFighter fighter = (AbstractFighter) getCharacter();
        if (fighter != null) {
            if (fighter.getLife() < 1) {
                mActionButton.setEnabled(false);
            } else {
                mActionButton.setEnabled(true);
            }
        }
    }

    @OnClick(R.id.character_button_action)
    void onActionClick() {
        startActivity(new ActionIntent(this, FighterActionActivity.class));
    }

    @OnClick(R.id.character_button_state)
    void onStateClick() {
        startActivity(new StateIntent(this, FighterStateActivity.class));
    }

    @OnClick(R.id.character_button_bag)
    void onBagClick() {
        startActivity(new BagIntent(this));
    }

    @OnClick(R.id.character_button_store)
    void onStoreClick() {
        startActivity(new StoreIntent(this, FighterStoreActivity.class));
    }

    @Override
    public void onFragmentCreationFinished(String name) {
        super.onFragmentCreationFinished(name);
        AbstractFighter fighter = (AbstractFighter) getCharacter();
        fighter.setBodyArmor(new BasicArmor(this));
        fighter.setFootArmor(new BasicBoot(this));
        fighter.setHeadArmor(new BasicHelmet(this));
        fighter.setLegArmor(new BasicLegArmor(this));
        fighter.setLeftWeapon(new BasicShield(this));
        fighter.setRightWeapon(new BasicSword(this));
    }
}

package com.project.rpg.activities;

import android.os.Bundle;
import android.widget.Button;

import com.project.rpg.R;
import com.project.rpg.generators.ArmorGenerator;
import com.project.rpg.generators.PotionGenerator;
import com.project.rpg.intents.ActionIntent;
import com.project.rpg.intents.BagIntent;
import com.project.rpg.intents.StateIntent;
import com.project.rpg.intents.StoreIntent;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.enumerations.CharacterState;
import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.items.armor.body.BasicLeatherArmor;
import com.project.rpg.models.items.armor.foot.BasicLeatherBoot;
import com.project.rpg.models.items.armor.head.BasicLeatherHelmet;
import com.project.rpg.models.items.armor.legs.BasicLeatherLegArmor;
import com.project.rpg.models.items.weapons.protection.BasicShield;
import com.project.rpg.models.items.weapons.swords.BasicSword;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laetitia on 4/22/15.
 */
public class FighterActivity extends ToolbarActivity {

    @InjectView(R.id.character_button_action)
    Button mActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AbstractCharacter character = getCharacter();
        setCharacterInfo(
                character.getName(),
                character.getGold(),
                character.getSpecialStat(),
                character.getSpecialStatIconId(),
                character.getSpecialMaxStat()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        AbstractFighter fighter = (AbstractFighter) getCharacter();
        if (fighter != null) {
            if (fighter.getStat().getState() == CharacterState.DEAD) {
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
    public int getLayoutResourceId() {
        return R.layout.activity_character;
    }

}

package com.project.rpg.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.items.armor.body.BasicLeatherArmor;
import com.project.rpg.models.items.armor.foot.BasicLeatherBoot;
import com.project.rpg.models.items.armor.head.BasicLeatherHelmet;
import com.project.rpg.models.items.armor.legs.BasicLeatherLegArmor;
import com.project.rpg.models.items.weapons.protection.BasicShield;
import com.project.rpg.models.items.weapons.swords.BasicSword;
import com.project.rpg.utils.CharacterUtils;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CharacterCreationActivity extends AbstractActivity {

    @InjectView(R.id.create_character_name)
	EditText mCharacterName;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_creation;
    }

    @OnClick(R.id.character_created)
    void onFighterCreated(){
        String name = mCharacterName.getText().toString();
        if (!TextUtils.isEmpty(name)){

            getApp().createFighter(name);

            AbstractFighter fighter = (AbstractFighter) getCharacter();
            fighter.setBodyArmor(new BasicLeatherArmor(this));
            fighter.setFootArmor(new BasicLeatherBoot(this));
            fighter.setHeadArmor(new BasicLeatherHelmet(this));
            fighter.setLegArmor(new BasicLeatherLegArmor(this));
            fighter.setLeftWeapon(new BasicShield(this));
            fighter.setRightWeapon(new BasicSword(this));

            try {
                CharacterUtils.saveCharacter(this, fighter);
            } catch (IOException e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mCharacterName.getWindowToken(), 0);

            startActivity(new CharacterIntent(this));


        } else {
            Toast.makeText(this, "Enter a name please !", Toast.LENGTH_SHORT).show();
        }
    }

}

package com.project.rpg.activities;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.database.CharacterDatabaseHelper;
import com.project.rpg.engine.Engine;
import com.project.rpg.engine.model.Character;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.items.armor.body.BasicLeatherArmor;
import com.project.rpg.models.items.armor.foot.BasicLeatherBoot;
import com.project.rpg.models.items.armor.head.BasicLeatherHelmet;
import com.project.rpg.models.items.armor.legs.BasicLeatherLegArmor;
import com.project.rpg.models.items.weapons.protection.BasicShield;
import com.project.rpg.models.items.weapons.swords.BasicSword;
import com.project.rpg.utils.CharacterUtils;

import java.io.IOException;

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

            /**
             * Serialized handling
             **/

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

            /**
             * Database handling
             **/

            Character character = Engine.getInstance(this).createCharacter(name);
            CharacterDatabaseHelper db = new CharacterDatabaseHelper(this);
            db.saveCharacter(this, character);

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mCharacterName.getWindowToken(), 0);

            startActivity(new CharacterIntent(this));


        } else {
            Toast.makeText(this, "Enter a name please !", Toast.LENGTH_SHORT).show();
        }
    }

}

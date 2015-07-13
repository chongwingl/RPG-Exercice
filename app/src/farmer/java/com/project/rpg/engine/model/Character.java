package com.project.rpg.engine.model;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.R;
import com.project.rpg.database.model.ItemPossessed;
import com.project.rpg.exceptions.NotEnoughGoldException;

/**
 * Created by laetitia on 7/13/15.
 */
public class Character extends ContextWrapper {

    private String mName;
    private Gold mGold;
    private String mCharacterClass;
    private String mLevel;
    private String affectedByPower;
    private Life mLife;
    private CharacterStat stat;
    private List<ItemPossessed> bag;


    public Character(Context context) {
        super(context);
        mCharacterClass = context.getString(R.string.character_class);
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void addGold(int gold) {
        mGold.addGold(gold);
    }

    public void removeGold(int gold) throws NotEnoughGoldException {
        mGold.removeGold(gold);
    }

    public String getCharacterClass() {
        return mCharacterClass;
    }


}

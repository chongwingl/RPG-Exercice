package com.project.rpg.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.events.UpdateGoldEvent;
import com.project.rpg.models.events.UpdateSpecialStatEvent;

import butterknife.InjectView;
import de.greenrobot.event.EventBus;

/**
 * Created by laetitia on 6/29/15.
 */
public abstract class ToolbarActivity extends AbstractActivity {

    @InjectView(R.id.header_character_name)
    TextView mCharacterName;

    @InjectView(R.id.header_special_stat)
    TextView mCharacterSpecialStat;

    @InjectView(R.id.header_gold)
    TextView mCharacterGold;

    @InjectView(R.id.header_special_stat_icon)
    ImageView mSpecialStatIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AbstractCharacter character = getCharacter();
        EventBus.getDefault().register(this);

        if (character != null) {
            setCharacterInfo(
                    character.getName(),
                    character.getGold(),
                    character.getSpecialStat(),
                    character.getSpecialStatIconId(),
                    character.getSpecialMaxStat()
            );
        }

    }

    protected void setCharacterInfo(String name, int gold, int specialStat, int specialStatIcon, int specialMaxStat) {
        mCharacterName.setText(name);
        mCharacterGold.setText(String.valueOf(gold));
        mCharacterSpecialStat.setText(getString(R.string.life_display, specialStat, specialMaxStat));
        mSpecialStatIcon.setImageResource(specialStatIcon);
    }

    protected void setCharacterSpecialStat(int specialStat, int specialMaxStat) {
        mCharacterSpecialStat.setText(getString(R.string.life_display, specialStat, specialMaxStat));
    }

    protected void setCharacterGold(int gold) {
        mCharacterGold.setText(String.valueOf(gold));
    }

    public void onEventMainThread(UpdateGoldEvent event) {
        setCharacterGold(event.getGold());
    }

    public void onEventMainThread(UpdateSpecialStatEvent event) {
        setCharacterSpecialStat(event.getSpecialStat(), event.getSpecialMaxStat());
    }
}

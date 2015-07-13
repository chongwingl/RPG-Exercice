package com.project.rpg.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.project.rpg.R;
import com.project.rpg.adapters.CharacterSelectionAdapter;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.models.enumerations.CharacterClass;

import butterknife.InjectView;

public class HomeActivity extends AbstractActivity {

    private CharacterSelectionAdapter cAdapter;

    @InjectView(R.id.character_list)
    ListView characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cAdapter = new CharacterSelectionAdapter(this);
        characterList.setAdapter(cAdapter);

        characterList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
                if (cAdapter.getItem(position).equals(HomeActivity.this.getString(CharacterClass.FIGHTER.getTypeRefId()))) {
                    CharacterIntent intent = new CharacterIntent(
                            HomeActivity.this,
                            CharacterClass.getCharacterByType(HomeActivity.this, (String) cAdapter.getItem(position))
                    );
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_home;
    }
}

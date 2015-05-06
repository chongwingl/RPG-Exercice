package com.project.rpg.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.project.rpg.R;
import com.project.rpg.adapters.CharacterSelectionAdapter;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.models.enumerations.Character;
import com.project.rpg.utils.PreferencesHelper;

import butterknife.InjectView;

public class HomeActivity extends AbstractActivity {
	
	private CharacterSelectionAdapter cAdapter = new CharacterSelectionAdapter(this);
	private Context context;

    @InjectView(R.id.character_list)
    ListView characterList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		context = getBaseContext();
		characterList.setAdapter(cAdapter);
		
		characterList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				if(cAdapter.getItem(position).equals(Character.KNIGHT.toString())){
                    PreferencesHelper.getInstance(HomeActivity.this).setCharacterClass((String)cAdapter.getItem(position));
					CharacterIntent intent = new CharacterIntent(context, (String)cAdapter.getItem(position));
					startActivity(intent);
				}
			}
		});
	}

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_home;
    }
}

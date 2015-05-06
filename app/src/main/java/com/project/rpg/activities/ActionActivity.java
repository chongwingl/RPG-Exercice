package com.project.rpg.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.rpg.R;
import com.project.rpg.adapters.FighterActionAdapter;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public class ActionActivity extends AbstractActivity {

    @InjectView(R.id.character_actions)
    ListView actionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FighterActionAdapter mAdapter = new FighterActionAdapter(this);
        actionList.setAdapter(mAdapter);

        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

            }
        });
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_action;
    }
}

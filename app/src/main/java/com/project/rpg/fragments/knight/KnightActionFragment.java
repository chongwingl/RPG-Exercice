package com.project.rpg.fragments.knight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.rpg.R;
import com.project.rpg.adapters.FighterActionAdapter;
import com.project.rpg.fragments.AbstractFragment;

import butterknife.InjectView;

public class KnightActionFragment extends AbstractFragment {

    @InjectView(R.id.character_actions)
    ListView actionList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        View fragmentView = super.onCreateView(inflater, container, savedInstanceState);

        FighterActionAdapter mAdapter = new FighterActionAdapter(getActivity());
		actionList.setAdapter(mAdapter);

		actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

            }
        });
		return fragmentView;
	}

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_action_fighter;
    }

    @Override
    public String getTAG() {
        return getClass().getSimpleName();
    }

}

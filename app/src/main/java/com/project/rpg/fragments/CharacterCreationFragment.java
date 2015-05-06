package com.project.rpg.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.activities.CharacterActivity;
import com.project.rpg.utils.PreferencesHelper;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CharacterCreationFragment extends Fragment {

    public static final String TAG = CharacterCreationFragment.class.getSimpleName();

    @InjectView(R.id.fighter_name)
	EditText fighterName;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragmentView = inflater.inflate(R.layout.fragment_fighter_creation, container, false);

        ButterKnife.inject(this, fragmentView);

        return fragmentView;
    }

    @OnClick(R.id.fighter_created)
    void onFighterCreated(){
        String name = fighterName.getText().toString();
        if (!TextUtils.isEmpty(name)){
            PreferencesHelper helper = PreferencesHelper.getInstance(getActivity());
            helper.setCharacterName(name);
            helper.setCharacterLevel(1);
            helper.setCharacterGold(100);
            helper.setCharacterLife(10);

            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(fighterName.getWindowToken(), 0);

            ((CharacterActivity)getActivity()).onFragmentCreationFinished();

        } else {
            Toast.makeText(getActivity(), "Enter a name please !", Toast.LENGTH_SHORT).show();
        }
    }

}

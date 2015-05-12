package com.project.rpg.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.activities.AbstractCharacterActivity;
import com.project.rpg.core.RPGApplication;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.utils.CharacterUtils;

import java.io.IOException;

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

            ((RPGApplication)getActivity().getApplication()).createKnight(name);
            AbstractCharacter character = ((RPGApplication)getActivity().getApplication()).getCharacter();
            character.setLevel(1);
            character.setGold(100);
            try {
                CharacterUtils.saveCharacter(getActivity(), character);
            } catch (IOException e) {
                Log.e(getClass().getSimpleName(), e.getMessage());
            }

            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(fighterName.getWindowToken(), 0);

            ((AbstractCharacterActivity)getActivity()).onFragmentCreationFinished(name);

        } else {
            Toast.makeText(getActivity(), "Enter a name please !", Toast.LENGTH_SHORT).show();
        }
    }

}

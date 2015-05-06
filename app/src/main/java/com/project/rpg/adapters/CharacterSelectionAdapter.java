package com.project.rpg.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Character;

import java.util.ArrayList;

public class CharacterSelectionAdapter extends BaseAdapter{
	
	private ArrayList<String> characters;
	private Activity activity;

	public CharacterSelectionAdapter(Activity activity) {
		this.activity = activity;
		characters = new ArrayList<String>();
		characters.add(Character.KNIGHT.toString());
		characters.add(Character.SMITH.toString());
	}
	
	public class Holder{
		TextView text;
	}

	@Override
	public int getCount() {
		return characters.size();
	}

	@Override
	public Object getItem(int position) {
		return characters.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if(convertView == null){
			convertView = LayoutInflater.from(activity).inflate(R.layout.listview_text_item, null);
			holder = new Holder();
			holder.text = (TextView) convertView.findViewById(R.id.character_name);
			convertView.setTag(holder);
		}
		else {
			holder = (Holder) convertView.getTag();
		}
		
		String character = characters.get(position);
		holder.text.setText(character);
		
		return convertView;
	}

}

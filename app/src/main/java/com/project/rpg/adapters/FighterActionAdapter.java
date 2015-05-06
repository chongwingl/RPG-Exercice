package com.project.rpg.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.rpg.R;

import java.util.ArrayList;

public class FighterActionAdapter extends BaseAdapter {
	
	private ArrayList<String> actions;
	private Activity activity;

	public FighterActionAdapter(Activity activity) {
		this.activity = activity;
		actions = new ArrayList<String>();
		actions.add("Trouver un ennemi");
		actions.add("Se soigner");
		actions.add("Acheter de l'équipement");
		actions.add("Ouvrir le sac");
	}
	
	public class Holder{
		TextView text;
	}

	@Override
	public int getCount() {
		return actions.size();
	}

	@Override
	public Object getItem(int position) {
		return actions.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if(convertView == null){
			convertView = LayoutInflater.from(activity).inflate(R.layout.listview_text_item, parent, false);
			holder = new Holder();
			holder.text = (TextView) convertView.findViewById(R.id.character_name);
			convertView.setTag(holder);
		}
		else {
			holder = (Holder) convertView.getTag();
		}
		
		String action = actions.get(position);
		holder.text.setText(action);
		
		return convertView;
	}

}

package com.project.rpg.adapters;

import android.app.Activity;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.rpg.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagItemListAdapter extends BaseAdapter {

    HashMap<String, Pair<Integer, Class<?>>> mClassMapping;
    private ArrayList<String> mClassNames;
    private LayoutInflater mInflater;

    public BagItemListAdapter(HashMap<String, Pair<Integer, Class<?>>> classMapping, Activity activity) {
        mClassMapping = classMapping;
        mClassNames = new ArrayList<>(classMapping.keySet());
        mInflater = activity.getLayoutInflater();
    }

    public HashMap<String, Pair<Integer, Class<?>>> getClassMapping() {
        return mClassMapping;
    }

    @Override
    public int getCount() {
        return mClassNames.size();
    }

    @Override
    public Object getItem(int position) {
        return mClassNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_bag_item, parent, false);
            holder = new Holder();
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            holder.number= (TextView) convertView.findViewById(R.id.item_number);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        String name = (String)getItem(position);
        int number = mClassMapping.get(name).first;
        holder.name.setText(name);
        if (number > 1) {
            holder.number.setVisibility(View.VISIBLE);
            holder.number.setText(String.valueOf(mClassMapping.get(name).first));
        } else {
            holder.number.setVisibility(View.GONE);
        }
        return convertView;
    }

    class Holder {
        TextView name;
        TextView number;
    }
}

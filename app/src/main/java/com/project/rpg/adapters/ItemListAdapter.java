package com.project.rpg.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by laetitia on 5/6/15.
 */
public class ItemListAdapter extends BaseAdapter {

    private HashMap<String, Class<?>> mClassMapping;
    private ArrayList<String> mClassNames;
    private LayoutInflater mInflater;

    public ItemListAdapter(HashMap<String, Class<?>> classMapping, Activity activity) {
        mClassMapping = classMapping;
        mClassNames = new ArrayList<>(mClassMapping.keySet());
        mInflater = activity.getLayoutInflater();
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
            holder.price = (TextView) convertView.findViewById(R.id.item_number);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        String name = (String)getItem(position);
        holder.name.setText(name);
        AbstractItem item = ItemUtils.getItemFromClass(convertView.getContext(), mClassMapping.get(name));
        holder.price.setText(String.valueOf(item.getPrice()));

        return convertView;
    }

    class Holder {
        TextView name;
        TextView price;
    }
}

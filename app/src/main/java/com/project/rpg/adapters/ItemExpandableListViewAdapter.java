package com.project.rpg.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.project.rpg.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by laetitia on 4/21/15.
 */
public class ItemExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Activity mActivity;

    private List<String> mListDataHeader;

    private HashMap<String, List<String>> mListDataChild;

    public ItemExpandableListViewAdapter(Activity activity, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        mActivity = activity;
        mListDataHeader = listDataHeader;
        mListDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return mListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition)).size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return mListDataHeader.get(groupPosition);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mActivity.getLayoutInflater().inflate(R.layout.expandable_list_group, parent, false);
            convertView.setTag(convertView);
        } else {
            convertView = (View) convertView.getTag();
        }
        ((TextView)convertView).setText(getGroup(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mActivity.getLayoutInflater().inflate(R.layout.expandable_list_item, parent, false);
            convertView.setTag(convertView);
        } else {
            convertView = (View) convertView.getTag();
        }
        ((TextView)convertView).setText(getChild(groupPosition, childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

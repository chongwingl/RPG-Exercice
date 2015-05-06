package com.project.rpg.fragments;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.stores.AbstractStoreBuilder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by laetitia on 4/22/15.
 */
public abstract class StoreFragment extends ShowListItemFragment {

    protected AbstractStoreBuilder mStoreBuilder;

    @Override
    protected void fillData() {
        mItemTypes = new ArrayList<>();
        mItemList = new HashMap<>();
        setStoreBuilder();
        mStoreBuilder.buildStore(mItemTypes, mItemList);

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Toast.makeText(getActivity(), sAdapter.getChild(groupPosition, childPosition), Toast.LENGTH_SHORT).show();
        AbstractItem item = mStoreBuilder.buildItem(
                sAdapter.getGroup(groupPosition),
                sAdapter.getChild(groupPosition, childPosition)
        );
        return true;
    }

    protected abstract void setStoreBuilder();

}

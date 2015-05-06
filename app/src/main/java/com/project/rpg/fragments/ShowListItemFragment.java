package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.project.rpg.R;
import com.project.rpg.adapters.ItemExpandableListViewAdapter;
import com.project.rpg.utils.PreferencesHelper;

import java.util.HashMap;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class ShowListItemFragment extends AbstractFragment
        implements ExpandableListView.OnChildClickListener {

    protected List<String> mItemTypes;
    protected HashMap<String, List<String>> mItemList;
    protected PreferencesHelper mHelper;
    protected ItemExpandableListViewAdapter sAdapter;

    @InjectView(R.id.store)
    ExpandableListView mItemListView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mHelper = PreferencesHelper.getInstance(getActivity());

        fillData();

        sAdapter = new ItemExpandableListViewAdapter(getActivity(), mItemTypes, mItemList);

        mItemListView.setAdapter(sAdapter);
        mItemListView.setOnChildClickListener(this);

        return view;
    }

    protected abstract void fillData();

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_store;
    }

    @Override
    public String getTAG() {
        return getClass().getSimpleName();
    }
}

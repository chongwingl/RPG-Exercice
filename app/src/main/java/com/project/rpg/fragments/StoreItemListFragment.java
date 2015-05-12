package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;

import com.project.rpg.adapters.ItemListAdapter;

import java.util.HashMap;

/**
 * Created by laetitia on 5/5/15.
 */
public class StoreItemListFragment extends ListFragment {

    private static final String ITEMS = "ITEMS";

    private OnItemSelectedListener mListener;

    public static StoreItemListFragment newInstance(HashMap<String, Class<?>> classMapping) {
        final StoreItemListFragment storeItemListFragment = new StoreItemListFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ITEMS, classMapping);
        storeItemListFragment.setArguments(bundle);
        return storeItemListFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        final HashMap<String, Class<?>> itemsList = (HashMap<String, Class<?>>) bundle.getSerializable(ITEMS);

        final ItemListAdapter adapter = new ItemListAdapter(itemsList, getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) adapter.getItem(position);
                mListener.onItemSelected(itemsList.get(name));
            }
        });
    }

    public void setListener(OnItemSelectedListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemSelectedListener {
        public void onItemSelected(Class<?> clss);
    }
}

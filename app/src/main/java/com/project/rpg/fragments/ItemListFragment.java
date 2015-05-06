package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import com.project.rpg.adapters.ItemListAdapter;

import java.util.HashMap;

/**
 * Created by laetitia on 5/5/15.
 */
public class ItemListFragment extends ListFragment {

    private static final String ITEMS = "ITEMS";

    public static ItemListFragment newInstance(HashMap<String, Class<?>> classMapping) {
        final ItemListFragment itemListFragment = new ItemListFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ITEMS, classMapping);
        itemListFragment.setArguments(bundle);
        return itemListFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        final HashMap<String, Class<?>> itemsList = (HashMap<String, Class<?>>) bundle.getSerializable(ITEMS);;

        ItemListAdapter adapter = new ItemListAdapter(itemsList, getActivity());
        setListAdapter(adapter);
    }
}

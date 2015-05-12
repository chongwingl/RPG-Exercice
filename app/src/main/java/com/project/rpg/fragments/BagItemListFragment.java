package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;

import com.project.rpg.adapters.BagItemListAdapter;
import com.project.rpg.core.RPGApplication;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;

import java.util.HashMap;
import java.util.List;

/**
 * Created by laetitia on 5/5/15.
 */
public class BagItemListFragment extends ListFragment {

    private static final String ITEM_CATEGORY = "ITEM_CATEGORY";

    private OnItemSelectedListener mListener;

    public static BagItemListFragment newInstance(ItemType itemtype) {
        final BagItemListFragment bagItemListFragment = new BagItemListFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ITEM_CATEGORY, itemtype);
        bagItemListFragment.setArguments(bundle);
        return bagItemListFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        final ItemType itemType = (ItemType) bundle.getSerializable(ITEM_CATEGORY);
        final AbstractCharacter character = ((RPGApplication)getActivity().getApplication()).getCharacter();
        final List<AbstractItem> itemList = character.getBag().getItemByType(itemType);
        final HashMap<String, Pair<Integer, Class<?>>> mapItem = new HashMap<>();
        for (AbstractItem item : itemList) {
            if (mapItem.containsKey(item.getName())) {
                Pair<Integer, Class<?>> pair = mapItem.get(item.getName());
                int number = pair.first + 1;
                mapItem.put(item.getName(), new Pair<Integer, Class<?>>(number, item.getClass()));
            } else {
                mapItem.put(item.getName(), new Pair<Integer, Class<?>>(1, item.getClass()));
            }
        }

        final BagItemListAdapter adapter = new BagItemListAdapter(mapItem, getActivity());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) adapter.getItem(position);
                mListener.onItemSelected(mapItem.get(name).second);
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

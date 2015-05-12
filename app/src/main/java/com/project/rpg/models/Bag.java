package com.project.rpg.models;

import android.content.Context;

import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by laetitia on 5/7/15.
 */
public class Bag implements Serializable {

    private static final long serialVersionUID = -5316787694933819023L;

    private static int MAX_SIZE;
    private static Bag instance;

    private HashMap<ItemType, List<AbstractItem>> itemsList;
    private int mCurrentBagSize = 0;

    public synchronized static Bag getInstance(int maxSize) {
        if (instance == null) {
            instance = new Bag(maxSize);
        }
        return instance;
    }

    private Bag( int maxSize) {
        itemsList = new HashMap<>();
        MAX_SIZE = maxSize;
    }

    public void addItem(AbstractItem item) {
        ItemType itemType = item.getItemType();
        if (!itemsList.containsKey(itemType)) {
            List<AbstractItem> items = new ArrayList<>();
            items.add(item);
            itemsList.put(itemType, items);
        } else {
            List<AbstractItem> items = itemsList.get(itemType);
            items.add(item);
        }
        mCurrentBagSize++;
    }

    public boolean removeItem(ItemType itemType, AbstractItem item) {
        List<AbstractItem> items = itemsList.get(itemType);
        for (AbstractItem abstractItem : items) {
            if (abstractItem.getName().equals(item.getName())) {
                items.remove(abstractItem);
                mCurrentBagSize--;
                return true;
            }
        }
        return false;
    }

    public int getmCurrentBagSize() {
        return mCurrentBagSize;
    }

    public List<AbstractItem> getItemByType(ItemType itemType) {
        return itemsList.get(itemType);
    }

    public List<String> getItemTypes(Context context) {
        List<String> temp = new ArrayList<>();
        for (ItemType itemtype : itemsList.keySet()) {
            temp.add(context.getString(itemtype.getNameRefId()));
        }
        return temp;
    }
}

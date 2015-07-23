package com.project.rpg.engine.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laetitia on 7/16/15.
 */
public class Bag {

    private List<Item> mBag;

    public Bag() {
        mBag = new ArrayList<>();
    }

    public List<Item> getBag() {
        return mBag;
    }

    public void addItemToBag(Item item) {
        mBag.add(item);
    }

    public void removeItemFromBag(Item item) {
        if (mBag.contains(item)){
            int position = mBag.indexOf(item);
            int numberOfItem = mBag.get(position).getNumberOfItem();
            if (numberOfItem > 0) {
                mBag.get(position).setNumberOfItem(numberOfItem - 1);
            } else {
                mBag.remove(position);
            }
        } else {
            // TODO throw no such item exception
        }
    }
}

package com.project.rpg.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.NoItemInBagException;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.items.AbstractItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laetitia on 5/7/15.
 */
public class Bag implements Parcelable {

    private static int MAX_SIZE;
    private static Bag mInstance;

    private HashMap<ItemType, List<AbstractItem>> mItemsList;
    private int mCurrentBagSize = 0;

    public synchronized static Bag getInstance(int maxSize) {
        if (mInstance == null) {
            mInstance = new Bag(maxSize);
        }
        return mInstance;
    }

    private Bag(int maxSize) {
        mItemsList = new HashMap<>();
        MAX_SIZE = maxSize;
    }

    public void addItem(AbstractItem item) {
        ItemType itemType = item.getItemType();
        if (!mItemsList.containsKey(itemType)) {
            List<AbstractItem> items = new ArrayList<>();
            items.add(item);
            mItemsList.put(itemType, items);
        } else {
            List<AbstractItem> items = mItemsList.get(itemType);
            items.add(item);
        }
        mCurrentBagSize++;
    }

    public void removeItem(AbstractItem item) throws NoItemInBagException {
        ItemType itemType = item.getItemType();
        List<AbstractItem> items = mItemsList.get(itemType);
        AbstractItem itemToRemove = null;
        for (AbstractItem abstractItem : items) {
            if (abstractItem.getName().equals(item.getName())) {
                itemToRemove = abstractItem;
                mCurrentBagSize--;
                break;
            }
        }
        if (itemToRemove != null) {
            items.remove(itemToRemove);
        }
        if (mCurrentBagSize == 0) {
            mItemsList = new HashMap<>();
            throw new NoItemInBagException();
        }
    }

    public int getCurrentBagSize() {
        return mCurrentBagSize;
    }

    public List<AbstractItem> getItemByType(ItemType itemType) {
        return mItemsList.get(itemType);
    }

    public List<String> getItemTypes(Context context) {
        List<String> temp = new ArrayList<>();
        for (ItemType itemtype : mItemsList.keySet()) {
            temp.add(context.getString(itemtype.getNameRefId()));
        }
        return temp;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mInstance, flags);
        out.writeInt(mCurrentBagSize);
        out.writeInt(mItemsList.size());
        for (Map.Entry<ItemType, List<AbstractItem>> entry : mItemsList.entrySet()){
            out.writeSerializable(entry.getKey());
            out.writeList(entry.getValue());
        }
    }

    public static final Parcelable.Creator<Bag> CREATOR
            = new Parcelable.Creator<Bag>() {
        public Bag createFromParcel(Parcel in) {
            return new Bag(in);
        }

        public Bag[] newArray(int size) {
            return new Bag[size];
        }
    };

    private Bag(Parcel in) {
        mInstance = in.readParcelable(mInstance.getClass().getClassLoader());
        mCurrentBagSize = in.readInt();
        int size = in.readInt();
        for(int i = 0; i < size; i++){
            ItemType key = (ItemType) in.readSerializable();
            List<AbstractItem> value = new ArrayList<>();
            in.readList(value, AbstractItem.class.getClassLoader());
            mItemsList.put(key,value);
        }
    }

}

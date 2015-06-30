package com.project.rpg.models.stores;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.items.AbstractItem;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractStoreBuilder extends ContextWrapper {

    protected String [] mCategories;

    protected String [] mCategoriesExcluded;

    protected AbstractStoreBuilder(Context base) {
        super(base);
        setCategoriesExcluded();
        buildCategories();
    }

    private void buildCategories(){
        ArrayList<String> tempList = new ArrayList<>();
        String category;
        for (ItemType itemType : ItemType.values()) {
            category = getBaseContext().getString(itemType.getNameRefId());
            if (!isExcluded(category)) {
                tempList.add(category);
            }
        }

        mCategories = new String[tempList.size()];
        mCategories = tempList.toArray(mCategories);
    }

    private boolean isExcluded(String category) {
        for (String categoriesExcluded : mCategoriesExcluded) {
            if (category.equals(categoriesExcluded)) {
                return true;
            }
        }
        return false;
    }

    public void setCategoriesExcluded() {
        mCategoriesExcluded = new String[0];
    }

    public String [] getCategories(){
        return mCategories;
    }

    public abstract HashMap<String, Class<?>> buildCategory(ItemType itemType);

    public abstract AbstractItem buildItem(Class<?> clss);

}

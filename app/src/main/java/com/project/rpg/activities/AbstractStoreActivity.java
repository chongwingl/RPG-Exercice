package com.project.rpg.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.project.rpg.fragments.StoreItemListFragment;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.stores.AbstractStoreBuilder;

/**
 * Created by laetitia on 5/6/15.
 */
public abstract class AbstractStoreActivity extends AbstractShowCategoryItemActivity
    implements StoreItemListFragment.OnItemSelectedListener {

    protected AbstractStoreBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setStoreBuilder();
        super.onCreate(savedInstanceState);
    }

    public abstract void setStoreBuilder();

    @Override
    public void onItemSelected(Class<?> clss) {
        addToBag(builder.buildItem(clss));
    }

    public void addToBag(AbstractItem item) {

        Toast.makeText(this, "item: " + item.getName(), Toast.LENGTH_SHORT).show();
        AbstractFighter fighter = (AbstractFighter)getApp().getCharacter();
        if (fighter.getGold() >= item.getPrice()) {
            fighter.removeGold(item.getPrice());
            fighter.addToBag(item);
        } else {
            Toast.makeText(this, "Not enough gold...", Toast.LENGTH_SHORT).show();
        }
    }
}

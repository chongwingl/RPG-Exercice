package com.project.rpg.activities;

import android.widget.Toast;

import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.adapters.BagPagerAdapter;
import com.project.rpg.fragments.BagItemListFragment;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagActivity extends AbstractShowCategoryItemActivity
    implements BagItemListFragment.OnItemSelectedListener{

    @Override
    protected AbstractItemCategoryPagerAdapter getAdapter() {
        return new BagPagerAdapter(getSupportFragmentManager(), this);
    }

    @Override
    public void onItemSelected(Class<?> clss) {
        AbstractItem item = ItemUtils.getItemFromClass(this, clss);
        Toast.makeText(this, "item: " + item.getName(), Toast.LENGTH_SHORT).show();
    }
}

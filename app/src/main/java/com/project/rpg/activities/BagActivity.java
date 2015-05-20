package com.project.rpg.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.adapters.BagPagerAdapter;
import com.project.rpg.fragments.BagItemListFragment;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagActivity extends AbstractShowCategoryItemActivity
    implements BagItemListFragment.OnItemSelectedListener{

    @InjectView(R.id.empty)
    TextView emptyBag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mItemCategoryAdapter.getCount() < 1) {
            emptyBag.setVisibility(View.VISIBLE);
        } else {
            emptyBag.setVisibility(View.GONE);
        }
    }

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

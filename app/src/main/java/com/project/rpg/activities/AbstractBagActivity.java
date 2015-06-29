package com.project.rpg.activities;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.adapters.AbstractItemCategoryPagerAdapter;
import com.project.rpg.adapters.BagPagerAdapter;
import com.project.rpg.exceptions.NoItemInBagException;
import com.project.rpg.fragments.BagItemListFragment;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

import butterknife.InjectView;

/**
 * Created by laetitia on 5/6/15.
 */
public abstract class AbstractBagActivity extends AbstractShowCategoryItemActivity
        implements BagItemListFragment.OnItemSelectedListener {

    @InjectView(R.id.empty)
    TextView emptyBag;

    @Override
    protected void onResume() {
        super.onResume();
        setEmptyViewVisibility();
    }

    @Override
    protected AbstractItemCategoryPagerAdapter getAdapter() {
        return new BagPagerAdapter(getSupportFragmentManager(), this);
    }

    @Override
    public void onItemSelected(Class<?> clss) {
        final AbstractItem item = ItemUtils.getItemFromClass(this, clss);
        BaseDialogFragment.newInstance(
                R.string.use_item_dialog_title,
                R.string.use_item_dialog_message,
                R.string.ok, -1)
                .setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
                    @Override
                    public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                        item.use(getCharacter());
                        try {
                            getCharacter().removeItemFromBag(item);
                        } catch (NoItemInBagException e) {
                            mItemViewPager.setAdapter(null);
                            setEmptyViewVisibility();
                        }

                    }
                }).show(getSupportFragmentManager());
    }

    private void setEmptyViewVisibility() {
        if (mItemCategoryAdapter.getCount() < 1) {
            emptyBag.setVisibility(View.VISIBLE);
        } else {
            emptyBag.setVisibility(View.GONE);
        }
    }

}

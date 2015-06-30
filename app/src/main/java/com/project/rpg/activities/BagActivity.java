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
import com.project.rpg.fragments.dialogs.UseItemDialogFragment;
import com.project.rpg.models.events.ItemUsedEvent;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.utils.ItemUtils;

import butterknife.InjectView;
import de.greenrobot.event.EventBus;

/**
 * Created by laetitia on 5/6/15.
 */
public class BagActivity extends AbstractShowCategoryItemActivity
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
        if (item != null) {
            item.getUseItemDialogFragment(this)
                    .setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
                        @Override
                        public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                            item.use(getCharacter());
                            try {
                                getCharacter().removeItemFromBag(item);
                                EventBus.getDefault().post(new ItemUsedEvent(item.getName()));
                            } catch (NoItemInBagException e) {
                                mItemViewPager.setAdapter(null);
                                mSlidingTabLayout.setViewPager(null);
                                mItemCategoryAdapter.reset();
                                setEmptyViewVisibility();
                            }

                        }
                    }).show(getSupportFragmentManager());
        }
    }

    private void setEmptyViewVisibility() {
        if (mItemCategoryAdapter.getCount() < 1) {
            emptyBag.setVisibility(View.VISIBLE);
        } else {
            emptyBag.setVisibility(View.GONE);
        }
    }

}

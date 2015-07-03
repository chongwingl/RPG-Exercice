package com.project.rpg.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.project.rpg.R;
import com.project.rpg.exceptions.NotEnoughGoldException;
import com.project.rpg.fragments.StoreItemListFragment;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
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
        buyItem(builder.buildItem(clss));
    }

    public void buyItem(AbstractItem item) {

        AbstractFighter fighter = (AbstractFighter) getApp().getCharacter();
        try {
            fighter.removeGold(item.getPrice());
            fighter.addToBag(item);
            Toast.makeText(this, item.getName() + getString(R.string.added_to_bag), Toast.LENGTH_SHORT).show();
        } catch (NotEnoughGoldException e) {
            Log.e(getClass().getSimpleName(), e.getMessage(this));
            BaseDialogFragment dialogFragment =
                    BaseDialogFragment.newInstance(R.string.store_error_message_title, e.getMessageRefId(), R.string.ok);
            dialogFragment.show(getSupportFragmentManager());
        }
    }
}

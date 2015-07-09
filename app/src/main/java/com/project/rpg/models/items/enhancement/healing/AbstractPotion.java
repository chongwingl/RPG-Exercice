package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.os.Parcel;
import android.support.v4.app.DialogFragment;

import com.project.rpg.R;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.powers.Life;

/**
 * Created by laetitia on 4/27/15.
 */
public abstract class AbstractPotion extends AbstractItem {

    private Life mLifePower;

    public AbstractPotion() {
    }

    protected AbstractPotion(String name, int lifePointsRestored) {
        super(name);
        mLifePower = new Life(lifePointsRestored);
    }

    @Override
    protected void setItemType() {
        mItemType = ItemType.HEALING;
    }

    public int getRestoredLifePoints(){
        return (int) mLifePower.getPowerEffect();
    }

    @Override
    public void use(AbstractCharacter character) {
        ((AbstractFighter)character).addLife(getRestoredLifePoints());
    }

    public StringMessageDialogFragment getUseItemDialogFragment(Context context) {
        StringMessageDialogFragment dialogFragment = StringMessageDialogFragment.newInstance(
                R.string.use_potion_dialog_title,
                context.getString(R.string.use_potion_dialog_message, getRestoredLifePoints()),
                R.string.ok,
                R.string.cancel
        );
        dialogFragment.setNegativeListener(new BaseDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                dialog.dismiss();
            }
        });
        return dialogFragment;
    }

    // Reminder
    // Potion type : basic : 20, normal: 50, super: 100, hyper: 200, mega: 500

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mLifePower, flags);
    }

    protected AbstractPotion(Parcel in) {
        super(in);
        mLifePower = in.readParcelable(mLifePower.getClass().getClassLoader());
    }
}

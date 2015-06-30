package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import com.project.rpg.R;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
import com.project.rpg.fragments.dialogs.UseItemDialogFragment;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicPotion extends AbstractHealing {

    private static final long serialVersionUID = 436683358659644413L;

    public BasicPotion(Context context) {
        super(context.getString(R.string.healing_potion), 20);
        setPrice(10);
    }

    @Override
    public UseItemDialogFragment getUseItemDialogFragment(Context context) {
        UseItemDialogFragment dialogFragment = UseItemDialogFragment.newInstance(
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
}

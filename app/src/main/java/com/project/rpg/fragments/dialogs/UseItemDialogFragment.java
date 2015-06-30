package com.project.rpg.fragments.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by laetitia on 6/30/15.
 */
public class UseItemDialogFragment extends BaseDialogFragment {

    protected String mMessage;

    public static UseItemDialogFragment newInstance(int title, String message, int positiveButton, int negativeButton) {
        UseItemDialogFragment fragment = new UseItemDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putString(SAVED_MESSAGE, message);
        bundle.putInt(SAVED_POSITIVE, positiveButton);
        bundle.putInt(SAVED_NEGATIVE, negativeButton);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Bundle data;
        if (savedInstanceState != null) {
            data = savedInstanceState;
        } else {
            data = getArguments();
        }

        if (data.containsKey(SAVED_TITLE)) {
            mTitle = data.getInt(SAVED_TITLE);
        }

        if (data.containsKey(SAVED_MESSAGE)) {
            mMessage = data.getString(SAVED_MESSAGE);
        }

        if (data.containsKey(SAVED_POSITIVE)) {
            mPositive = data.getInt(SAVED_POSITIVE);
        }

        if (data.containsKey(SAVED_NEGATIVE)) {
            mNegative = data.getInt(SAVED_NEGATIVE);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(mTitle);
        builder.setMessage(mMessage);

        if (mPositive != -1) {
            builder.setPositiveButton(mPositive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mPositiveListener != null) {
                        mPositiveListener.onDialogButtonClick(UseItemDialogFragment.this, mPositive);
                    }
                }
            });
        }

        if (mNegative != -1) {
            builder.setNegativeButton(mNegative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mNegativeListener != null) {
                        mNegativeListener.onDialogButtonClick(UseItemDialogFragment.this, mNegative);
                    }
                }
            });
        }

        return builder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mTitle != -1) {
            outState.putInt(SAVED_TITLE, mTitle);
        }

        if (!TextUtils.isEmpty(mMessage)) {
            outState.putString(SAVED_MESSAGE, mMessage);
        }

        if (mPositive != -1) {
            outState.putInt(SAVED_POSITIVE, mPositive);
        }

        if (mNegative != -1) {
            outState.putInt(SAVED_NEGATIVE, mNegative);
        }
    }
}

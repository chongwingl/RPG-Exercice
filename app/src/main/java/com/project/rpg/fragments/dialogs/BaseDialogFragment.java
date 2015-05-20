package com.project.rpg.fragments.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by laetitia on 5/14/15.
 */
public class BaseDialogFragment extends DialogFragment {

    public static final String TAG = BaseDialogFragment.class.getSimpleName();
    protected static final String SAVED_TITLE = "savedTitle";
    protected static final String SAVED_MESSAGE = "savedMessage";
    protected static final String SAVED_POSITIVE = "savedPositive";
    protected static final String SAVED_NEGATIVE = "saveNegative";

    protected int mTitle;
    protected int mMessage;
    protected int mPositive = -1;
    protected int mNegative = -1;

    private DialogButtonsListener mPositiveListener;
    private DialogButtonsListener mNegativeListener;

    public static BaseDialogFragment newInstance(int title, int message, int positiveButton, int negativeButton) {
        BaseDialogFragment fragment = new BaseDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putInt(SAVED_MESSAGE, message);
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
            mMessage = data.getInt(SAVED_MESSAGE);
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
                        mPositiveListener.onDialogButtonClick(BaseDialogFragment.this, mPositive);
                    }
                }
            });
        }

        if (mNegative != -1) {
            builder.setNegativeButton(mNegative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mNegativeListener != null) {
                        mNegativeListener.onDialogButtonClick(BaseDialogFragment.this, mNegative);
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

        if (mMessage != -1) {
            outState.putInt(SAVED_MESSAGE, mMessage);
        }

        if (mPositive != -1) {
            outState.putInt(SAVED_POSITIVE, mPositive);
        }

        if (mNegative != -1) {
            outState.putInt(SAVED_NEGATIVE, mNegative);
        }
    }

    public void show(FragmentManager manager) {
        show(manager, getDialogTag());
    }

    public void setPositiveListener(DialogButtonsListener listener) {
        mPositiveListener = listener;
    }

    public void setNegativeListener(DialogButtonsListener listener) {
        mNegativeListener = listener;
    }

    public String getDialogTag() {
        return TAG;
    }

    public interface DialogButtonsListener {
        void onDialogButtonClick(DialogFragment dialog, int buttonTitle);
    }
}

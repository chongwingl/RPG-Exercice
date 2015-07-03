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
    protected static final String SAVED_MESSAGE_REFID = "savedMessageRefId";
    protected static final String SAVED_POSITIVE = "savedPositive";
    protected static final String SAVED_NEGATIVE = "saveNegative";

    protected int mTitleRefId = -1;
    protected int mMessageRefId = -1;
    protected int mPositive = -1;
    protected int mNegative = -1;

    protected DialogButtonsListener mPositiveListener;
    protected DialogButtonsListener mNegativeListener;

    protected AlertDialog.Builder mBuilder;

    public static BaseDialogFragment newInstance(int title, int message, int positiveButton, int negativeButton) {
        BaseDialogFragment fragment = new BaseDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putInt(SAVED_MESSAGE_REFID, message);
        bundle.putInt(SAVED_POSITIVE, positiveButton);
        bundle.putInt(SAVED_NEGATIVE, negativeButton);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static BaseDialogFragment newInstance(int title, int message, int positiveButton) {
        BaseDialogFragment fragment = new BaseDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putInt(SAVED_MESSAGE_REFID, message);
        bundle.putInt(SAVED_POSITIVE, positiveButton);
        bundle.putInt(SAVED_NEGATIVE, -1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle data;
        if (savedInstanceState != null) {
            data = savedInstanceState;
        } else {
            data = getArguments();
        }

        if (data.containsKey(SAVED_TITLE)) {
            mTitleRefId = data.getInt(SAVED_TITLE);
        }

        if (data.containsKey(SAVED_MESSAGE_REFID)) {
            mMessageRefId = data.getInt(SAVED_MESSAGE_REFID);
        }

        if (data.containsKey(SAVED_POSITIVE)) {
            mPositive = data.getInt(SAVED_POSITIVE);
        }

        if (data.containsKey(SAVED_NEGATIVE)) {
            mNegative = data.getInt(SAVED_NEGATIVE);
        }

        mBuilder = new AlertDialog.Builder(getActivity());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mBuilder.setTitle(mTitleRefId);
        mBuilder.setMessage(mMessageRefId);

        setButtons();

        return mBuilder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mTitleRefId != -1) {
            outState.putInt(SAVED_TITLE, mTitleRefId);
        }

        if (mMessageRefId != -1) {
            outState.putInt(SAVED_MESSAGE_REFID, mMessageRefId);
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

    public BaseDialogFragment setPositiveListener(DialogButtonsListener listener) {
        mPositiveListener = listener;
        return this;
    }

    public BaseDialogFragment setNegativeListener(DialogButtonsListener listener) {
        mNegativeListener = listener;
        return this;
    }

    public String getDialogTag() {
        return TAG;
    }

    public interface DialogButtonsListener {
        void onDialogButtonClick(DialogFragment dialog, int buttonTitle);
    }

    protected void setButtons() {
        if (mPositive != -1) {
            mBuilder.setPositiveButton(mPositive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mPositiveListener != null) {
                        mPositiveListener.onDialogButtonClick(BaseDialogFragment.this, mPositive);
                    }
                }
            });
        }

        if (mNegative != -1) {
            mBuilder.setNegativeButton(mNegative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mNegativeListener != null) {
                        mNegativeListener.onDialogButtonClick(BaseDialogFragment.this, mNegative);
                    }
                }
            });
        }
    }

}

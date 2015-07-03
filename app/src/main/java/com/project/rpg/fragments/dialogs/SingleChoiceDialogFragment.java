package com.project.rpg.fragments.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by laetitia on 7/3/15.
 */
public class SingleChoiceDialogFragment extends BaseDialogFragment {

    private static final String SAVED_ARRAY = "SAVED_ARRAY";
    private static final int DEFAULT_POSITION = 0;

    private String [] mArray;
    private int mSelected = DEFAULT_POSITION;

    protected DialogButtonsListener mPositiveListener;
    protected DialogButtonsListener mNegativeListener;

    public static SingleChoiceDialogFragment newInstance(int title, int positiveButton, String [] array) {
        SingleChoiceDialogFragment fragment = new SingleChoiceDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putInt(SAVED_POSITIVE, positiveButton);
        bundle.putInt(SAVED_NEGATIVE, -1);
        bundle.putStringArray(SAVED_ARRAY, array);
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

        if (data.containsKey(SAVED_ARRAY)) {
            mArray = data.getStringArray(SAVED_ARRAY);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mBuilder = new AlertDialog.Builder(getActivity());

        mBuilder.setTitle(mTitleRefId);
        mBuilder.setSingleChoiceItems(mArray, DEFAULT_POSITION, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSelected = which;
            }
        });

        setButtons();

        return mBuilder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mArray != null) {
            outState.putStringArray(SAVED_ARRAY, mArray);
        }
    }

    public SingleChoiceDialogFragment setPositiveListener(DialogButtonsListener listener) {
        mPositiveListener = listener;
        return this;
    }

    public SingleChoiceDialogFragment setNegativeListener(DialogButtonsListener listener) {
        mNegativeListener = listener;
        return this;
    }

    @Override
    protected void setButtons() {
        if (mPositive != -1) {
            mBuilder.setPositiveButton(mPositive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mPositiveListener != null) {
                        mPositiveListener.onDialogButtonClick(SingleChoiceDialogFragment.this, mPositive, mSelected);
                    }
                }
            });
        }

        if (mNegative != -1) {
            mBuilder.setNegativeButton(mNegative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (mNegativeListener != null) {
                        mNegativeListener.onDialogButtonClick(SingleChoiceDialogFragment.this, mNegative, mSelected);
                    }
                }
            });
        }
    }

    public interface DialogButtonsListener {
        void onDialogButtonClick(DialogFragment dialog, int buttonTitle, int selectedOption);
    }
}

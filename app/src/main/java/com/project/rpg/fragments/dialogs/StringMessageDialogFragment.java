package com.project.rpg.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by laetitia on 6/30/15.
 */
public class StringMessageDialogFragment extends BaseDialogFragment {

    protected static final String SAVED_MESSAGE = "savedMessage";

    protected String mMessage;

    public static StringMessageDialogFragment newInstance(int title, String message, int positiveButton, int negativeButton) {
        StringMessageDialogFragment fragment = new StringMessageDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putString(SAVED_MESSAGE, message);
        bundle.putInt(SAVED_POSITIVE, positiveButton);
        bundle.putInt(SAVED_NEGATIVE, negativeButton);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static StringMessageDialogFragment newInstance(int title, String message, int positiveButton) {
        StringMessageDialogFragment fragment = new StringMessageDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SAVED_TITLE, title);
        bundle.putString(SAVED_MESSAGE, message);
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

        if (data.containsKey(SAVED_MESSAGE)) {
            mMessage = data.getString(SAVED_MESSAGE);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mBuilder.setTitle(mTitleRefId);
        mBuilder.setMessage(mMessage);

        setButtons();

        return mBuilder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!TextUtils.isEmpty(mMessage)) {
            outState.putString(SAVED_MESSAGE, mMessage);
        }
    }
}

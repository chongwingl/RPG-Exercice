package com.project.rpg.exceptions;

import android.content.Context;

/**
 * Created by laetitia on 5/14/15.
 */
public abstract class BasicException extends Exception {

    private static final long serialVersionUID = -1352067443606100744L;

    protected int mErrorMessageRefId;
    protected  String mDetailMessage;

    protected BasicException() {
        mErrorMessageRefId = getErrorMessageRefId();
    }

    protected BasicException(Context context) {
        mErrorMessageRefId = getErrorMessageRefId();
        getStringMessageFromRefID(context);
    }

    public BasicException(String detailMessage) {
        super(detailMessage);
    }

    public void getStringMessageFromRefID(Context context) {
        mDetailMessage = context.getString(mErrorMessageRefId);
    }

    public String getMessage(Context context) {
        getStringMessageFromRefID(context);
        return mDetailMessage;
    }

    public int getMessageRefId() {
        return mErrorMessageRefId;
    }

    @Override
    public String getMessage() {
        return mDetailMessage;
    }

    protected abstract int getErrorMessageRefId();
}

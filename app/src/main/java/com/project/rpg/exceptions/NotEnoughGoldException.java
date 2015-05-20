package com.project.rpg.exceptions;

import com.project.rpg.R;

/**
 * Created by laetitia on 5/14/15.
 */
public class NotEnoughGoldException extends BasicException {

    private static final long serialVersionUID = -6637518129515415442L;

    public NotEnoughGoldException() {
    }

    @Override
    protected int getErrorMessageRefId() {
        return R.string.error_not_enough_gold;
    }
}

package com.project.rpg.exceptions;

import com.project.rpg.R;

/**
 * Created by laetitia on 5/14/15.
 */
public class NoMoreLifeException extends BasicException {

    private static final long serialVersionUID = -6637518129515415442L;

    public NoMoreLifeException() {
    }

    @Override
    protected int getErrorMessageRefId() {
        return R.string.error_no_more_life;
    }
}

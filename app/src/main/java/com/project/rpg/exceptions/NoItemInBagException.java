package com.project.rpg.exceptions;

import com.project.rpg.R;

/**
 * Created by laetitia on 5/21/15.
 */
public class NoItemInBagException extends BasicException {

    @Override
    protected int getErrorMessageRefId() {
        return R.string.no_item_in_bag_exception;
    }
}

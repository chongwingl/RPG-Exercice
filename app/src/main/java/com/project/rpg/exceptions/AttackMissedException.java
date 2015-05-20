package com.project.rpg.exceptions;

import com.project.rpg.R;

/**
 * Created by laetitia on 5/19/15.
 */
public class AttackMissedException extends BasicException {

    public AttackMissedException() {
    }

    @Override
    protected int getErrorMessageRefId() {
        return R.string.attack_missed_exception;
    }
}

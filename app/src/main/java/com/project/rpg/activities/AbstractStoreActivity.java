package com.project.rpg.activities;

import android.os.Bundle;

import com.project.rpg.models.stores.AbstractStoreBuilder;

/**
 * Created by laetitia on 5/6/15.
 */
public abstract class AbstractStoreActivity extends AbstractShowCategoryItemActivity {

    protected AbstractStoreBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setStoreBuilder();
        super.onCreate(savedInstanceState);
    }

    public abstract void setStoreBuilder();


}

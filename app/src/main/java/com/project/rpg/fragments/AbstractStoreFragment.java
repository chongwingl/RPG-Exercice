package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.rpg.models.stores.AbstractStoreBuilder;

/**
 * Created by laetitia on 4/22/15.
 */
public abstract class AbstractStoreFragment extends AbstractShowCategoryItemFragment {


    protected AbstractStoreBuilder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        setStoreBuilder();
        return v;
    }

    public abstract void setStoreBuilder();


}

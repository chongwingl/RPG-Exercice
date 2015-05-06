package com.project.rpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by laetitia on 4/21/15.
 */
public abstract class AbstractFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    public abstract int getLayoutResourceId();
    public abstract String getTAG();
}

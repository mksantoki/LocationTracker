package com.mk.locationtracker.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The type Base fragment.
 */
abstract public class BaseFragment extends Fragment {
    /**
     * The Unbinder.
     */
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initControl();
        return view;
    }

    /**
     * Sets layout.
     *
     * @return the layout
     */
    protected abstract int setLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initListener();
    }

    /**
     * Init listener.
     */
    protected abstract void initListener();

    /**
     * Init view.
     *
     * @param view the view
     */
    protected abstract void initView(View view);

    /**
     * Init control.
     */
    protected abstract void initControl();


}

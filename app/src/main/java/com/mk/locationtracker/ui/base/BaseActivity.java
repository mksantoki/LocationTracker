package com.mk.locationtracker.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        initControl();
        initView();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initControl();

    protected abstract int setLayout();
}

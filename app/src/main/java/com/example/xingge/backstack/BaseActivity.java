package com.example.xingge.backstack;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.fragmentManager = getSupportFragmentManager();
        App.activity = this;
    }

    @Override
    public void onBackPressed() {

        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if("AFragment".equals(simpleName) || "BFragment".equals(simpleName) || "CFragment".equals(simpleName)){
            finish();
        }else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                App.lastFragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }

    }
}

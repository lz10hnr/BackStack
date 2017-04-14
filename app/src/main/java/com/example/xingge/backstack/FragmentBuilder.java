package com.example.xingge.backstack;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by xingge on 2017/4/14.
 */

public class FragmentBuilder {

    private static FragmentBuilder builder;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BaseFragment fragment;
    private FragmentBuilder(){
        init();
    }
    public synchronized static FragmentBuilder getInstance(){
        if(builder == null)
            builder = new FragmentBuilder();
        return builder;
    }

    private void init(){
        fragmentManager = App.activity.getSupportFragmentManager();
    }

    public FragmentBuilder start(Class<? extends BaseFragment> fragmentClass){

        transaction = fragmentManager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        if(fragment == null){
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(R.id.contentGroup,fragment,simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if(App.lastFragment != null)
            transaction.hide(App.lastFragment);

        transaction.show(fragment);

        transaction.addToBackStack(simpleName);

        return this;
    }

    public FragmentBuilder params(Bundle bundle){
        fragment.setParams(bundle);
        return this;
    }

    public BaseFragment build(){
        App.lastFragment = fragment;
        transaction.commit();
        return fragment;
    }
}

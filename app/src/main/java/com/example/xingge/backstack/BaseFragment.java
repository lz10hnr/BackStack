package com.example.xingge.backstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/4/14.
 */

public abstract class BaseFragment extends Fragment {

    protected Bundle bundle;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayoutId();

    @Override
    public void onHiddenChanged(boolean hidden) {

        if (hidden)
            onHidden();
        else
            onShow();

    }

    /**
     * fragment可见时调用
     */
    protected void onShow(){



    }

    /**
     * fragment不可见时调用
     */
    protected void onHidden(){

    }

    public void setParams(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

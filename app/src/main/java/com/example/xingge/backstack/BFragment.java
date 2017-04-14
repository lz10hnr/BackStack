package com.example.xingge.backstack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by xingge on 2017/4/14.
 */

public class BFragment extends BaseFragment {
    @BindView(R.id.bbbBtn)
    Button bbbBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.b_fragment;
    }


    @OnClick(R.id.bbbBtn)
    public void onViewClicked() {
        FragmentBuilder.getInstance().start(DFragment.class).build();
    }
}

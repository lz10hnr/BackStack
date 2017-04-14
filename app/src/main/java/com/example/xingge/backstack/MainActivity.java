package com.example.xingge.backstack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.contentGroup)
    FrameLayout contentGroup;
    @BindView(R.id.aaaBtn)
    Button aaaBtn;
    @BindView(R.id.bbbBtn)
    Button bbbBtn;
    @BindView(R.id.cccBtn)
    Button cccBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentBuilder.getInstance().start(AFragment.class).build();
    }

    @OnClick({R.id.aaaBtn, R.id.bbbBtn, R.id.cccBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.aaaBtn:
                FragmentBuilder.getInstance().start(AFragment.class).build();
                break;
            case R.id.bbbBtn:
                FragmentBuilder.getInstance().start(BFragment.class).build();
                break;
            case R.id.cccBtn:
                FragmentBuilder.getInstance().start(CFragment.class).build();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}

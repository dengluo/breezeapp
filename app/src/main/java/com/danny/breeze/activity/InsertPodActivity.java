package com.danny.breeze.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shun8 on 2018/1/17.
 */

public class InsertPodActivity extends BaseActivity {
    @BindView(R.id.insertpod_activity_iv_ok)
    ImageView insertpod_activity_iv_ok;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_insertpod;
    }

    @Override
    protected void initComplete(Bundle savedInstanceState) {
        //延时后执行
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @OnClick({R.id.insertpod_activity_iv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insertpod_activity_iv_ok:
                Intent intent = new Intent(this,RatePainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

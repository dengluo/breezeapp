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

public class BreezeCompleteActivity extends BaseActivity {
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_breeze_complete;
    }

    @Override
    protected void initComplete(Bundle savedInstanceState) {
        //延时后执行
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity();
            }
        }, 2 * 1000);
    }

    private void startActivity() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
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

}

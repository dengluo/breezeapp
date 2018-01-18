package com.danny.breeze.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by shun8 on 2018/1/17.
 */

public class SessionStartActivity2 extends BaseActivity {
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_session_start2;
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
        startActivity(new Intent(this, SessionStartActivity3.class));
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

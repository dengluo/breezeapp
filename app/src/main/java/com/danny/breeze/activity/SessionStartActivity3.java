package com.danny.breeze.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

/**
 * Created by shun8 on 2018/1/17.
 */

public class SessionStartActivity3 extends BaseActivity {
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_session_start3;
    }

    @Override
    protected void initComplete(Bundle savedInstanceState) {
        //延时后执行
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity();
            }
        }, 60 * 1000);
    }

    private void startActivity() {
        SharedPreferences sp =this.getSharedPreferences("SessionStart", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("SessionStartO", "come");
        editor.commit();
        startActivity(new Intent(this, RatePainActivity.class));
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

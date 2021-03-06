package com.danny.breeze.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

/**
 * Created by shun8 on 2018/1/17.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_welcome;
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
//        User user = getUserEntity();
//        L.e("user="+user+"getEmail="+user.getEmail()+"getUsername="+user.getUsername());
//        if (user != null
//                && !TextUtils.isEmpty(user.getUsername())
//                ) {
//            startActivity(new Intent(this, MainActivity2.class));
//        } else {
//            startActivity(new Intent(this, LoginActivity2.class));
//        }
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

package com.danny.breeze.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.bestmafen.smablelib.component.SimpleSmaCallback;
import com.bestmafen.smablelib.component.SmaManager;
import com.danny.breeze.BuildConfig;
import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

/**
 * Created by shun8 on 2018/1/17.
 */

public class SessionStartActivity3 extends BaseActivity {
    private static final String Tag = "SessionStartActivity3";
    private SmaManager mSmaManager;
    private Handler mDsHandlerSession3 = new Handler();//定时发送handler
    Runnable update_thread_session3 = new Runnable() {
        public void run() {
            Log.e("run==",Tag+"=="+mSmaManager);
            mSmaManager.write(SmaManager.SET.INTO_BREEZE,String.valueOf(6));
            mDsHandlerSession3.postDelayed(this, 5000);

        }
    };

    @Override
    protected void onDestroy() {
        mDsHandlerSession3.removeCallbacks(update_thread_session3);
        super.onDestroy();
    }

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
        mSmaManager.write(SmaManager.SET.INTO_BREEZE,String.valueOf(6));
        SharedPreferences sp = this.getSharedPreferences("SessionStart", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("SessionStartO", "come");
        editor.commit();
        startActivity(new Intent(this, RatePainActivity.class).putExtra("devicename","have"));
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
//        if(!mSmaManager.isConnected){
//            mSmaManager.connect(true);
//        }else{
//            mDsHandlerSession3.post(update_thread_session3);
//        }
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        mSmaManager = SmaManager.getInstance();
        mDsHandlerSession3.post(update_thread_session3);
    }
}

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
    private SmaManager mSmaManager;
    private Handler mDsHandler = new Handler();//定时发送handler
    Runnable update_thread = new Runnable() {
        public void run() {
            Log.e("run==","==runrunrun");
            mSmaManager.write(SmaManager.SET.INTO_BREEZE,String.valueOf(6));
            mDsHandler.postDelayed(this, 5000);
        }
    };

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
        mDsHandler.post(update_thread);
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        mSmaManager = SmaManager.getInstance().init(this).addSmaCallback(new SimpleSmaCallback() {

            @Override
            public void onConnected(BluetoothDevice device, boolean isConnected) {
                if (BuildConfig.DEBUG) {
                    append("  ->  isConnected " + isConnected);
                }
            }

            @Override
            public void onWrite(byte[] data) {
                if (BuildConfig.DEBUG) {
                    append("  ->  onWrite", data);
                }
            }

            @Override
            public void onRead(byte[] data) {
                if (BuildConfig.DEBUG) {
                    append("  ->  onRead", data);
                }
            }
        });
        mSmaManager.connect(true);
    }

    /**
     * @param type 0写 1读
     * @param data content
     */
    private synchronized void append(final String type, final byte[] data) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
//                mTvDebug.append(getTimeStr() + "  " + type + "\n");
//                mTvDebug.append(EaseUtils.byteArray2HexString(data));
//                mTvDebug.append("  " + getValue(data));
//                mTvDebug.append("\n\n");
            }
        });
    }

    private synchronized void append(final String value) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
//                mTvDebug.append(getTimeStr() + "\n");
//                mTvDebug.append("  " + value);
//                mTvDebug.append("\n\n");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mSmaManager.exit();
        mDsHandler.removeCallbacks(update_thread);
        super.onDestroy();
    }

}

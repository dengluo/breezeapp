package com.danny.breeze.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bestmafen.smablelib.component.SimpleSmaCallback;
import com.bestmafen.smablelib.component.SmaManager;
import com.danny.breeze.BuildConfig;
import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by shun8 on 2018/1/17.
 */

public class SessionStartActivity2 extends BaseActivity {
    private SmaManager mSmaManager;

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
        mSmaManager.write(SmaManager.SET.INTO_BREEZE);
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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mSmaManager.exit();
        super.onDestroy();
    }

}

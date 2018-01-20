package com.danny.breeze.activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bestmafen.easeblelib.util.EaseUtils;
import com.bestmafen.easeblelib.util.L;
import com.bestmafen.smablelib.component.SimpleSmaCallback;
import com.bestmafen.smablelib.component.SmaManager;
import com.danny.breeze.BuildConfig;
import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;
import com.danny.breeze.interfaces.DialogCallback;
import com.danny.breeze.util.DialogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shun8 on 2018/1/17.
 */

public class RatePainActivity extends BaseActivity {
    @BindView(R.id.rate_pain_activity_iv_ok)
    ImageView rate_pain_activity_iv_ok;
    @BindView(R.id.rate1_tv)
    AppCompatTextView rate1_tv;
    @BindView(R.id.rate0_tv)
    AppCompatTextView rate0_tv;
    @BindView(R.id.rate2_tv)
    AppCompatTextView rate2_tv;
    @BindView(R.id.rate3_tv)
    AppCompatTextView rate3_tv;
    @BindView(R.id.rate4_tv)
    AppCompatTextView rate4_tv;
    @BindView(R.id.rate5_tv)
    AppCompatTextView rate5_tv;
    @BindView(R.id.rate6_tv)
    AppCompatTextView rate6_tv;
    @BindView(R.id.rate7_tv)
    AppCompatTextView rate7_tv;
    @BindView(R.id.rate8_tv)
    AppCompatTextView rate8_tv;
    @BindView(R.id.rate9_tv)
    AppCompatTextView rate9_tv;
    @BindView(R.id.rate10_tv)
    AppCompatTextView rate10_tv;
    @BindView(R.id.tv_ratepain_search)
    TextView tv_ratepain_search;

    private SmaManager mSmaManager;
    public static Handler mHandler;
    private Handler mDsHandler = new Handler();//定时发送handler
    Boolean isChecked = false;
    String str;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_ratepain;
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

    Runnable update_thread = new Runnable() {
        public void run() {
            Log.e("run==", "==" + mSmaManager);
            mSmaManager.write(SmaManager.SET.INTO_BREEZE, String.valueOf(6));
            mDsHandler.postDelayed(this, 5000);
        }
    };

    @Override
    protected void initView() {

        if (mSmaManager.getNameAndAddress()[0].equals("")||mSmaManager.getNameAndAddress()[0].equals(null)){
            tv_ratepain_search.setText(getResources().getText(R.string.bind_device));
        }else{
            tv_ratepain_search.setText(mSmaManager.getNameAndAddress()[0]);
        }
        mDsHandler.post(update_thread);
    }

    /**
     * @param type 0写 1读
     * @param data content
     */
    private synchronized void append(final String type, final byte[] data) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

            }
        });
    }

    private synchronized void append(final String value) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
            }
        });
    }

    @SuppressLint("HandlerLeak")
    @Override
    protected void init(Bundle savedInstanceState) {
        SharedPreferences sp = this.getSharedPreferences("SessionStart", MODE_PRIVATE);
        str = sp.getString("SessionStartO", "");

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
        if (BuildConfig.DEBUG) {
//            mDebugViewManager = new DebugViewManager(this);
        }

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 19:
                        tv_ratepain_search.setText(mSmaManager.getNameAndAddress()[0]);
                        mDsHandler.post(update_thread);
                        break;
                }
            }
        };
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

    public void clearView() {
        isChecked = true;
        rate1_tv.setBackgroundResource(R.drawable.rate_pain_0);
        rate0_tv.setBackgroundResource(R.drawable.rate_pain_1);
        rate2_tv.setBackgroundResource(R.drawable.rate_pain_2);
        rate3_tv.setBackgroundResource(R.drawable.rate_pain_3);
        rate4_tv.setBackgroundResource(R.drawable.rate_pain_4);
        rate5_tv.setBackgroundResource(R.drawable.rate_pain_5);
        rate6_tv.setBackgroundResource(R.drawable.rate_pain_6);
        rate7_tv.setBackgroundResource(R.drawable.rate_pain_7);
        rate8_tv.setBackgroundResource(R.drawable.rate_pain_8);
        rate9_tv.setBackgroundResource(R.drawable.rate_pain_9);
        rate10_tv.setBackgroundResource(R.drawable.rate_pain_10);

    }

    @OnClick({R.id.rate_pain_activity_iv_ok, R.id.rate1_tv, R.id.rate0_tv, R.id.rate2_tv, R.id.rate3_tv,
            R.id.rate4_tv, R.id.rate5_tv, R.id.rate6_tv, R.id.rate7_tv, R.id.rate8_tv, R.id.rate9_tv,
            R.id.rate10_tv, R.id.tv_ratepain_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rate_pain_activity_iv_ok:
                Log.e("str===", str + "");
                if (tv_ratepain_search.getText().toString().equals("绑定设备")) {
                    tv_ratepain_search.setText("绑定设备");
                    Toast.makeText(mContext, "请先绑定设备", Toast.LENGTH_SHORT).show();
                } else {
                    tv_ratepain_search.setText(mSmaManager.getNameAndAddress()[0]);
                    if (!isChecked) {
                        Intent intent = new Intent(this, PleaseRatePainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        if (str.equals("")) {
                            SmaManager.getInstance().unbind();
                            mSmaManager.write(SmaManager.SET.INTO_BREEZE, String.valueOf(6));
                            Intent intent = new Intent(this, SessionStartActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Intent intent = new Intent(this, BreezeCompleteActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                }


                break;
            case R.id.rate1_tv:
                clearView();
                rate1_tv.setBackgroundResource(R.drawable.rate_pain_0_fill);
                break;
            case R.id.rate0_tv:
                clearView();
                rate0_tv.setBackgroundResource(R.drawable.rate_pain_1_fill);
                break;
            case R.id.rate2_tv:
                clearView();
                rate2_tv.setBackgroundResource(R.drawable.rate_pain_2_fill);
                break;
            case R.id.rate3_tv:
                clearView();
                rate3_tv.setBackgroundResource(R.drawable.rate_pain_3_fill);
                break;
            case R.id.rate4_tv:
                clearView();
                rate4_tv.setBackgroundResource(R.drawable.rate_pain_4_fill);
                break;
            case R.id.rate5_tv:
                clearView();
                rate5_tv.setBackgroundResource(R.drawable.rate_pain_5_fill);
                break;
            case R.id.rate6_tv:
                clearView();
                rate6_tv.setBackgroundResource(R.drawable.rate_pain_6_fill);
                break;
            case R.id.rate7_tv:
                clearView();
                rate7_tv.setBackgroundResource(R.drawable.rate_pain_7_fill);
                break;
            case R.id.rate8_tv:
                clearView();
                rate8_tv.setBackgroundResource(R.drawable.rate_pain_8_fill);
                break;
            case R.id.rate9_tv:
                clearView();
                rate9_tv.setBackgroundResource(R.drawable.rate_pain_9_fill);
                break;
            case R.id.rate10_tv:
                clearView();
                rate10_tv.setBackgroundResource(R.drawable.rate_pain_10_fill);
                break;
            case R.id.tv_ratepain_search:
                if (tv_ratepain_search.getText().toString().equals("绑定设备")) {
                    startActivity(new Intent(RatePainActivity.this, BindDeviceActivity.class));
                } else {
                    DialogUtil.defaultDialog(mContext, getString(R.string.confirm_unbind_device), null, null, new
                            DialogCallback() {

                                @Override
                                public void execute(Object dialog, Object content) {
                                    //确认解绑
                                    SmaManager.getInstance().unbind();
                                    tv_ratepain_search.setText("绑定设备");
                                }
                            });
                }

                break;
        }
    }
}

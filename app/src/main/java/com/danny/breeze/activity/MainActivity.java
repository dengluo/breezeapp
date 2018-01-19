package com.danny.breeze.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bestmafen.easeblelib.util.EaseUtils;
import com.bestmafen.smablelib.component.SimpleSmaCallback;
import com.bestmafen.smablelib.component.SmaManager;
import com.danny.breeze.BuildConfig;
import com.danny.breeze.R;
import com.danny.breeze.adapter.CardPagerAdapter;
import com.danny.breeze.base.BaseActivity;
import com.danny.breeze.bean.CardItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shun8 on 2018/1/17.
 */

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener,CardPagerAdapter.sendMsgListener {
    @BindView(R.id.right_arrow)
    ImageView right_arrow;
    @BindView(R.id.left_arrow)
    ImageView left_arrow;
//    @BindView(R.id.iv_product)
//    ImageView iv_product;
    @BindView(R.id.select_pod_bt_ok)
    ImageView select_pod_bt_ok;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private CardPagerAdapter mCardAdapter;
    private SmaManager mSmaManager;
    private DateFormat mDateFormat = new SimpleDateFormat("HH:mm:ss");
    int code;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComplete(Bundle savedInstanceState) {
    }


    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mCardAdapter = new CardPagerAdapter(this);
        mCardAdapter.addCardItem(new CardItem( 1));
        mCardAdapter.addCardItem(new CardItem( 2));
        mCardAdapter.addCardItem(new CardItem( 3));
        mCardAdapter.addCardItem(new CardItem( 4));
        mCardAdapter.addCardItem(new CardItem( 5));
        mCardAdapter.addCardItem(new CardItem( 6));
        mViewPager.setAdapter(mCardAdapter);
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        SharedPreferences sp =this.getSharedPreferences("SessionStart", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("SessionStartO", "");
        editor.commit();

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

    public String getTimeStr() {
        return mDateFormat.format(new Date());
    }

    private String getValue(@NonNull byte[] extra) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] valuePart = Arrays.copyOfRange(extra, 2, 8);
            for (byte b : valuePart) {
                sb.append((char) b);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
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
        super.onDestroy();
    }

    @OnClick({R.id.right_arrow, R.id.left_arrow, R.id.select_pod_bt_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.right_arrow:
                Log.e("position1===",code+"");
                if(code == 1){
                    mViewPager.setCurrentItem(2);
                }else if(code == 2){
                    mViewPager.setCurrentItem(3);
                }else if(code == 3){
                    mViewPager.setCurrentItem(4);
                }else if(code == 4){
                    mViewPager.setCurrentItem(5);
                }else if(code == 5){
                    mViewPager.setCurrentItem(6);
                }else if(code == 6){

                }
                break;

            case R.id.left_arrow:
                Log.e("position2===",code+"");
                if(code == 6){
                    mViewPager.setCurrentItem(5);
                }else if(code == 5){
                    mViewPager.setCurrentItem(4);
                }else if(code == 4){
                    mViewPager.setCurrentItem(3);
                }else if(code == 3){
                    mViewPager.setCurrentItem(2);
                }else if(code == 2){
                    mViewPager.setCurrentItem(1);
                }else if(code == 1){

                }
                break;

            case R.id.select_pod_bt_ok:
                Intent intent = new Intent(this,InsertPodActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("position===",position+"");
        Log.e("positionOffsetPixels===",positionOffsetPixels+"");
    }

    @Override
    public void onPageSelected(int position) {
        Log.e("onPageSelected===",position+"");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("state===",state+"");
    }

    @Override
    public void SendMsg(int i) {
        Log.e("SendMsg===",i+"");
        code = i;
    }
}

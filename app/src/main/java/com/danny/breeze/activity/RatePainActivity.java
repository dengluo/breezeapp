package com.danny.breeze.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

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

    @Override
    protected void initView() {

    }

    @Override
    protected void init(Bundle savedInstanceState) {
        SharedPreferences sp =this.getSharedPreferences("SessionStart", MODE_PRIVATE);
        str = sp.getString("SessionStartO", "");
    }

    public void clearView(){
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

    @OnClick({R.id.rate_pain_activity_iv_ok,R.id.rate1_tv,R.id.rate0_tv,R.id.rate2_tv,R.id.rate3_tv,R.id.rate4_tv,R.id.rate5_tv,R.id.rate6_tv,R.id.rate7_tv,R.id.rate8_tv,R.id.rate9_tv,R.id.rate10_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rate_pain_activity_iv_ok:
                Log.e("str===",str+"");
                if(!isChecked){
                    Intent intent = new Intent(this,PleaseRatePainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    if (str.equals("")){
                        Intent intent = new Intent(this,SessionStartActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(this,BreezeCompleteActivity.class);
                        startActivity(intent);
                        finish();
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
        }
    }
}

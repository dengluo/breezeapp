package com.danny.breeze.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.danny.breeze.R;
import com.danny.breeze.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shun8 on 2018/1/17.
 */

public class SessionStartActivity extends BaseActivity {
    @BindView(R.id.warming_progress_bar)
    RoundCornerProgressBar warming_progress_bar;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_session_start;
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
        startActivity(new Intent(this, SessionStartActivity2.class));
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
//        warming_progress_bar.setProgressColor(Color.parseColor("#ed3b27"));
//        warming_progress_bar.setProgressBackgroundColor(Color.parseColor("#808080"));
//        warming_progress_bar.setMax(70);
//        warming_progress_bar.setProgress(15);
        warming_progress_bar.setProgressBackgroundColor(getResources().getColor(R.color.custom_progress_background));
        updateProgressTwoColor();
    }

    private void updateProgressTwoColor() {
        float progress = warming_progress_bar.getProgress();
        if(progress <= 3) {
            warming_progress_bar.setProgressColor(getResources().getColor(R.color.custom_progress_red_progress));
        } else if(progress > 3 && progress <= 6) {
            warming_progress_bar.setProgressColor(getResources().getColor(R.color.custom_progress_orange_progress));
        } else if(progress > 6) {
            warming_progress_bar.setProgressColor(getResources().getColor(R.color.custom_progress_green_progress));
        }
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

}

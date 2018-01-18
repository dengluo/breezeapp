package com.danny.breeze.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.danny.breeze.R;
import com.danny.breeze.bean.CardItem;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    Context mContext;
    sendMsgListener sml;

    public CardPagerAdapter(Context context) {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        this.mContext = context;
        sml = (sendMsgListener) context;
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.select_pod_adapter_layout, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void bind(CardItem item, View view) {
        ImageView pod_image = view.findViewById(R.id.pod_image);
        Log.e("item.getText()===",item.getText()+"");
        if (item.getText() == 1){
            pod_image.setBackgroundResource(R.drawable.pod_yellow);
        }else if (item.getText() == 2){
            pod_image.setBackgroundResource(R.drawable.pod_blue);
        }else if (item.getText() == 3){
            pod_image.setBackgroundResource(R.drawable.pod_green);
        }else if (item.getText() == 4){
            pod_image.setBackgroundResource(R.drawable.pod_pink);
        }else if (item.getText() == 5){
            pod_image.setBackgroundResource(R.drawable.pod_purple);
        }else if (item.getText() == 6){
            pod_image.setBackgroundResource(R.drawable.pod_orange);
        }
        sml.SendMsg(item.getText());
    }

    public interface sendMsgListener{
        public void SendMsg(int i);
    }

}

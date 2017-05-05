package com.hyh.mywheelview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ItemActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
        MyWheelView wheelView = (MyWheelView) findViewById(R.id.myWheelView);
        wheelView.setOffset(2);//设置item显示条数2n+1
        wheelView.setItemViewTextColor(R.color.colorPrimary, R.color.colorAccent);//设置条目字体颜色，默认黑灰
        wheelView.setItemViewTextSize(30,20);//设置条目字体大小,默认15
        wheelView.setSeletion(0);//默认选择条目
        wheelView.setHaveLine(true);//是否有分隔线,无法和条目背景颜色方法同时设置
        wheelView.setLineHeight(10);//分隔线高度
        wheelView.setLineWidth(30,30);//分隔线左右间距
        wheelView.setLineColor(R.color.colorAccent);//分隔线颜色
        wheelView.setItems(Arrays.asList(temp));//添加数据源吧

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.e("select",item);
            }
        });
    }
}

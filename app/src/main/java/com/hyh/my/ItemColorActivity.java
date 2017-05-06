package com.hyh.my;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.hyh.mywheelview.MyWheelView;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ItemColorActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
        MyWheelView wheelView = (MyWheelView) findViewById(R.id.myWheelView);
        wheelView.setOffset(2);//设置item显示条数2n+1
        wheelView.setItemViewBackground(R.color.colorAccent,R.color.colorPrimary);//设置条目颜色,默认无
        wheelView.setItemViewTextColor(R.color.white, R.color.colorAccent);//设置条目字体颜色，默认黑灰
        wheelView.setItemViewTextSize(30,20);//设置条目字体大小,默认15
        wheelView.setSeletion(0);//默认选择条目
        wheelView.setItems(Arrays.asList(temp));//添加数据源吧

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.e("select",item);
            }
        });
    }
}

package com.hyh.mywheelview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
                startActivity(new Intent().setClass(this,ItemActivity.class));
                break;
            case R.id.b2:
                startActivity(new Intent().setClass(this,ItemColorActivity.class));
                break;
            case R.id.b3:
                setDilog();
//                startActivity(new Intent().setClass(this,DilogActivity.class));
                break;
        }
    }

    String itemString;
    Dialog dialog;
    public void setDilog(){
        dialog = new Dialog(this);
        String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
//        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        View rootView = View.inflate(this, R.layout.view_wheelview, null);
        MyWheelView wheelView = (MyWheelView) rootView.findViewById(R.id.wheelView);
        wheelView.setOffset(1);
        wheelView.setItems(Arrays.asList(temp));
        wheelView.setSeletion(0);
        wheelView.setHaveLine(false);

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                itemString = item;
            }
        });

        TextView quxiao = (TextView) rootView.findViewById(R.id.quxiao);

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        TextView queding = (TextView) rootView.findViewById(R.id.queding);
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,itemString,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setContentView(rootView);
        dialog.show();
    }
}

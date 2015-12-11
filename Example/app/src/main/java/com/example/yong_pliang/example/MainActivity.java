package com.example.yong_pliang.example;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.jerry.jnotification.Notification;
import org.jerry.jnotification.NotificationCenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //向通知中心注册通知
            NotificationCenter.getInstance().addObserver(this,this.getClass().getMethod("onNotification",Notification.class),"NotificationName",null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //从通知中心取消注册
        NotificationCenter.getInstance().removeObserver(this);
    }

    /**
     * 监听通知
     * @param notification
     */
    public void onNotification(Notification notification){
        System.out.println("接收到通知"+notification);
    }

    /**
     * 监听页面点击事件,跳转到第二个页面
     * @param view
     */
    public void btnDidClicked(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        startActivity(intent);
    }

}

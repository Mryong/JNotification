package com.example.yong_pliang.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.jerry.jnotification.NotificationCenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong_pliang on 15/12/11.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }


    public void btnDidClicked(View view){
        //发布通知
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("key","value");
        NotificationCenter.getInstance().postNotification(this,"NotificationName",userInfo);


    }
}

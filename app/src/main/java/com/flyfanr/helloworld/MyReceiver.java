package com.flyfanr.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION = "com.flyfanr.helloworld.intent.action.MyReciever";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

//        System.out.println("接收到了消息，消息的内容是："+intent.getStringExtra("data"));
        System.out.println("MyReciever 接收到了消息");

        abortBroadcast();
    }
}

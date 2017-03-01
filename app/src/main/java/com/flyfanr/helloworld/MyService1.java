package com.flyfanr.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService1 extends Service {
    private boolean running = false;
    private String data = "这是默认信息";

    public MyService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public class Binder extends android.os.Binder {

        public void setData(String data){
            MyService1.this.data = data;
        }

        public MyService1 getService() {
            return  MyService1.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        data = intent.getStringExtra("data");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        running = true;
        new Thread(){
            @Override
            public void run() {
                super.run();

                int i = 0;

                while (running){

                    i++;

                    String str = i+":"+data;

                    System.out.println(str);

                    if(callback!= null) {
                        callback.onDataChange(str);
                    }

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        running = false;
    }

    private Callback callback = null;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public static interface Callback {
        void onDataChange(String data);
    }
}

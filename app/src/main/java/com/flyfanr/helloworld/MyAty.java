package com.flyfanr.helloworld;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by liuziyu on 16/5/6.
 */
public class MyAty extends Activity {

    public static final String ACTION = "com.flyfanr.helloworld.intent.action.MyAty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
    }
}

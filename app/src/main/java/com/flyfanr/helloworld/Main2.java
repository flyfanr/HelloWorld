package com.flyfanr.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by liuziyu on 16/7/14.
 */
public class Main2 extends AppCompatActivity {

    private TextView textView;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        textView = (TextView) findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText2);

        //textView.setText("共享的数据是："+getApp().getTextData());

        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getApp().setTextData(editText.getText().toString());

                textView.setText("共享的数据是："+editText.getText().toString());
            }
        });

        setContentView(R.layout.main2);
    }
    public App getApp()
    {
        return (App)getApplicationContext();
    }
}

package com.flyfanr.helloworld;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class LearnContext extends AppCompatActivity {

    private TextView textView7;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        tvc = new TextView(this);
//        tvc.setText(R.string.hello_world);
//        //setContentView(tvc);
//
//        System.out.println(getResources().getText(R.string.hello_world));
//
//        ImageView iv = new ImageView(this);
//        iv.setImageResource(R.mipmap.ic_launcher);


        textView7 = (TextView) findViewById(R.id.textView7);
        editText2 = (EditText) findViewById(R.id.editText2);

        //textView7.setText("共享的数据是："+getApp().getTextData());

        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView7.setText(editText2.getText().toString());
            }
        });

//        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //getApp().setTextData(editText2.getText().toString());
//
//                textView7.setText("共享的数据是："+editText2.getText().toString());
//            }
//        });

        setContentView(R.layout.main1);
    }

    public App getApp()
    {
        return (App)getApplicationContext();
    }

}

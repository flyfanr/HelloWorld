package com.flyfanr.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TheAty extends AppCompatActivity {

    private TextView tv;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_aty);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv = (TextView) findViewById(R.id.tv);
        editText = (EditText) findViewById(R.id.editText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "23333333", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = getIntent();
//                Bundle data = i.getExtras();
//
//                tv.setText(String.format("name=%s,age=%d,name1=%s",data.getString("name"),data.getInt("age"),data.getString("name1","leo")));

//                User user= (User) i.getSerializableExtra("user");
                User user = i.getParcelableExtra("user");
                tv.setText(String.format("User info(name=%s,age=%d)", user.getName(), user.getAge()));
                //tv.setText(i.getString("data"));
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.putExtra("data", editText.getText().toString());
                setResult(1, i);
                finish();
            }
        });
        Intent b = new Intent();
        b.putExtra("data",editText.getText().toString());
        if(editText.getText().toString().isEmpty()) {
            setResult(2, b);
        }
        else
        {
            setResult(0, b);
        }
    }
//    public void onDestroy() {
//
//            Intent i = new Intent();
//            i.putExtra("data",editText.getText().toString());
//            if(editText.getText().toString().isEmpty()) {
//                setResult(2, i);
//            }
//            else {
//                setResult(0, i);
//            }
//        super.onDestroy();
//    }

}

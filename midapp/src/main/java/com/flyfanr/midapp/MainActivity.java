package com.flyfanr.midapp;

import android.content.Intent;
import android.hardware.camera2.params.BlackLevelPattern;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnFragment).setOnClickListener(this);
        findViewById(R.id.btnLayout).setOnClickListener(this);
        findViewById(R.id.btnRecyclerView).setOnClickListener(this);
        findViewById(R.id.btnComponents).setOnClickListener(this);
        findViewById(R.id.btnDrawer).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFragment:
                startActivity(new Intent(MainActivity.this, LearnFragment.class));
                break;
            case R.id.btnLayout:
                startActivity(new Intent(MainActivity.this, LearnLayout.class));
                break;
            case R.id.btnRecyclerView:
                startActivity(new Intent(MainActivity.this, LearnRv.class));
                break;
            case R.id.btnComponents:
                startActivity(new Intent(MainActivity.this, LearnComponents.class));
                break;
            case R.id.btnDrawer:
                startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                break;
        }
    }
}

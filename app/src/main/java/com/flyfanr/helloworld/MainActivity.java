package com.flyfanr.helloworld;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private TextView textView2;
    private TextView tv;

    private Intent intent;
    private Intent i;

    private EditText etData;
    private MyService1.Binder binder = null;
    private TextView tvOut;

    private static String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView2 = (TextView) findViewById(R.id.textView2);

        tv = (TextView) findViewById(R.id.tv);

        tv.setText(String.format("TaskID:%d\nCurrent Activity id%s",getTaskId(),toString()));

        intent = new Intent(MainActivity.this,MyService.class);
        i = new Intent(MainActivity.this, MyService1.class);

        etData = (EditText) findViewById(R.id.etData);
        tvOut = (TextView) findViewById(R.id.tvOut);

        findViewById(R.id.btnStartMainAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        findViewById(R.id.btnStartB_Aty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,B_Aty.class));
            }
        });

        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //               startActivity(new Intent(MainActivity.this,AnotherAty.class));
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://flyfanr.com")));
            }
        });

        findViewById(R.id.btnStartBAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BAty.class));
            }
        });

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TheAty.class);
                //i.putExtra("data","Hello flyfanr");

//                Bundle b = new Bundle();
//                b.putString("name", "flyfanr");
//                b.putInt("age", 20);
//                b.putString("name1","flyfanr");
//                i.putExtras(b);
                i.putExtra("user", new User("flyfanr",20));

//                startActivity(i);
                startActivityForResult(i,0);
            }
        });

        findViewById(R.id.btnStartMyAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAty.ACTION));
            }
        });

        findViewById(R.id.LearnContext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LearnContext.class));
            }
        });

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);

        findViewById(R.id.btnStartService1).setOnClickListener(this);
        findViewById(R.id.btnStopService1).setOnClickListener(this);
        findViewById(R.id.btnBindService1).setOnClickListener(this);
        findViewById(R.id.btnUnbindService1).setOnClickListener(this);
        findViewById(R.id.btnSyncData).setOnClickListener(this);

        findViewById(R.id.btnSendMessage).setOnClickListener(this);
        findViewById(R.id.btnReg).setOnClickListener(this);
        findViewById(R.id.btnUnreg).setOnClickListener(this);

        findViewById(R.id.btnWebView).setOnClickListener(this);

        //startService(new Intent(this,AppService.class));

//        System.out.println("普通日志Info");
//        System.err.println("错误日志Warn");
        Log.e(TAG,"错误信息");
        Log.w(TAG,"警告信息");
        Log.i(TAG,"普通信息");
        Log.d(TAG,"调试信息");
        Log.v(TAG,"无用信息");
        Log.e("MSG","其他信息");


        Hello.sayHello(this);

        System.out.println("A OnCreat");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//      if(resultCode == 0)
//        {
//            if(!data.getStringExtra("data").isEmpty())
//            {
//                textView2.setText("你输入了“"+data.getStringExtra("data")+"”之后，并没有按按钮。");
//            }
//        }
        /*else*/
        if (resultCode == 1 )
        {
            if(!data.getStringExtra("data").isEmpty())
            {
                textView2.setText("机智的你输入了“"+data.getStringExtra("data")+"”之后，又按了按钮。");
            }
            else
            {
                textView2.setText("你按了按钮，然而并没有输入。这就非常尴尬了。");
            }
        }
        else
        {
            textView2.setText("然而你连按钮都没按。这就非常尴尬了。");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("A onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("A onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("A onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("A onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //stopService(new Intent(this,AppService.class));

        System.out.println("A onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        System.out.println("A onRestart");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnStartService:
                startService(intent);
                break;
            case R.id.btnStopService:
                stopService(intent);
                break;
            case R.id.btnBindService:
                bindService(intent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService:
                unbindService(this);
                break;
            case R.id.btnStartService1:
                startService(i);
                i.putExtra("data",etData.getText().toString());
                break;
            case R.id.btnStopService1:
                stopService(i);
                break;
            case R.id.btnBindService1:
                bindService(i,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService1:
                unbindService(this);
                break;
            case R.id.btnSyncData:
                if (binder != null){
                    binder.setData(etData.getText().toString());
                }
                break;

            case R.id.btnSendMessage:
//                Intent i = new Intent(this, MyReceiver.class);
                Intent i = new Intent(MyReceiver.ACTION);
                i.putExtra("data","flyfanr");
//                sendBroadcast(i);
                sendOrderedBroadcast(i, null);
                break;
            case R.id.btnReg:
                if (receiver == null) {
                    receiver = new MyReceiver();
                    registerReceiver(receiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.btnUnreg:
                if (receiver != null) {
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;

            case R.id.btnWebView:
                startActivity(new Intent(MainActivity.this, LearnWebView.class));
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("Service Connected");
        binder = (MyService1.Binder) iBinder;
        binder.getService().setCallback(new MyService1.Callback() {
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle b = new Bundle();
                b.putString("data",data);
                msg.setData(b);
                handler.sendMessage(msg);
            }
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            tvOut.setText(msg.getData().getString("data"));
        }
    };

    private MyReceiver receiver = null;

}

package com.flyfanr.midapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class LearnComponents extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Spinner s;
    private String[] dataSource = new String[]{"jikexueyuan", "flyfanr", "flyfanr.com"};

    private Button btnChooseDate;

    private Button btnChooseTime;

    private Button btnSubmit;
    private RadioButton rbA;

    private CheckBox cb1,cb2,cb3,cb4;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_components);

        s = (Spinner) findViewById(R.id.spinner);
        s.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataSource));
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("用户选择的是"+dataSource[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnChooseDate = (Button) findViewById(R.id.btnChooseDate);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LearnComponents.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        String theDate = String.format("%d-%d-%d",i,i1+1,i2);

                        System.out.println(theDate);

                        btnChooseDate.setText(theDate);
                    }
                },2016,7,30).show();
            }
        });

        btnChooseTime = (Button) findViewById(R.id.btnChooseTime);
        btnChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(LearnComponents.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String theTime = String.format("%d:%d", i,i1);
                        System.out.println(theTime);

                        btnChooseTime.setText(theTime);
                    }
                }, 0,0,true).show();
            }
        });

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rbA = (RadioButton) findViewById(R.id.rbA);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbA.isChecked()) {
                    Toast.makeText(LearnComponents.this, "所选是正确的", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LearnComponents.this, "所选是错误的", Toast.LENGTH_SHORT).show();

                }
            }
        });

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);

        tvResult = (TextView) findViewById(R.id.tvResult);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String str = "你喜欢";
        if (cb1.isChecked()) {
            str+=cb1.getText()+",";
        }
        if (cb2.isChecked()) {
            str+=cb2.getText()+",";
        }
        if (cb3.isChecked()) {
            str+=cb3.getText()+",";
        }
        if (cb4.isChecked()) {
            str+=cb4.getText();
        }

        tvResult.setText(str);
    }
}

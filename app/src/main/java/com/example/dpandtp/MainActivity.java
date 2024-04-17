package com.example.dpandtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TimePicker tp;
    DatePicker dp;
    TextView tv,tv1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp=findViewById(R.id.tp);
        dp=findViewById(R.id.dp);
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hours,min;
                String am_pm;

                if(Build.VERSION.SDK_INT>=23){
                    hours= tp.getHour();
                    min=tp.getMinute();
                }
                else {
                      hours= tp.getCurrentHour();
                      min=tp.getCurrentMinute();
                }
                if(hours>12)
                {
                    am_pm="pm";
                    hours=hours-12;
                }
                else{
                    am_pm="am";
                }
                tv.setText("Time is"+hours+"Hours"+min+"Minutes");
                tv1.setText("Date is"+dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear());
            }
        });
    }
}
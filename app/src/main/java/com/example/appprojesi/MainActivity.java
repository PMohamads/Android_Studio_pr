package com.example.appprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ConvertBtn,RandomBtn,SmsBtn;
    Animation ScaleUp,ScaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConvertBtn = findViewById(R.id.cnvbtn);
        RandomBtn = findViewById(R.id.rndbtn);
        SmsBtn = findViewById(R.id.smsbtn);
        ScaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        ScaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        ConvertBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                    ConvertBtn.startAnimation(ScaleUp);
                else if (event.getAction()==MotionEvent.ACTION_UP) {
                    ConvertBtn.startAnimation(ScaleDown);
                }
                return false;
            }
        });

        RandomBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                    RandomBtn.startAnimation(ScaleUp);
                else if (event.getAction()==MotionEvent.ACTION_UP) {
                    RandomBtn.startAnimation(ScaleDown);
                }
                return false;
            }
        });

        SmsBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                    SmsBtn.startAnimation(ScaleUp);
                else if (event.getAction()==MotionEvent.ACTION_UP) {
                    SmsBtn.startAnimation(ScaleDown);
                }
                return false;
            }
        });

    }

    public void ConvertFun(View view) {
        Intent i = new Intent(MainActivity.this,ConverterActivity.class);
        startActivity(i);
    }

    public void RandomFun(View view) {
        Intent i = new Intent(MainActivity.this,RandomActvity.class);
        startActivity(i);
    }

    public void SmsFun(View view) {
        Intent i = new Intent(MainActivity.this,SmsActivity.class);
        startActivity(i);
    }
}
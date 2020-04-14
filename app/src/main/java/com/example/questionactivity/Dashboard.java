package com.example.questionactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
TextView textView;
int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        textView=(TextView)findViewById(R.id.value);
      Intent intent=getIntent();
      value=intent.getIntExtra("sum",0);
    textView.setText(String.valueOf(value));
    }
}

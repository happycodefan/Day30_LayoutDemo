package com.example.happy_fan.day30_layoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_show = (TextView)findViewById(R.id.tv_show);

        Intent intentFromMain = getIntent();
        Bundle bundle = intentFromMain.getExtras();
        tv_show.setText(bundle.getString("name"));

    }
}

package com.datoucai.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Zhu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        TextView sayHi= (TextView) findViewById(R.id.textView3);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        sayHi.setText(username);

    }
}

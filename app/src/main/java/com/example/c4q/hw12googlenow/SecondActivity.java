package com.example.c4q.hw12googlenow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView articleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        articleInfo=(TextView) findViewById(R.id.articlInfo);
        Log.d( "onCreate: ",intent.getStringExtra("hey"));
        articleInfo.setText(intent.getStringExtra("hey")+intent.getStringExtra("you")
                +intent.getStringExtra("us")+intent.getStringExtra("all")+intent.getStringExtra("nice")+
        intent.getStringExtra("we"));


    }
}

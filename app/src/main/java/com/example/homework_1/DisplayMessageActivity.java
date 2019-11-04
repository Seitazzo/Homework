package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        String message=null;
        Intent intent = getIntent();
        if(intent.getStringExtra(MainActivity.EXTRA_MESSAGE)!=null){
            message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        }
        else if(intent.getStringExtra(SignupActivity.EXTRA_MESSAGE)!=null){
            message=intent.getStringExtra(SignupActivity.EXTRA_MESSAGE);
        }

        if(message!=null){
            TextView textView = findViewById(R.id.textView3);
            textView.setText(message);
        }
        else{
            String error = "错误：未满足登陆/注册需填写信息条件";
            TextView textView = findViewById(R.id.textView3);
            textView.setText(error);
        }
    }
}

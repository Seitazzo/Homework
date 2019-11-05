package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        String message;
        Intent intent = getIntent();
        if (intent.getStringExtra("mainActivity_number") != null) {
            message = intent.getStringExtra("mainActivity_number");

            TextView textView = findViewById(R.id.textView3);
            textView.setText(message);
            goSystem(1000);
        } else if (intent.getStringExtra("signUpActivity_number") != null) {
            message = intent.getStringExtra("signUpActivity_number");

            TextView textView = findViewById(R.id.textView3);
            textView.setText(message);
            goMain(2000);
        } else if (intent.getStringExtra("transfer_message") != null) {
            message = intent.getStringExtra("transfer_message");

            TextView textView = findViewById(R.id.textView3);
            textView.setText(message);
            goSystem(3000);
        } else {
            String error = "错误：未满足需填写信息条件";
            TextView textView = findViewById(R.id.textView3);
            textView.setText(error);
        }
    }

    public void goSystem(int i) {
        Timer time = new Timer();
        TimerTask tk = new TimerTask() {
            Intent intent = new Intent(DisplayMessageActivity.this, SystemActivity.class);

            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        time.schedule(tk, i);
    }

    public void goMain(int i) {
        Timer time = new Timer();
        TimerTask tk = new TimerTask() {
            Intent intent = new Intent(DisplayMessageActivity.this, MainActivity.class);

            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        time.schedule(tk, i);
    }
}

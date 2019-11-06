package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TransferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        setTitle("转账");
    }

    public void reset(View view) {
        final EditText editText1 = findViewById(R.id.editText5);
        final EditText editText2 = findViewById(R.id.editText6);
        editText1.setText(null, TextView.BufferType.EDITABLE);
        editText2.setText(null, TextView.BufferType.EDITABLE);
    }

    public void transfer(View view) {
        final EditText editText1 = findViewById(R.id.editText5);
        final EditText editText2 = findViewById(R.id.editText6);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "你对学号" + editText1.getText().toString() + "同学的转账已成功\n转账金额为" + editText2.getText().toString() + "元";

        if (TextUtils.isEmpty(editText1.getText())) {
            Toast.makeText(this, "请输入对方学号", Toast.LENGTH_SHORT).show();
            message = null;
        }
        if (TextUtils.isEmpty(editText2.getText())) {
            Toast.makeText(this, "请输入转账金额", Toast.LENGTH_SHORT).show();
            message = null;
        }

        intent.putExtra("transfer_message", message);
        startActivity(intent);

        editText1.setText(null, TextView.BufferType.EDITABLE);
        editText2.setText(null, TextView.BufferType.EDITABLE);
    }
}

package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("登陆");
    }


    public void reset(View view) {
        final EditText editText1 = findViewById(R.id.editText);
        final EditText editText2 = findViewById(R.id.editText2);
        editText1.setText(null, TextView.BufferType.EDITABLE);
        editText2.setText(null, TextView.BufferType.EDITABLE);
    }

    public void apply(View view) {
        final EditText editText1 = findViewById(R.id.editText);
        final EditText editText2 = findViewById(R.id.editText2);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editText1.getText().toString() + "登陆成功";

        if (TextUtils.isEmpty(editText1.getText())) {
            Toast.makeText(this, "请输入学号", Toast.LENGTH_SHORT).show();
            message = null;
        }
        if (TextUtils.isEmpty(editText2.getText())) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            message = null;
        }

        intent.putExtra("mainActivity_number", message);
        startActivity(intent);

        editText1.setText(null, TextView.BufferType.EDITABLE);
        editText2.setText(null, TextView.BufferType.EDITABLE);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.signup_item:
                Intent intent1 = new Intent(this, SignupActivity.class);
                startActivity(intent1);
                break;
            case R.id.test_item:
                Toast.makeText(this, "网络测试", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://bing.com/"));
                startActivity(intent2);
            default:
        }
        return true;
    }
}
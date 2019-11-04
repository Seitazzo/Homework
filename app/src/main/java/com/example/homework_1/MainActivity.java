package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void reset(View view){
        final EditText editText1 = (EditText) findViewById(R.id.editText);
        final EditText editText2=(EditText)findViewById(R.id.editText2);
        editText1.setText("", TextView.BufferType.EDITABLE);
        editText2.setText("", TextView.BufferType.EDITABLE);
    }

    public void apply(View view) {
        final EditText editText = (EditText) findViewById(R.id.editText);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editText.getText().toString()+"登陆成功";

        final EditText editText1=(EditText)findViewById(R.id.editText2);
        if(TextUtils.isEmpty(editText.getText()))
        {
            Toast.makeText(this,"请输入学号",Toast.LENGTH_SHORT).show();
            message=null;
        }
        if(TextUtils.isEmpty(editText1.getText())){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            message=null;
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.signup_item:
                Intent intent1=new Intent(this,SignupActivity.class);
                startActivity(intent1);
                break;
            case R.id.test_item:
                Toast.makeText(this,"网络测试",Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://bing.com/"));
                startActivity(intent2);
                default:
        }
        return true;
    }
}
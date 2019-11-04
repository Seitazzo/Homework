package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void apply(View view) {
        final EditText editText1 = (EditText) findViewById(R.id.editText3);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editText1.getText().toString()+"注册成功";

        final EditText editText2=(EditText)findViewById(R.id.editText4);
        final CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox);
        final CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        final CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        final Switch switchItem=(Switch)findViewById(R.id.switch1);

        if(TextUtils.isEmpty(editText1.getText()))
        {
            Toast.makeText(this,"请输入学号",Toast.LENGTH_SHORT).show();
            message=null;
        }
        if(TextUtils.isEmpty(editText2.getText()))
        {
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            message=null;
        }
        if(!checkBox1.isChecked()&&!checkBox2.isChecked()&&!checkBox3.isChecked()){
            Toast.makeText(this,"请至少勾选一个性别",Toast.LENGTH_SHORT).show();
            message=null;
        }
        if(!switchItem.isChecked()){
            Toast.makeText(this,"请同意学生管理制度汇编所记内容",Toast.LENGTH_SHORT).show();
            message=null;
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

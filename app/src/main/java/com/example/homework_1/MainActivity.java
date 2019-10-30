package com.example.homework_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cancelButton= (Button)findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText1=(EditText)findViewById(R.id.editText2);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText.setText("", TextView.BufferType.EDITABLE);
                editText1.setText("", TextView.BufferType.EDITABLE);
            }
        });
    }

        public void apply(View view) {
            final EditText editText = (EditText) findViewById(R.id.editText);
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
    }
}
package com.datoucai.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        EditText editText= (EditText) findViewById(R.id.username);
        EditText editText1= (EditText) findViewById(R.id.password_text);
        String username=editText.getText().toString();
        String password=editText1.getText().toString();
        if ("admin".equals(username)&&"123456".equals(password)){
            Intent intent=new Intent(this,Zhu.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }else {
            Toast.makeText(this,"username or password is wrong",Toast.LENGTH_SHORT).show();
            editText1.setText("");
            editText.setText("");
        }
    }

    public void register(View view){
        Toast.makeText(this,"hahahhaha",Toast.LENGTH_SHORT).show();
    }
}

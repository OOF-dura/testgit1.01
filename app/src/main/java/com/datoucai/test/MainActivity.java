package com.datoucai.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.datoucai.test.POJO.users;
import java.util.List;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "ce3e3b07c65f64e5ae70284925a95bc9");
    }

    public void login(View view){
        editText= (EditText) findViewById(R.id.username);
        editText1= (EditText) findViewById(R.id.password_text);
        String username=editText.getText().toString();
        String password=editText1.getText().toString();
        signIn(username,password);

    }

    public void register(View view){
        Toast.makeText(this,"请您注册",Toast.LENGTH_SHORT).show();
    }


    public void signIn(final String username,final String password){
        BmobQuery<users> query = new BmobQuery<users>();
        query.addWhereEqualTo("id", Integer.parseInt(username));
        query.setLimit(1);
        query.findObjects(new FindListener<users>() {
            public void done(List<users> object, BmobException e) {
                if(e==null){
                    Log.d("bmob","找到账号ssss"+object.size());

                    for (users user : object) {
                        if (username.equals(user.getId()+"")) {
                            //已经找到账号
                        Log.d("bmob","找到账号"+user.getId());
                        if (user.getPassword().equals(password)) {
                            Intent intent=new Intent(MainActivity.this,Zhu.class);
                            intent.putExtra("username",username);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this,"您的密码错误",Toast.LENGTH_SHORT).show();
                            editText1.setText("");
                        }
                        }else {
                            Toast.makeText(MainActivity.this,"您的账号不正确",Toast.LENGTH_SHORT).show();
                            editText.setText("");
                            editText1.setText("");
                        }
                        //获得数据的objectId信息
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                    }
                }else{
                     Toast.makeText(MainActivity.this,"您还没有注册",Toast.LENGTH_SHORT).show();
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }


//该部分用于测试数据
//    public void createData() {
//        users p2 = new users();
//        p2.increment("id");   //自增没有设置好 还在研究
//        p2.setId(100100100);
//        p2.setPassword("12345678");
//        p2.setUsername("201600301233");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//                if (e == null) {
//                    Toast.makeText(MainActivity.this, "添加数据成功，返回objectId为：" + objectId, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });}

}

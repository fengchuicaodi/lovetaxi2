package com.by.taxi.lovetaxi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.by.taxi.lovetaxi2.javabean.MyUser;
import com.by.taxi.lovetaxi2.javabean.taxi;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegisterCarActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText carcolor;
    private EditText carnumber;
    private EditText cartype;
    private Button carregister;
    private Button carcancel;
    private static String taxiObectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);
        //这里的AppLication ID 写上自己创建项目得到的那个AppLication ID
        Bmob.initialize(this, "64a9582a1950cfc5eac1b65afb3b11e2");
        initialize();
    }

    private void initialize() {

        carcolor = (EditText) findViewById(R.id.carcolor);
        carnumber = (EditText) findViewById(R.id.license_number);
        cartype = (EditText) findViewById(R.id.cartype);
        carregister = (Button) findViewById(R.id.carregister);
        carregister.setOnClickListener(this);
        carcancel = (Button) findViewById(R.id.carcancel);
        carcancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.carregister:
                registerData();
                break;
            case R.id.cancel:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 注册
     */
    private void registerData() {
        String color = carcolor.getText().toString();
        String number = carnumber.getText().toString();
        String type =cartype.getText().toString();
        MyUser user = BmobUser.getCurrentUser(MyUser.class);
        final taxi taxi= new taxi();
        taxi.setDrivername(user);
        taxi.save(new SaveListener<String>() {

            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Toast.makeText(RegisterCarActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    taxiObectId=taxi.getObjectId();
                }else{
                    Toast.makeText(RegisterCarActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                    Log.e("registerActivity", e.toString());
                }
            }
        });
        taxi.setTaxi_type(type);
        taxi.setLicense_number(number);
        taxi.setTaxi_color(color);
        taxi.update(taxiObectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.e("registercar","更新成功");
                }else{
                    Log.e("registercar","更新失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });

    }
}

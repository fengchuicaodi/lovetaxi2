package com.by.taxi.lovetaxi2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.bean.DateType;

import cn.bmob.v3.Bmob;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText starttime;
    private Button canalButton;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bmob.initialize(this, "64a9582a1950cfc5eac1b65afb3b11e2");
        initialize();
    }
    private void initialize(){
        starttime=(EditText)findViewById(R.id.starttime);
        starttime.setOnClickListener(this);
        canalButton=(Button)findViewById(R.id.cancelButton);
        canalButton.setOnClickListener(this);
        submitButton=(Button)findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }
    private void showDataPickDialog(DateType type){
        DatePickDialog dialog = new DatePickDialog(this);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择时间");
        //设置类型
        dialog.setType(DateType.TYPE_ALL);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(null);
        dialog.show();
    }
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.starttime:
                showDataPickDialog(DateType.TYPE_HM);
                break;

        }
    }
}

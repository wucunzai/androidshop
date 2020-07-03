package com.atguigu.shoppingmall.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.bean.User;

public class RegisterActivity extends Activity implements View.OnClickListener {

    private ImageButton ibregisterBack;
    private EditText etregisterPhone;
    private EditText etregisterPwd;
    private EditText etregistertPwd;
    private ImageButton ibregisterVisible;
    private Button btnregister;
    private TextView register_login;
    private Context context;


    private int count;

    private void findViews() {
        ibregisterBack = (ImageButton) findViewById(R.id.ib_register_back);
        etregisterPwd = (EditText) findViewById(R.id.et_register_pwd);
        ibregisterVisible = (ImageButton) findViewById(R.id.ib_register_visible);
        btnregister = (Button) findViewById(R.id.btn_register);
        register_login = (TextView)findViewById(R.id.tv_register_login);
        etregisterPhone = (EditText)findViewById(R.id.et_register_phone);
        etregistertPwd = (EditText)findViewById(R.id.et_register_tpwd);
        ibregisterBack.setOnClickListener(this);
        ibregisterVisible.setOnClickListener(this);
        btnregister.setOnClickListener(this);
        register_login.setOnClickListener(this);
        etregisterPhone.setOnClickListener(this);
        etregisterPwd.setOnClickListener(this);
        etregistertPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ibregisterBack) {
            finish();
        } else if (v == ibregisterVisible) {

            count++;
            if (count % 2 == 0) {
                ibregisterVisible.setBackgroundResource(R.drawable.new_password_drawable_invisible);
                etregisterPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                ibregisterVisible.setBackgroundResource(R.drawable.new_password_drawable_visible);
                etregisterPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        }
        else if(v == btnregister){
            String uname = etregisterPhone.getText().toString();
            String upwd = etregisterPwd.getText().toString();
            String tupwd = etregistertPwd.getText().toString();
            if(upwd.equals(tupwd)){
                User user = new User();
                if(user.registerUser(uname,upwd)){
                    context = getApplicationContext();
                    Toast.makeText(context,"注册成功,前往登录页面",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //启动
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        }
                    },1000);
                }
                else {
                    context = getApplicationContext();
                    Toast.makeText(context,"注册失败",Toast.LENGTH_SHORT).show();

                }
            }
            else{
                context = getApplicationContext();
                Toast.makeText(context,"两次密码不一致",Toast.LENGTH_SHORT).show();

            }

        }
        else if(v == register_login){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //启动
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
            },200);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
    }

}

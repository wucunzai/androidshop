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

// 登录页面
public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageButton ibLoginBack;
    private EditText etLoginPhone;
    private EditText etLoginPwd;
    private ImageButton ibLoginVisible;
    private Button btnLogin;
    private ImageButton ib_weibo;
    private ImageButton ib_qq;
    private ImageButton ib_wechat;
    private TextView login_register;
    private Context context;


    private int count;

    // 初始化view
    private void findViews() {
        ibLoginBack = (ImageButton) findViewById(R.id.ib_login_back);
        etLoginPwd = (EditText) findViewById(R.id.et_login_pwd);
        ibLoginVisible = (ImageButton) findViewById(R.id.ib_login_visible);
        btnLogin = (Button) findViewById(R.id.btn_login);
        ib_weibo = (ImageButton) findViewById(R.id.ib_weibo);
        ib_qq = (ImageButton) findViewById(R.id.ib_qq);
        ib_wechat = (ImageButton) findViewById(R.id.ib_wechat);
        login_register = (TextView)findViewById(R.id.tv_login_register);
        etLoginPhone = (EditText)findViewById(R.id.et_login_phone);
        ibLoginBack.setOnClickListener(this);
        ibLoginVisible.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        ib_weibo.setOnClickListener(this);
        ib_qq.setOnClickListener(this);
        ib_wechat.setOnClickListener(this);
        login_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == ibLoginBack) {

        } else if (v == ibLoginVisible) {

            count++;
            if (count % 2 == 0) {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_invisible);
                etLoginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_visible);
                etLoginPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
        }
        else if(v == btnLogin){
            String uname = etLoginPhone.getText().toString();
            String upwd = etLoginPwd.getText().toString();
            User user = new User();
            if(user.isUser(uname,upwd)){
                context = getApplicationContext();
                Toast.makeText(context,"登录成功",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //启动
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                },1000);
            }
            else {
                context = getApplicationContext();
                Toast.makeText(context,"用户名或密码错误",Toast.LENGTH_SHORT).show();

            }
        }
        else if(v == login_register){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //启动
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    finish();
                }
            },200);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

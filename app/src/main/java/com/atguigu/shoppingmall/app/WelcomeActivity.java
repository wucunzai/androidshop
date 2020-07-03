package com.atguigu.shoppingmall.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.atguigu.shoppingmall.R;


public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //2s进入
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //启动
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                finish();
            }
        },2000);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }
}

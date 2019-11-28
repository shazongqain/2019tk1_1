package com.example.tiku1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tiku1.activity.S_DLActivity;

public class MainActivity extends AppCompatActivity {

    private AppClient mApp;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            startActivity(new Intent(MainActivity.this, S_DLActivity.class));
            finish();
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (AppClient) getApplication();
        if (mApp.login())
        {
            handler.sendEmptyMessage(0);
        }else {
            handler.sendEmptyMessageDelayed(0,3000);
            mApp.setlogin(true);
            setContentView(R.layout.activity_main);
        }

    }
}

package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.tiku1.R;
import com.example.tiku1.net.VolleyLo;
import com.example.tiku1.net.VolleyTo;

import org.json.JSONArray;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DLActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.yhm)
    EditText yhm;
    @BindView(R.id.mm)
    EditText mm;
    @BindView(R.id.dl)
    Button dl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dlactivity);
        ButterKnife.bind(this);
        inview();
        setdianji();

    }

    private void huoqu(final String y, final String m) {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_roots").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    String arr = jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray = new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        if (jsonObject1.getString("username").equals(y)&&jsonObject1.getString("password").equals(m))
                        {
                            Toast.makeText(S_DLActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(S_DLActivity.this,S_SJFXActivity.class));
                            finish();
                            return;

                        }
                    }
                    Toast.makeText(S_DLActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }).start();
    }

    private void setdianji() {
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String y = yhm.getText().toString();
                String m = mm.getText().toString();
                huoqu(y,m);
            }
        });
    }

    private void inview() {
        title.setText("用户登录");
    }
}

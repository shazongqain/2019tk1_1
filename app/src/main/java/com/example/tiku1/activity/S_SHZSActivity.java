package com.example.tiku1.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1.R;
import com.example.tiku1.adapter.shzsadapter;
import com.example.tiku1.bean.Shzs;
import com.example.tiku1.net.VolleyLo;
import com.example.tiku1.net.VolleyTo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_SHZSActivity extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.change1)
    ImageView change1;
    @BindView(R.id.tubiao)
    ImageView tubiao;
    @BindView(R.id.wendu)
    TextView wendu;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.pm)
    TextView pm;
    @BindView(R.id.wd)
    TextView wd;
    @BindView(R.id.sd)
    TextView sd;
    @BindView(R.id.t1)
    TextView t1;
    @BindView(R.id.m1)
    TextView m1;
    @BindView(R.id.t2)
    TextView t2;
    @BindView(R.id.m2)
    TextView m2;
    private List<Shzs> mshzs;
    private shzsadapter mshzsadapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_shzsactivity);
        ButterKnife.bind(this);
        inview();
        huoqu();
        huoqu1();
        setdianji();

    }

    private void setdianji() {
        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huoqu();
            }
        });
    }

    private void huoqu1() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_all_sense").setTime(3000).setLoop(true).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    int p = jsonObject.getInt("pm25");
                    int w = jsonObject.getInt("temperature");
                    int s = jsonObject.getInt("humidity");
                    int g = jsonObject.getInt("illumination");
                    pm.setText("PM2.5："+p);
                    wd.setText("温    度："+w);
                    sd.setText("湿    度："+s);
                    if (p>=0&&p<100)
                    {
                        t2.setText("良好");
                        m2.setText("气象条件会对晨练影响不大");
                        t2.setTextColor(Color.BLACK);
                    }else  if (p>=100&&p<200)
                    {
                        t2.setText("轻度");
                        m2.setText("受天气影响，较不宜晨练");
                        t2.setTextColor(Color.RED);
                    }else  if (p>=200&&p<300)
                    {
                        t2.setText("重度");
                        m2.setText("减少外出，出行注意戴口罩");
                        t2.setTextColor(Color.RED);
                    }else  if (p>300)
                    {
                        t2.setText("爆表");
                        m2.setText("停止一切外出活动");
                        t2.setTextColor(Color.RED);
                    }

                    if (p>=0&&p<1500)
                    {
                        t1.setText("非常弱");
                        m1.setText("您无需担心紫外线");
                        t1.setTextColor(Color.BLACK);
                    }else  if (p>=1500&&p<4500)
                    {
                        t1.setText("弱");
                        m1.setText("外出适当涂抹低倍数防晒霜");
                        t1.setTextColor(Color.BLACK);
                    }else  if (p>=45200&&p<300)
                    {
                        t1.setText("强");
                        m1.setText("外出需要涂抹中倍数防晒霜");
                        t1.setTextColor(Color.RED);
                    }

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

    private void setadapter() {
        mshzsadapter = new shzsadapter(this,mshzs);
        gridview.setAdapter(mshzsadapter);
    }

    private void huoqu() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_weather_info").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    Gson gson = new Gson();
                    wendu.setText(jsonObject.getString("temperature")+"度");
                    String z = jsonObject.getString("weather");
                    if (z.equals("小雨"))
                    {
                        tubiao.setImageResource(R.drawable.xiaoyu);
                    }else   if (z.equals("晴"))
                    {
                        tubiao.setImageResource(R.drawable.qing);
                    }else   if (z.equals("阴"))
                    {
                        tubiao.setImageResource(R.drawable.yin);
                    }
                    String arr = jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray  =new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        Shzs s = gson.fromJson(jsonArray.getString(i),Shzs.class);
                        mshzs.add(s);
                    }
                    setadapter();
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

    private void inview() {
        mshzs = new ArrayList<>();
        title.setText("生活助手");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

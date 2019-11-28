package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1.AppClient;
import com.example.tiku1.R;
import com.example.tiku1.TimeDada;
import com.example.tiku1.adapter.hjzbadapter;
import com.example.tiku1.bean.Hjzb;
import com.example.tiku1.bean.Yz;
import com.example.tiku1.net.VolleyLo;
import com.example.tiku1.net.VolleyTo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_HJZBActivity extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.gridview)
    GridView gridview;
    private List<Yz> myz;
    private Yz yz;
    private Hjzb hjzb;
    private AppClient mApp;
    private boolean is =true;
    private List<Hjzb> mhjzb;
    private hjzbadapter mhjzbadapter;
    private VolleyTo volleyTo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_hjzbactivity);
        ButterKnife.bind(this);
        inview();
        huoqu();
        setdianji();


    }

    private void setdianji() {
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(S_HJZBActivity.this,S_SSXSActiivty.class);
                intent.putExtra("index",i);
                startActivity(intent);
            }
        });
    }

    private void huoqu2(final int dl) {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_all_sense").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                try {
                    Gson gson = new Gson();
                    hjzb = gson.fromJson(jsonObject.toString(),Hjzb.class);
                    hjzb.setDl(dl);
                    hjzb.setTime(TimeDada.setTime("mm:ss",new Date()));
                    mhjzb.add(hjzb);

                    if (mhjzb.size()>20)
                    {
                        mhjzb.remove(0);
                    }
                    if (is)
                    {
                        mhjzbadapter = new hjzbadapter(S_HJZBActivity.this,mhjzb,myz);
                        gridview.setAdapter(mhjzbadapter);
                        is=false;
                    }else {
                        mhjzbadapter.notifyDataSetChanged();
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

    private void huoqu1() {
         volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_road_status").setJsonObject("RoadId","1").setTime(3000).setLoop(true).setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray jsonArray  =new JSONArray(jsonObject.getString("ROWS_DETAIL"));
                    huoqu2(jsonArray.getJSONObject(0).getInt("state"));
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

    private void huoqu() {
        VolleyTo volleyTo  =new VolleyTo();
        volleyTo.setUrl("get_threshold").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {

                    Gson gson  =new Gson();
                    String arr= jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray = new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        yz = gson.fromJson(jsonArray.getString(i),Yz.class);
                        myz.add(yz);
                    }
                    huoqu1();
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
        mApp = (AppClient)getApplication(); 
        mhjzb = mApp.getMhjzb();
        myz = new ArrayList<>();
        title.setText("环境指标");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        volleyTo.setLoop(false);
        volleyTo=null;
    }
}

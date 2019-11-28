package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1.R;
import com.example.tiku1.adapter.dzbcadapter;
import com.example.tiku1.bean.Dzbc;
import com.example.tiku1.net.VolleyLo;
import com.example.tiku1.net.VolleyTo;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DZBCActivity extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.listview)
    ListView listview;
    private List<Dzbc> mdzbc;
    private String pj,lc,kaishi,jieshu,zhongjian,zhongjian1;
    private dzbcadapter mdzbcadapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dzbcactivity1);
        ButterKnife.bind(this);
        inview();
        huqou();
        setdianji();

    }

    private void setdianji() {
        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(S_DZBCActivity.this,S_WDDDActivity.class));
            }
        });
    }


    private void setadapter() {
        mdzbcadapter = new dzbcadapter(this,mdzbc);
        listview.setAdapter(mdzbcadapter);
        mdzbcadapter.SetData(new dzbcadapter.SetData() {
            @Override
            public void setdata(int position, String kaishi, String jieshu, String zhongjian, String zhongjian2, String piaojia, String licehng) {
                Intent intent  =new Intent(S_DZBCActivity.this,S_DZBCActivity2.class);
                System.out.println("---"+zhongjian);
                intent.putExtra("kaishi",kaishi);
                intent.putExtra("jieshu",jieshu);
                intent.putExtra("zhongjian",zhongjian);
                intent.putExtra("zhongjian2",zhongjian2);
                intent.putExtra("piaojia",piaojia);
                intent.putExtra("licehng",licehng);
                startActivity(intent);
            }
        });
    }

    private void huqou() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_bus_info").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    String arr  =jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray  =new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1  =jsonArray.getJSONObject(i);
                        pj = jsonObject1.getString("fares");
                        String luh  =jsonObject1.getString("id");
                        lc = jsonObject1.getString("mileage");
                        String arr1 = jsonObject1.getString("busline");
                        JSONArray jsonArray1 = new JSONArray(arr1);
                        kaishi = jsonArray1.getString(0);
                        zhongjian = jsonArray1.getString(1);
                        zhongjian1 = jsonArray1.getString(2);
                        jieshu = jsonArray1.getString(3);
                        String[] sj  =jsonObject1.getString("time").split("~");
                        mdzbc.add(new Dzbc(luh+"路",kaishi,jieshu,lc,pj,sj[0]+"",sj[1]+"",zhongjian,zhongjian1));

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
        title.setText("定制班车");
        title1.setText("我的订单");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mdzbc = new ArrayList<>();
    }
}

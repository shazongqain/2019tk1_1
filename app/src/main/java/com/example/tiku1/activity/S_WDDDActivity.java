package com.example.tiku1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.tiku1.AppClient;
import com.example.tiku1.R;
import com.example.tiku1.adapter.wdddadapter;
import com.example.tiku1.bean.Tjdd;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_WDDDActivity extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.listview)
    ListView listview;
    private AppClient mApp;
    private List<Tjdd> mtjdd;
    private wdddadapter mwddadapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_wdddactivity);
        ButterKnife.bind(this);
        inview();
        adddata();

    }

    private void inview() {
        title.setText("我的订单");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mApp = (AppClient) getApplication();
        mtjdd = mApp.getMtjdd();
    }

    private void setadapter() {
        mwddadapter = new wdddadapter(this,mtjdd);
        listview.setAdapter(mwddadapter);
    }

    private void adddata() {
        setadapter();

    }
}

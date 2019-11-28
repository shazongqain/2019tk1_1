package com.example.tiku1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tiku1.AppClient;
import com.example.tiku1.R;
import com.example.tiku1.SactivityCollector;
import com.example.tiku1.bean.Tjdd;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DZBCActivity5 extends AppCompatActivity {

    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.kaishi5)
    TextView kaishi5;
    @BindView(R.id.jeishu5)
    TextView jeishu5;
    @BindView(R.id.name5)
    TextView name5;
    @BindView(R.id.tel5)
    TextView tel5;
    @BindView(R.id.didian)
    TextView didian;
    @BindView(R.id.riqi)
    TextView riqi;
    @BindView(R.id.xyb4)
    Button xyb4;
    private AppClient mApp;
    private List<Tjdd> mtjdd;
    private String kaishi, jieshu, zhongjian2, zhongjian1, piaojia, licehng, time, tel, name, dd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dzbcactivity5);
        SactivityCollector.addActivity(this);
        ButterKnife.bind(this);
        inview();
        jiesho();
        setdianji();
    }

    private void setdianji() {
        xyb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SactivityCollector.finishAll();
                mtjdd.add(new Tjdd(name,time,kaishi+"-"+zhongjian1+"-"+zhongjian2+"-"+jieshu,kaishi,jieshu));

            }
        });
    }

    private void jiesho() {
        kaishi = getIntent().getStringExtra("kaishi");
        jieshu = getIntent().getStringExtra("jieshu");
        zhongjian1 = getIntent().getStringExtra("zhongjian");
        zhongjian2 = getIntent().getStringExtra("zhongjian2");
        piaojia = getIntent().getStringExtra("piaojia");
        licehng = getIntent().getStringExtra("licehng");
        time = getIntent().getStringExtra("time");
        tel = getIntent().getStringExtra("tel");
        name = getIntent().getStringExtra("name");
        dd = getIntent().getStringExtra("didian");
        name5.setText("乘客姓名："+name);
        tel5.setText("手机号码："+tel);
        riqi.setText("乘车日期："+time);
        didian.setText("上车地点："+dd);
        kaishi5.setText(kaishi);
        jeishu5.setText(jieshu);


    }

    private void inview() {
        title.setText("确定订单");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mApp=(AppClient) getApplication();
        mtjdd = mApp.getMtjdd();
    }
}

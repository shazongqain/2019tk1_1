package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.SactivityCollector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DZBCActivity2 extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.kaishi2)
    TextView kaishi2;
    @BindView(R.id.jieshu2)
    TextView jieshu2;
    @BindView(R.id.piajia2)
    TextView piajia2;
    @BindView(R.id.licheng2)
    TextView licheng2;
    @BindView(R.id.xyb2)
    Button xyb2;
    @BindView(R.id.ditu)
    ImageView ditu;
    private String kaishi, jieshu, zhongjian2, zhongjian1, piaojia, licehng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dzbcactivity2);
        SactivityCollector.addActivity(this);
        ButterKnife.bind(this);
        inview();
        jiesho();
        setdianji();
    }

    private void setdianji() {
        xyb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  =new Intent(S_DZBCActivity2.this,S_DZBCActivity3.class);
                intent.putExtra("kaishi",kaishi);
                intent.putExtra("jieshu",jieshu);
                intent.putExtra("zhongjian",zhongjian1);
                intent.putExtra("zhongjian2",zhongjian2);
                intent.putExtra("piaojia",piaojia);
                intent.putExtra("licehng",licehng);
                startActivity(intent);
            }
        });
    }

    private void inview() {
        title.setText("定制班车");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        jieshu2.setText(jieshu);
        kaishi2.setText(kaishi);
        piajia2.setText("票价：￥" + piaojia + ".0");
        licheng2.setText("里程：" + licehng + ".0km");
        if (kaishi.equals("德州职业")) {

            ditu.setImageResource(R.drawable.ditu2);
        } else {
            ditu.setImageResource(R.drawable.ditu);
        }
    }
}

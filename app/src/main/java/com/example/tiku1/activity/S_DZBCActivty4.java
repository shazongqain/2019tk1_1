package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.SactivityCollector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DZBCActivty4 extends AppCompatActivity {

    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.kaishi4)
    TextView kaishi4;
    @BindView(R.id.jeishu4)
    TextView jeishu4;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.xyb4)
    Button xyb4;
    private String kaishi, jieshu, zhongjian2, zhongjian1, piaojia, licehng, time;
    private String[] dd;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dzbcactivity4);
        SactivityCollector.addActivity(this);
        ButterKnife.bind(this);
        inview();
        jiesho();
        setadapatpter();
        setdianji();
    }

    private void setadapatpter() {
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dd);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setdianji() {
        xyb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s  =tel.getText().toString();
                String n  =name.getText().toString();
                Intent intent  =new Intent(S_DZBCActivty4.this,S_DZBCActivity5.class);
                intent.putExtra("kaishi",kaishi);
                intent.putExtra("jieshu",jieshu);
                intent.putExtra("zhongjian",zhongjian1);
                intent.putExtra("zhongjian2",zhongjian2);
                intent.putExtra("piaojia",piaojia);
                intent.putExtra("licehng",licehng);
                intent.putExtra("time",time);
                intent.putExtra("tel",s);
                intent.putExtra("name",n);
                intent.putExtra("didian",spinner.getSelectedItem().toString());
                startActivity(intent);
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
        kaishi4.setText(kaishi);
        jeishu4.setText(jieshu);
        dd[0]=kaishi;
        dd[1]=zhongjian1;
        dd[2]=zhongjian2;
        dd[3]=jieshu;

    }

    private void inview() {
        title.setText("定制班车");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dd = new String[4];
    }
}

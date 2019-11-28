package com.example.tiku1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.SactivityCollector;
import com.example.tiku1.adapter.s_dzbcadpter3;
import com.example.tiku1.bean.Addtime;
import com.example.tiku1.bean.Yanse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_DZBCActivity3 extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.gridview3)
    GridView gridview3;
    @BindView(R.id.kaishi2)
    TextView kaishi2;
    @BindView(R.id.shijian3)
    TextView shijian3;
    @BindView(R.id.xyb3)
    Button xyb3;
    private List<Addtime> maddtime;
    private List<Yanse> myanse;
    private String[] yangli={"","","","","","15","16","18","19","20","21","22","23","24","25"
            ,"26","27","28","29","30","1","2","3"
            ,"4","5","6","7","8","9","10","11"
            ,"12","13","14","15","16","17","18","19"
            ,"20","21","22","23","24","25","26","27"};
    private String[] yinli={"","","","","","十九","二十","廿一","廿二","廿三","廿四","廿五","小雪","廿七"
            ,"廿八","廿九","冬月","初二","感恩节","初四","初五","初六","初七","初八","初九","初十","十一"
            ,"大雪","十三","十四","十五","十六","十七","公祭日","十九","二十","廿一","廿二","廿三","廿四"
            ,"廿五","廿六","冬至","廿八","平安夜","圣诞节","腊月"};

    private String time="";
    private String kaishi, jieshu, zhongjian2, zhongjian1, piaojia, licehng;
    private s_dzbcadpter3 mdzbcadapter3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_dzbcactivity3);
        SactivityCollector.addActivity(this);
        ButterKnife.bind(this);
        inview();
        for (int i=0;i<yangli.length;i++)
        {
            myanse.add(new Yanse(1));
        }
        jiesho();
        setadapter();

        setdianji();

    }
    private void setdianji() {
        xyb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent  =new Intent(S_DZBCActivity3.this,S_DZBCActivty4.class);
                intent.putExtra("kaishi",kaishi);
                intent.putExtra("jieshu",jieshu);
                intent.putExtra("zhongjian",zhongjian1);
                intent.putExtra("zhongjian2",zhongjian2);
                intent.putExtra("piaojia",piaojia);
                intent.putExtra("licehng",licehng);
                intent.putExtra("time",shijian3.getText());
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
    }

    private void setadapter() {
        mdzbcadapter3 = new s_dzbcadpter3(this,myanse,yangli,yinli);
        gridview3.setAdapter(mdzbcadapter3);
        mdzbcadapter3.SetData(new s_dzbcadpter3.SetData() {
            @Override
            public void setdata(int position, String yangli) {
                time="";
                Yanse y = myanse.get(position);
                if (y.getYanse()==1)
                {
                    y.setYanse(2);
                    myanse.set(position,y);
                    if (position>=5&&position<=19)
                    {
                        maddtime.add(new Addtime("2019-11-"+yangli));
                    }else {
                        maddtime.add(new Addtime("2019-12-"+yangli));
                    }
                }else {
                    y.setYanse(1);
                    myanse.set(position,y);
                    if (position>=5&&position<=19)
                    {
                        String t  ="2019-11-"+yangli;
                        for (int i=maddtime.size();i>0;i--)
                        {
                            Addtime tt = maddtime.get(i-1);
                            if (tt.getTime().equals(t))
                            {
                                maddtime.remove(i-1);
                            }
                        }
                    }else {
                        String t  ="2019-12-"+yangli;
                        for (int i=maddtime.size();i>0;i--)
                        {
                            Addtime tt = maddtime.get(i-1);
                            if (tt.getTime().equals(t))
                            {
                                maddtime.remove(i-1);
                            }
                        }
                    }

                }
                Collections.sort(maddtime, new Comparator<Addtime>() {
                    @Override
                    public int compare(Addtime o1, Addtime o2) {

                        try {
                            String time1  =o1.getTime();
                            String time2  =o2.getTime();
                            SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
                            Date d1  =format.parse(time1);
                            Date d2 = format.parse(time2);
                            if (d1.getTime()>d2.getTime())
                            {
                                return 1;
                            }else  if (d1.getTime()==d2.getTime())
                            {
                                return 0;
                            }else {
                                return -1;
                            }
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        return 0;
                    }
                });
                for (int x=0;x<maddtime.size();x++)
                {
                    if (x==0)
                    {
                        time+=maddtime.get(x).getTime();
                    }else {
                        time+=","+maddtime.get(x).getTime();
                    }
                }
                shijian3.setText(time);

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
        myanse = new ArrayList<>();
        maddtime = new ArrayList<>();
    }
}

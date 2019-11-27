package com.example.tiku1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.tiku1.R;
import com.example.tiku1.adapter.FragmentAdapter;
import com.example.tiku1.bean.Sjfx;
import com.example.tiku1.bean.Yeswz;
import com.example.tiku1.fragment.S_Fragment_wzcf;
import com.example.tiku1.fragment.S_Fragment_wzcs;
import com.example.tiku1.net.VolleyLo;
import com.example.tiku1.net.VolleyTo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_SJFXActivity extends AppCompatActivity {
    @BindView(R.id.change)
    ImageView change;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.lin)
    LinearLayout lin;
    private List<Fragment> fragments;
    private List<Sjfx> msjfx;
    private List<Yeswz> myeswz;
    private Map<String ,Float> cf;
    private int a,b,c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_sjfxactivity);
        ButterKnife.bind(this);
        inview();
        huopqu();

    }

    private void select1(int y) {
        for (int i=0;i<lin.getChildCount();i++)
        {
            ImageView imageView = (ImageView) lin.getChildAt(i);
            if (i==y)
            {
                imageView.setImageResource(R.drawable.shi);
            }else {
                imageView.setImageResource(R.drawable.kong);
            }
        }
    }

    private void wzcs() {
        for (Float count:cf.values())
        {
            if (count<=2) a++;
            else  if (count<=5) b++;
            else  if (count>5) c++;
        }
    }

    private void settu() {
        lin.removeAllViews();
        for (int i=0;i<fragments.size();i++)
        {
            ImageView imageView = new ImageView(S_SJFXActivity.this);
            if (i==0)
            {
                imageView.setImageResource(R.drawable.shi);
            }else {
                imageView.setImageResource(R.drawable.kong);
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(50,50));
            lin.addView(imageView);
        }
    }

    private void wzcf1() {
        for (int i=0;i<myeswz.size();i++)
        {
            String id  =myeswz.get(i).getChepia();
            Float count = cf.get(id);
            cf.put(id,(count==null)?1:count+1);
        }
    }

    private void wzcf() {
        for (int i=0;i<msjfx.size();i++)
        {
            Sjfx sjfx = msjfx.get(i);
            if (!(sjfx.getPaddr().equals("")))
            {
                myeswz.add(new Yeswz(sjfx.getCarnumber(),sjfx.getPaddr()));
            }
        }

    }

    private void asddfragment() {
        fragments.add(new S_Fragment_wzcf(myeswz,cf));
        fragments.add(new S_Fragment_wzcs(a,b,c));
        viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(fragments.size());
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                select1(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        settu();
    }

    private void huopqu() {
        VolleyTo volleyTo = new VolleyTo();
        volleyTo.setUrl("get_peccancy").setVolleyLo(new VolleyLo() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    Gson gson = new Gson();
                    String arr = jsonObject.getString("ROWS_DETAIL");
                    JSONArray jsonArray  =new JSONArray(arr);
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        Sjfx s = gson.fromJson(jsonArray.getString(i),Sjfx.class);
                        msjfx.add(s);
                    }
                    wzcf();
                    wzcf1();
                    wzcs();
                    asddfragment();

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
        title.setText("数据分析");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        fragments = new ArrayList<>();
        msjfx = new ArrayList<>();
        myeswz = new ArrayList<>();
        cf = new HashMap<>();
    }
}

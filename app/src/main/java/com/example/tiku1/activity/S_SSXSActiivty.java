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

import com.example.tiku1.R;
import com.example.tiku1.adapter.FragmentAdapter;
import com.example.tiku1.fragment.S_Fragment_co;
import com.example.tiku1.fragment.S_Fragment_dl;
import com.example.tiku1.fragment.S_Fragment_guangzhao;
import com.example.tiku1.fragment.S_Fragment_pm;
import com.example.tiku1.fragment.S_Fragment_shidu;
import com.example.tiku1.fragment.S_Fragment_wendu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class S_SSXSActiivty extends AppCompatActivity {
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
    private int index;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_ssxsactivity);
        ButterKnife.bind(this);

        index = getIntent().getIntExtra("index",0);
        inview();
        addfragment();
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
    private void settu() {
        viewpager.setCurrentItem(index);
        lin.removeAllViews();
        for (int i=0;i<fragments.size();i++)
        {
            ImageView imageView = new ImageView(S_SSXSActiivty.this);
            if (i==index)
            {
                imageView.setImageResource(R.drawable.shi);
            }else {
                imageView.setImageResource(R.drawable.kong);
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(50,50));
            lin.addView(imageView);
        }
    }

    private void addfragment() {
        fragments.add(new S_Fragment_wendu());
        fragments.add(new S_Fragment_shidu());
        fragments.add(new S_Fragment_guangzhao());
        fragments.add(new S_Fragment_co());
        fragments.add(new S_Fragment_pm());


        fragments.add(new S_Fragment_dl());
        viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
        viewpager.setCurrentItem(index);
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

    private void inview() {
        fragments = new ArrayList<>();
        title.setText("实时显示");
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

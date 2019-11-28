package com.example.tiku1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tiku1.R;
import com.example.tiku1.bean.Shzs;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class shzsadapter extends BaseAdapter {
    private List<Shzs> mshzs;
    private Context context;
    private String[] rq = {"27日（今天）", "28日（明天）", "29日（后天）", "30日（周六）", "1日（周日）"};

    public shzsadapter(Context context, List<Shzs> mshzs) {
        this.context = context;
        this.mshzs = mshzs;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Shzs shzs = mshzs.get(i);
        View view1 = View.inflate(context, R.layout.shzs_item, null);
        ViewHolder viewHolder = new ViewHolder(view1);
        viewHolder.riqi.setText(rq[i]);
        viewHolder.zhuangtai.setText(shzs.getWeather());
        if (shzs.getWeather().equals("小雨")) {

            viewHolder.beijing.setBackgroundColor(Color.parseColor("#429DE8"));
            viewHolder.tu.setImageResource(R.drawable.xiaoyu);
        }
        if (shzs.getWeather().equals("阴")) {
            viewHolder.beijing.setBackgroundColor(Color.parseColor("#91B0CE"));
            viewHolder.tu.setImageResource(R.drawable.yin);
        }
        if (shzs.getWeather().equals("晴")) {
            viewHolder.beijing.setBackgroundColor(Color.parseColor("#5EB8FA"));
            viewHolder.tu.setImageResource(R.drawable.qing);
        }
        String[] a = shzs.getInterval().split("~");
        viewHolder.wc.setText(a[0] + "/" + a[1] + "℃");
        return view1;
    }

    static
    class ViewHolder {
        @BindView(R.id.riqi)
        TextView riqi;
        @BindView(R.id.tu)
        ImageView tu;
        @BindView(R.id.zhuangtai)
        TextView zhuangtai;
        @BindView(R.id.wc)
        TextView wc;
        @BindView(R.id.beijing)
        RelativeLayout beijing;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

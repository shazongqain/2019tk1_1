package com.example.tiku1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tiku1.R;
import com.example.tiku1.bean.Hjzb;
import com.example.tiku1.bean.Yz;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class hjzbadapter extends BaseAdapter {
    private List<Hjzb> mhjzb;
    private List<Yz> myz;
    private Context context;

    public hjzbadapter(Context context, List<Hjzb> mhjzb, List<Yz> myz) {
        this.context = context;
        this.mhjzb = mhjzb;
        this.myz = myz;
    }

    @Override
    public int getCount() {
        return 6;
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
        Hjzb hjzb = mhjzb.get(mhjzb.size() - 1);
        View view1 = View.inflate(context, R.layout.hjzb_item, null);
        ViewHolder viewHolder = new ViewHolder(view1);
        switch (i)
        {
            case 0:
                if (hjzb.getTemperature()>myz.get(0).getTemperature())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("温度");
                viewHolder.zhi.setText(hjzb.getTemperature()+"");
                break;
            case 1:
                if (hjzb.getHumidity()>myz.get(0).getHumidity())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("湿度");
                viewHolder.zhi.setText(hjzb.getHumidity()+"");
                break;
            case 2:
                if (hjzb.getIllumination()>myz.get(0).getIllumination())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("光照");
                viewHolder.zhi.setText(hjzb.getIllumination()+"");
                break;
            case 3:
                if (hjzb.getCo2()>myz.get(0).getCo2())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("CO2");
                viewHolder.zhi.setText(hjzb.getCo2()+"");
                break;
            case 4:
                if (hjzb.getPm25()>myz.get(0).getPm25())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("PM2.5");
                viewHolder.zhi.setText(hjzb.getPm25()+"");
                break;
            case 5:
                if (hjzb.getDl()>myz.get(0).getPath())
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb2);
                }else {
                    viewHolder.beijing.setBackgroundResource(R.drawable.hjzb1);
                }
                viewHolder.name.setText("道路状态");
                viewHolder.zhi.setText(hjzb.getDl()+"");
                break;
        }
        return view1;
    }

    static
    class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.zhi)
        TextView zhi;
        @BindView(R.id.beijing)
        RelativeLayout beijing;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

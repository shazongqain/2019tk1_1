package com.example.tiku1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.bean.Dzbc;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class dzbcadapter extends BaseAdapter {
    private List<Dzbc> mdzbc;
    private Context context;

    public interface  SetData{
        void setdata(int position, String kaishi, String jieshu, String zhongjian, String zhongjian2, String piaojia, String licehng);
    }
    public SetData data;
    public void SetData(SetData data)
    {
        this.data=data;
    }
    public dzbcadapter(Context context, List<Dzbc> mdzbc) {
        this.context = context;
        this.mdzbc = mdzbc;
    }

    @Override
    public int getCount() {
        return mdzbc.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final Dzbc d = mdzbc.get(i);
        View view1 = View.inflate(context, R.layout.dzbc_item, null);
        ViewHolder viewHolder = new ViewHolder(view1);
        viewHolder.luhao.setText(d.getLuhao());
        viewHolder.kaishi.setText(d.getKaishi());
        viewHolder.jeishu.setText(d.getJieshu());
        viewHolder.licheng.setText("里程："+d.getLichenh()+".0km");
        viewHolder.piajia.setText("票价：￥"+d.getPiaojia()+".0");
        viewHolder.shijian1.setText(d.getShijian());
        viewHolder.shijian2.setText(d.getShijian1());
        viewHolder.beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setdata(i,d.getKaishi(),d.getJieshu(),d.getZhongjian1(),d.getZhongjian2(),d.getPiaojia(),d.getLichenh());
            }
        });
        return view1;
    }

    static
    class ViewHolder {
        @BindView(R.id.luhao)
        TextView luhao;
        @BindView(R.id.kaishi)
        TextView kaishi;
        @BindView(R.id.jeishu)
        TextView jeishu;
        @BindView(R.id.piajia)
        TextView piajia;
        @BindView(R.id.licheng)
        TextView licheng;
        @BindView(R.id.shijian1)
        TextView shijian1;
        @BindView(R.id.shijian2)
        TextView shijian2;
        @BindView(R.id.beijing)
        RelativeLayout beijing;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

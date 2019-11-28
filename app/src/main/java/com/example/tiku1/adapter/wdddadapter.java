package com.example.tiku1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.bean.Tjdd;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class wdddadapter extends BaseAdapter {
    private List<Tjdd> mtjdd;
    private Context context;

    public wdddadapter(Context context, List<Tjdd> mtjdd) {
        this.context = context;
        this.mtjdd = mtjdd;
    }

    @Override
    public int getCount() {
        return mtjdd.size();
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
        Tjdd t = mtjdd.get(i);
        View view1 = View.inflate(context, R.layout.wddd_item, null);
        ViewHolder viewHolder  =new ViewHolder(view1);
        viewHolder.name.setText(t.getName());
        viewHolder.time.setText(t.getTime());
        viewHolder.luxian.setText(t.getLuxian());
        viewHolder.kaishi.setText(t.getKaishi());
        viewHolder.jieshu.setText(t.getJieshu());
        return view1;
    }

    static
    class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.luxian)
        TextView luxian;
        @BindView(R.id.kaishi)
        TextView kaishi;
        @BindView(R.id.jieshu)
        TextView jieshu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

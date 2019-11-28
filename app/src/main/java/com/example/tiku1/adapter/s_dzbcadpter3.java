package com.example.tiku1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.tiku1.R;
import com.example.tiku1.bean.Yanse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class s_dzbcadpter3 extends BaseAdapter {
    private List<Yanse> myanse;
    private String[] yangli;
    private String[] yinli;
    private Context context;
    public interface  SetData{
        void setdata(int position, String yangli);
    }
    public SetData data;
    public void SetData(SetData data)
    {
        this.data=data;
    }

    public s_dzbcadpter3(Context context, List<Yanse> myanse, String[] yangli, String[] yinli) {
        this.context = context;
        this.myanse = myanse;
        this.yangli = yangli;
        this.yinli = yinli;
    }

    @Override
    public int getCount() {
        return 47;
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
        final Yanse y = myanse.get(i);
        View view1 = View.inflate(context, R.layout.rili_item, null);

        final ViewHolder viewHolder = new ViewHolder(view1);
        viewHolder.rl1.setText(yangli[i]);
        viewHolder.rl2.setText(yinli[i]);
        if (i == 0 || i == 1|| i == 2|| i == 3|| i == 4||
                i == 6|| i == 7|| i == 13|| i == 14||
                i == 20|| i == 21|| i ==27|| i == 28|| i == 34|| i == 35
                || i == 41|| i == 42|| i == 46) {

            viewHolder.beijing.setBackgroundResource(R.drawable.dzbcbk1);
        }else {
            viewHolder.beijing.setBackgroundResource(R.drawable.dzbcbk2);
        }
        viewHolder.beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setdata(i,yangli[i]);
                if (y.getYanse()==2)
                {
                    viewHolder.beijing.setBackgroundResource(R.drawable.dzbcbk3);
                }else {
                    if (i == 0 || i == 1|| i == 2|| i == 3|| i == 4||
                            i == 6|| i == 7|| i == 13|| i == 14||
                            i == 20|| i == 21|| i ==27|| i == 28|| i == 34|| i == 35
                            || i == 41|| i == 42|| i == 46) {

                        viewHolder.beijing.setBackgroundResource(R.drawable.dzbcbk1);
                    }else {
                        viewHolder.beijing.setBackgroundResource(R.drawable.dzbcbk2);
                    }
                }
            }
        });
        return view1;
    }

    static
    class ViewHolder {
        @BindView(R.id.rl1)
        TextView rl1;
        @BindView(R.id.rl2)
        TextView rl2;
        @BindView(R.id.beijing)
        RelativeLayout beijing;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

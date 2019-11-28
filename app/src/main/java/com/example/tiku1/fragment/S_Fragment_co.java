package com.example.tiku1.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tiku1.AppClient;
import com.example.tiku1.R;
import com.example.tiku1.bean.Hjzb;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class S_Fragment_co extends Fragment {

    @BindView(R.id.bt)
    TextView bt;
    @BindView(R.id.liechart)
    LineChart liechart;
    Unbinder unbinder;
    private AppClient mApp;
    private List<Hjzb> mhjzb;
    private LineData data;
    private LineDataSet dataSet;
    private List<Entry> mY;
    private List<String> mX;
    private boolean is = true;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            settu();
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sshj_layout, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bt.setText("CO2");
        mApp = (AppClient) getActivity().getApplication();
        mhjzb = mApp.getMhjzb();
        mX = new ArrayList<>();
        mY = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    try {
                        handler.sendEmptyMessage(0);
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (is);
            }
        }).start();
        settu();
    }

    private void settu() {
        System.out.println("-*---" + mhjzb);
        mY.clear();
        mX.clear();
        if (mhjzb.size() == 0) {
            return;
        }
        for (int i = 0; i < mhjzb.size(); i++) {
            Hjzb h = mhjzb.get(i);
            mY.add(new Entry(i, h.getCo2()));
            mX.add(h.getTime());
        }

        dataSet = new LineDataSet(mY, "");
        dataSet.setColors(Color.GRAY);
        dataSet.setDrawCircleHole(false);
        dataSet.setCircleColors(Color.GRAY);
        data = new LineData(dataSet);
        data.setDrawValues(false);
        liechart.setData(data);
        liechart.invalidate();
        liechart.getAxisRight().setEnabled(false);
        liechart.getLegend().setEnabled(false);
        liechart.setDescription(null);
        XAxis xAxis = liechart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(mX));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(90);
        xAxis.setLabelCount(60);
        liechart.setTouchEnabled(false);
        liechart.setDoubleTapToZoomEnabled(false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        is = false;
    }
}

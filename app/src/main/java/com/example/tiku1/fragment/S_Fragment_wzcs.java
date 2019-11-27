package com.example.tiku1.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiku1.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class S_Fragment_wzcs extends Fragment {
    @BindView(R.id.barchart)
    HorizontalBarChart barchart;
    Unbinder unbinder;
    private int a, b, c;

    private BarDataSet dataSet;

    private BarData data;
    private List<BarEntry> mY;
    private List<String> mX;
    private List<Integer> color;
    public S_Fragment_wzcs(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.s_fragment_wzcs, null);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        settu();
    }

    private void settu() {
        mY = new ArrayList<>();
        mX = new ArrayList<>();
        addatga();
        setcolor();
        dataSet = new BarDataSet(mY,"");
        dataSet.setColors(color);
        data = new BarData(dataSet);
        data.setBarWidth(0.5f);
        data.setValueFormatter(new PercentFormatter());
        barchart.setData(data);
        barchart.invalidate();
        barchart.getLegend().setEnabled(false);
        barchart.getAxisLeft().setEnabled(false);
        barchart.setDescription(null);
        barchart.setTouchEnabled(false);
        barchart.setDoubleTapToZoomEnabled(false);
        XAxis xAxis  =barchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(mX));
        xAxis.setDrawGridLines(false);
        barchart.getAxisRight().setValueFormatter(new PercentFormatter());
        barchart.getAxisRight().setStartAtZero(true);
        barchart.getAxisLeft().setStartAtZero(true);


    }

    private void setcolor() {
        color = new ArrayList<>();
        color.add(Color.parseColor("#91D24F"));

        color.add(Color.parseColor("#4C80C2"));
        color.add(Color.parseColor("#C00201"));
    }

    private void addatga() {
        mX.add("1-2条违章");  mX.add("3-5条违章");  mX.add("5条以上违章");
        mY.add(new BarEntry(0,(float)a/(a+b+c)*100));
        mY.add(new BarEntry(1,(float)b/(a+b+c)*100));
        mY.add(new BarEntry(2,(float)c/(a+b+c)*100));


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

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
import com.example.tiku1.bean.Yeswz;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class S_Fragment_wzcf extends Fragment {
    @BindView(R.id.piechaert)
    PieChart piechaert;
    Unbinder unbinder;
    private PieDataSet dataSet;
    private PieData data;
    private List<PieEntry> pieEntries;
    private List<Integer> color;
    private List<Yeswz> myeswz;
    private Map<String ,Float> cf;
    private float chongfu,buchongfu;
    public S_Fragment_wzcf( List<Yeswz> myeswz,Map<String ,Float> cf)
    {
        this.myeswz=myeswz;
        this.cf=cf;
        chongfu = (float) cf.size()/(float) myeswz.size();
        buchongfu=1-chongfu;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.s_fragment_wzcf, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        settu();
    }

    private void settu() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(chongfu,"有重复违章"));
        pieEntries.add(new PieEntry(buchongfu,"无重复违章"));
        color = new ArrayList<>();
        color.add(Color.parseColor("#AA4643"));
        color.add(Color.parseColor("#4572A7"));
        dataSet = new PieDataSet(pieEntries,"");
        dataSet.setColors(color);
        dataSet.setValueLinePart2Length(1.0f);
        dataSet.setValueLinePart1Length(1.0f);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setValueLinePart1OffsetPercentage(80f);
        dataSet.setSliceSpace(0.3f);
        data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        piechaert.setData(data);
        piechaert.invalidate();
        piechaert.setDrawHoleEnabled(false);
        Legend legend  =piechaert.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setFormSize(25f);
        legend.setTextSize(25f);
        piechaert.setDescription(null);
        piechaert.setTouchEnabled(false);
        piechaert.setEntryLabelColor(Color.BLACK);
        piechaert.setUsePercentValues(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

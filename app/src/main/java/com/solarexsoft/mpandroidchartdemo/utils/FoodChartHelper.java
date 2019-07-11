package com.solarexsoft.mpandroidchartdemo.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.solarexsoft.mpandroidchartdemo.App;
import com.solarexsoft.mpandroidchartdemo.R;

import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 11:37/2019-07-08
 *    Desc:
 * </pre>
 */

public class FoodChartHelper {
    public static void setupBarChartTheme(BarChart barChart) {
        Resources resources = App.getApplication().getResources();

        barChart.setBackgroundColor(Color.WHITE);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        barChart.setDrawBorders(false);
        barChart.setScaleEnabled(false);
        barChart.setScaleYEnabled(false);
        barChart.setScaleXEnabled(false);
        barChart.setPinchZoom(false);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.getDescription().setEnabled(false);
        barChart.setNoDataTextColor(resources.getColor(R.color.c_aab2b7));

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(resources.getColor(R.color.c_BAC4CB));
        xAxis.setTextSize(11);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setTextColor(resources.getColor(R.color.c_BAC4CB));
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextSize(11);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGridColor(resources.getColor(R.color.c_f2f4f5));
        leftAxis.enableGridDashedLine(30f, 15f, 0f);
        leftAxis.setLabelCount(6, true);
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.invalidate();
    }

    public static void setMealXAxisRangeFixed(BarChart barChart) {
        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(5);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setLabelCount(6, true);
        xAxis.setValueFormatter(new MealsXAxisValueFormatter());
    }

    public static void setXAxisWeekRangeFixed(BarChart barChart) {
        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(6);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        xAxis.setLabelCount(7, true);
//        xAxis.setValueFormatter(new WeekXAxisValueFormatter(BaseApplication.getApplication().getApplicationContext()));
    }

    public static void setXAXisMonthRangeFixed(BarChart barChart, int monthMax, int month) {
        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(monthMax - 1);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(1);
        barChart.setVisibleXRangeMaximum(7);
        /*
        MonthXAxisValueFormatter monthXAxisValueFormatter = new MonthXAxisValueFormatter();
        monthXAxisValueFormatter.setMaxDays(monthMax);
        monthXAxisValueFormatter.setMonthNum(month);
        xAxis.setValueFormatter(monthXAxisValueFormatter);
        */
    }

    public static void setFoodData(BarChart barChart, List<BarEntry> di, List<BarEntry> heshi, List<BarEntry> gao, boolean resetY) {
        if (resetY) {
            YAxis yAxis = barChart.getAxisLeft();
            yAxis.resetAxisMinimum();
            yAxis.resetAxisMaximum();
            yAxis.setAxisMinimum(0);
            yAxis.setLabelCount(6, true);
        }
        BarData barData = new BarData();
        Resources resources = App.getApplication().getResources();
        if (di != null && di.size() > 0) {
            BarDataSet diSet = new BarDataSet(di, "");
            diSet.setDrawValues(false);
            diSet.setHighLightColor(Color.TRANSPARENT);
            diSet.setHighLightAlpha(0);
            diSet.setColors(
                    resources.getColor(R.color.c_C9C9FD),
                    resources.getColor(R.color.c_9998FA)
            );
            barData.addDataSet(diSet);
        }
        if (heshi != null && heshi.size() > 0) {
            BarDataSet heshiSet = new BarDataSet(heshi, "");
            heshiSet.setDrawValues(false);
            heshiSet.setHighLightColor(Color.TRANSPARENT);
            heshiSet.setHighLightAlpha(0);
            heshiSet.setColors(
                    resources.getColor(R.color.c_38EEE7),
                    resources.getColor(R.color.c_1ad9ca)
            );
            barData.addDataSet(heshiSet);
        }
        if (gao != null && gao.size() > 0) {
            BarDataSet gaoSet = new BarDataSet(gao, "");
            gaoSet.setDrawValues(false);
            gaoSet.setHighLightColor(Color.TRANSPARENT);
            gaoSet.setHighLightAlpha(0);
            gaoSet.setColors(
                    resources.getColor(R.color.c_FF9D92),
                    resources.getColor(R.color.c_ff635a)
            );
            barData.addDataSet(gaoSet);
        }
        barData.setBarWidth(8f/55f);
        barChart.setData(barData);
        barChart.invalidate();
    }

    public static void setMealsData(BarChart barChart, List<BarEntry> me, List<BarEntry> crowd, boolean resetY) {
        Collections.sort(me, new EntryXComparator());
        Collections.sort(crowd, new EntryXComparator());
        Resources resources = App.getApplication().getResources();
        if (resetY) {
            YAxis yAxis = barChart.getAxisLeft();
            yAxis.resetAxisMaximum();
            yAxis.resetAxisMinimum();
            yAxis.setAxisMinimum(0);
            yAxis.setLabelCount(6, true);
        }
        BarDataSet barDataSetOne = new BarDataSet(me, "");
        barDataSetOne.setDrawValues(false);
        barDataSetOne.setHighLightColor(Color.TRANSPARENT);
        barDataSetOne.setHighLightAlpha(0);
        barDataSetOne.setColors(
                resources.getColor(R.color.c_1ad9ca)
                , resources.getColor(R.color.c_38EEE7)
        );
        BarDataSet barDataSetTwo = new BarDataSet(crowd, "");
        barDataSetTwo.setDrawValues(false);
        barDataSetTwo.setHighLightColor(Color.TRANSPARENT);
        barDataSetTwo.setHighLightAlpha(0);
        barDataSetTwo.setColors(
                resources.getColor(R.color.c_9998FA)
                , resources.getColor(R.color.c_C9C9FD)
        );

        BarData barData = new BarData();
        barData.addDataSet(barDataSetOne);
        barData.addDataSet(barDataSetTwo);
        barData.setBarWidth(8f / 55f);
        barData.groupBars(0f, 29f / 55f, 5f / 55f);
        barChart.setData(barData);
        barChart.getXAxis().setCenterAxisLabels(true);
        barChart.invalidate();
    }
}

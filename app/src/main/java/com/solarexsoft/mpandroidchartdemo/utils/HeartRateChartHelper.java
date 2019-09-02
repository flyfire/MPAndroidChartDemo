package com.solarexsoft.mpandroidchartdemo.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.solarexsoft.mpandroidchartdemo.App;

import java.math.BigDecimal;

import static com.solarexsoft.mpandroidchartdemo.utils.HeartRateNewDayLineChartFormatter.ONE_HOUR;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 19:41/2019-08-26
 *    Desc:
 * </pre>
 */

public class HeartRateChartHelper {

    public static Toast toast;

    private static final String TAG = "HeartRateChartHelper";
    private static Resources mResources = App.getApplication().getResources();

    public static void setupHeartRateDayLineChartTheme(LineChart lineChart) {
        Resources resources = App.getApplication().getResources();

        lineChart.setBackgroundColor(Color.WHITE);
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false);
        lineChart.setScaleEnabled(false);
        lineChart.setScaleYEnabled(false);
        lineChart.setScaleXEnabled(false);
        lineChart.setPinchZoom(false);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.getDescription().setEnabled(false);
        lineChart.setNoDataTextColor(Color.parseColor("#aab2b7"));

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.parseColor("#bac4cb"));
        xAxis.setTextSize(11);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        /*
        xAxis.setAxisMinimum(-1 * ONE_HOUR);
        xAxis.setAxisMaximum(25 * ONE_HOUR);
        xAxis.setGranularity(ONE_HOUR);
        xAxis.setLabelCount(27, true);
        xAxis.setValueFormatter(new HeartRateDayLineChartFormatter());
         */
        // x轴可滑动
        /*
        xAxis.setAxisMinimum(-1 * ONE_HOUR);
        xAxis.setAxisMaximum(25 * ONE_HOUR);
        xAxis.setGranularity(ONE_HOUR);
        xAxis.setLabelCount(7, true);
        lineChart.setVisibleXRangeMaximum(5);
        xAxis.setValueFormatter(new HeartRateNewDayLineChartFormatter());
         */
        xAxis.setAxisMinimum(0 * ONE_HOUR);
        xAxis.setAxisMaximum(24 * ONE_HOUR);
        xAxis.setGranularity(ONE_HOUR);
        xAxis.setGranularityEnabled(true);
        xAxis.setLabelCount(6, true);
        lineChart.setVisibleXRangeMaximum(5 * ONE_HOUR);
        xAxis.setValueFormatter(new TwentyFourHourFormatter());
        BigDecimal minVal = new BigDecimal(xAxis.getAxisMinimum());
        BigDecimal maxVal = new BigDecimal(xAxis.getAxisMaximum());
        Log.d(TAG, "xaxis min = " + minVal + ",max = " + maxVal);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setTextColor(Color.parseColor("#bac4cb"));
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextSize(11);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGridColor(Color.parseColor("#DBE0E4"));
        leftAxis.enableGridDashedLine(30f, 15f, 0f);
        leftAxis.setAxisMaximum(200);
        leftAxis.setAxisMinimum(0);
        leftAxis.setGranularity(50);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setLabelCount(5, true);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
    }
}

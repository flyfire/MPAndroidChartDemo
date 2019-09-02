package com.solarexsoft.mpandroidchartdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.solarexsoft.mpandroidchartdemo.R;
import com.solarexsoft.mpandroidchartdemo.utils.HeartRateChartHelper;
import com.solarexsoft.mpandroidchartdemo.utils.TwentyFourHourFormatter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 16:20/2019-09-02
 *    Desc:
 * </pre>
 */

public class LineChartTestActivity extends Activity {
    private static final String TAG = "LineChartTestActivity";
    static final long ONE_HOUR = TimeUnit.HOURS.toMillis(1);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        setContentView(R.layout.activity_linechart_test);
        LineChart lc_data = findViewById(R.id.lc_data);
        HeartRateChartHelper.setupHeartRateDayLineChartTheme(lc_data);
        XAxis xAxis = lc_data.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(24 * ONE_HOUR);
        xAxis.setGranularityEnabled(true);
        xAxis.setGranularity(ONE_HOUR);
        xAxis.setValueFormatter(new TwentyFourHourFormatter());
        Entry entry = new Entry(3 * ONE_HOUR, 200);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        LineDataSet dataSet = new LineDataSet(entries, "");
        LineData lineData = new LineData(dataSet);
        lc_data.setData(lineData);
        xAxis.setLabelCount(6, true);
        lc_data.setVisibleXRangeMaximum(5 * ONE_HOUR);
        lc_data.invalidate();
        BigDecimal minVal = new BigDecimal(xAxis.getAxisMinimum());
        BigDecimal maxVal = new BigDecimal(xAxis.getAxisMaximum());
        Log.d(TAG, "minval = " + minVal + ",maxval = " + maxVal);
    }
}

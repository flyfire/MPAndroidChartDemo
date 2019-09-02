package com.solarexsoft.mpandroidchartdemo.utils;

import android.util.Log;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 16:28/2019-09-02
 *    Desc:
 * </pre>
 */

public class TwentyFourHourFormatter extends ValueFormatter {
    private static final String TAG = "TwentyFourHourFormatter";
    public static long ONE_HOUR = TimeUnit.HOURS.toMillis(1);
    @Override
    public String getFormattedValue(float value) {
        float diff0 = value;
        float diff1 = value - 1 * ONE_HOUR;
        float diff2 = value - 2 * ONE_HOUR;
        float diff3 = value - 3 * ONE_HOUR;
        float diff4 = value - 4 * ONE_HOUR;
        float diff5 = value - 5 * ONE_HOUR;
        float diff6 = value - 6 * ONE_HOUR;
        float diff7 = value - 7 * ONE_HOUR;
        float diff8 = value - 8 * ONE_HOUR;
        float diff9 = value - 9 * ONE_HOUR;
        float diff10 = value - 10 * ONE_HOUR;
        float diff11 = value - 11 * ONE_HOUR;
        float diff12 = value - 12 * ONE_HOUR;
        float diff13 = value - 13 * ONE_HOUR;
        float diff14 = value - 14 * ONE_HOUR;
        float diff15 = value - 15 * ONE_HOUR;
        float diff16 = value - 16 * ONE_HOUR;
        float diff17 = value - 17 * ONE_HOUR;
        float diff18 = value - 18 * ONE_HOUR;
        float diff19 = value - 19 * ONE_HOUR;
        float diff20 = value - 20 * ONE_HOUR;
        float diff21 = value - 21 * ONE_HOUR;
        float diff22 = value - 22 * ONE_HOUR;
        float diff23 = value - 23 * ONE_HOUR;
        float diff24 = value - 24 * ONE_HOUR;
        String ret = "";
        if (-0.1f < diff0 && diff0 < 0.1f) {
            ret = "0时";
        } else if (-0.1f < diff1 && diff1 < 0.1f) {
            ret = "1时";
        } else if (-0.1f < diff2 && diff2 < 0.1f) {
            ret = "2时";
        } else if (-0.1f < diff3 && diff3 < 0.1f) {
            ret = "3时";
        } else if (-0.1f < diff4 && diff4 < 0.1f) {
            ret = "4时";
        } else if (-0.1f < diff5 && diff5 < 0.1f) {
            ret = "5时";
        } else if (-0.1f < diff6 && diff6 < 0.1f) {
            ret = "6时";
        } else if (-0.1f < diff7 && diff7 < 0.1f) {
            ret = "7时";
        } else if (-0.1f < diff8 && diff8 < 0.1f) {
            ret = "8时";
        } else if (-0.1f < diff9 && diff9 < 0.1f) {
            ret = "9时";
        } else if (-0.1f < diff10 && diff10 < 0.1f) {
            ret = "10时";
        } else if (-0.1f < diff11 && diff11 < 0.1f) {
            ret = "11时";
        } else if (-0.1f < diff12 && diff12 < 0.1f) {
            ret = "12时";
        } else if (-0.1f < diff13 && diff13 < 0.1f) {
            ret = "13时";
        } else if (-0.1f < diff14 && diff14 < 0.1f) {
            ret = "14时";
        } else if (-0.1f < diff15 && diff15 < 0.1f) {
            ret = "15时";
        } else if (-0.1f < diff16 && diff16 < 0.1f) {
            ret = "16时";
        } else if (-0.1f < diff17 && diff17 < 0.1f) {
            ret = "17时";
        } else if (-0.1f < diff18 && diff18 < 0.1f) {
            ret = "18时";
        } else if (-0.1f < diff19 && diff19 < 0.1f) {
            ret = "19时";
        } else if (-0.1f < diff20 && diff20 < 0.1f) {
            ret = "20时";
        } else if (-0.1f < diff21 && diff21 < 0.1f) {
            ret = "21时";
        } else if (-0.1f < diff22 && diff22 < 0.1f) {
            ret = "22时";
        } else if (-0.1f < diff23 && diff23 < 0.1f) {
            ret = "23时";
        } else if (-0.1f < diff24 && diff24 < 0.1f) {
            ret = "0时";
        }
        BigDecimal val = new BigDecimal(value);
        Log.d(TAG, "value = " + val + ",ret = " + ret);
        return ret;
    }
}

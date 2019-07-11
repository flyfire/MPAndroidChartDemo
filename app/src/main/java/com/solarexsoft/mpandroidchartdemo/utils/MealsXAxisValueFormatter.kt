package com.solarexsoft.mpandroidchartdemo.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter
import com.solarexsoft.mpandroidchartdemo.App
import com.solarexsoft.mpandroidchartdemo.R
import kotlin.math.roundToInt

/**
 * <pre>
 *    Author: houruhou
 *    CreatAt: 17:00/2019-07-11
 *    Desc:
 * </pre>
 */
 
class MealsXAxisValueFormatter : ValueFormatter() {
    var mMeals: Array<String> = App.getApplication().resources.getStringArray(R.array.meals);
    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val index = value.roundToInt();
        if (index >= 0 && index < mMeals.size) {
            return mMeals[index]
        }
        return ""
    }
}
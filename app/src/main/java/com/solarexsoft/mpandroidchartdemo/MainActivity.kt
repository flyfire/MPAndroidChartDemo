package com.solarexsoft.mpandroidchartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarEntry
import com.solarexsoft.mpandroidchartdemo.utils.FoodChartHelper
import com.solarexsoft.mpandroidchartdemo.utils.FoodMeals

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bc = findViewById<BarChart>(R.id.bc_main)
        FoodChartHelper.setupBarChartTheme(bc)
        val me = mutableListOf<BarEntry>()
        me.add(BarEntry(FoodMeals.BREAKFAST.ordinal.toFloat(), 1143.0f))
        me.add(BarEntry(FoodMeals.LUNCH.ordinal.toFloat(), 0.0f))
        me.add(BarEntry(FoodMeals.HIGHTEA.ordinal.toFloat(), 443.0f))
        me.add(BarEntry(FoodMeals.DINNER.ordinal.toFloat(), 943.0f))
        me.add(BarEntry(FoodMeals.SUPPER.ordinal.toFloat(), 0.0f))
        val crowd = mutableListOf<BarEntry>()
        crowd.add(BarEntry(FoodMeals.BREAKFAST.ordinal.toFloat(), 600.0f))
        crowd.add(BarEntry(FoodMeals.LUNCH.ordinal.toFloat(), 600.0f))
        crowd.add(BarEntry(FoodMeals.HIGHTEA.ordinal.toFloat(), 0.0f))
        crowd.add(BarEntry(FoodMeals.DINNER.ordinal.toFloat(), 600.0f))
        crowd.add(BarEntry(FoodMeals.SUPPER.ordinal.toFloat(), 0.0f))
        FoodChartHelper.setMealXAxisRangeFixed(bc)
        FoodChartHelper.setMealsData(bc, me, crowd, true)
    }
}

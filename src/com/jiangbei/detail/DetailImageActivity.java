package com.jiangbei.detail;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jiangbei.R;

/**
 * 详细信息之图表形式界面
 * */
public class DetailImageActivity extends Activity {
	public static DetailImageActivity detailImage;

	private LineChart mLineChart;
	private XAxis xLineAxis; // X坐标轴
	private YAxis yLineAxis; // Y坐标轴
	
	private BarChart mBarChart;
	private XAxis xBarAxis; // X坐标轴
	private YAxis yBarAxis; // Y坐标轴

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_image_activity);
		detailImage = this;
		mLineChart = (LineChart) findViewById(R.id.detail_line_chart);
		mBarChart = (BarChart) findViewById(R.id.detail_bar_chart);
		
		//折线图操作
		xLineAxis = mLineChart.getXAxis();
		yLineAxis = mLineChart.getAxisLeft();
		String[] aa = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
        String[] bb = {"14.4","14","13.8","13.6","12.5","12.4","12.4","12.3","10.9","10.9","10.8","10.9","10.7","11","11"};  
		LineData mLineData = getLineData(aa,bb);//获取坐标数据
		showLineChart(mLineChart, mLineData);//折线图效果显示
		
		//柱状图操作
		xBarAxis = mBarChart.getXAxis();
		yBarAxis = mBarChart.getAxisLeft();
		String[] cc = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
        String[] dd = {"2523.9","5307.2","8158","11459","2725.9","5840.5","8637.1","12656.7","2982.7","6440.5","9500.8","14265.4","3306.69","7237.9","11252.67"}; 
		BarData  mBarData = getBarData(cc,dd);  //获取坐标数据
		showBarChart(mBarChart, mBarData); //柱状图效果显示
		
		
	}
	/**
	 * 更新显示子分区的列表
	 * */
	public void refresh(int regionNumber) {
		switch (regionNumber) {
		case 1:
			//折线图操作
			String[] aa = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bb = {"14.4","14","13.8","13.6","12.5","12.4","12.4","12.3","10.9","10.9","10.8","10.9","10.7","11","11"};  
			LineData mLineData = getLineData(aa,bb);//获取坐标数据
			showLineChart(mLineChart, mLineData);//折线图效果显示
			//柱状图操作
			String[] cc = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] dd = {"2523.9","5307.2","8158","11459","2725.9","5840.5","8637.1","12656.7","2982.7","6440.5","9500.8","14265.4","3306.69","7237.9","11252.67"}; 
			BarData  mBarData = getBarData(cc,dd);  //获取坐标数据
			showBarChart(mBarChart, mBarData); //柱状图效果显示
			break;
		case 2:
			//折线图操作
			String[] aaTwo = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbTwo = {"3.9","4.7","4.9","5.3","4.2","3.5",".38","4.7","4","3.8","4.2","4.4","3.7","4.2","4.3"};  
			LineData mLineDataTwo = getLineData(aaTwo,bbTwo);//获取坐标数据
			showLineChart(mLineChart, mLineDataTwo);//折线图效果显示
			//柱状图操作
			String[] ccTwo = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddTwo = {"104.5","273.3","628.9","940","114.6","293.5","672.7","1002.7","117.1","307.8","711.4","1061","118.84","318.79","756.32"}; 
			BarData  mBarDataTwo = getBarData(ccTwo,ddTwo);  //获取坐标数据
			showBarChart(mBarChart, mBarDataTwo); //柱状图效果显示
			break;
		case 3:
			//折线图操作
			String[] aaThree = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbThree = {"16.2","15.7","15.7","15.6","13.7","13.6","13.4","13.4","12.9","12.8","12.6","12.7","11.2","11.5","11.4"};  
			LineData mLineDataThree = getLineData(aaThree,bbThree);//获取坐标数据
			showLineChart(mLineChart, mLineDataThree);//折线图效果显示
			//柱状图操作
			String[] ccThree = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddThree = {"1498.9","3049.9","4482.9","6172.3","1567.6","3185","4597.7","6397.9","1688.4","3482.3","5079","6531.9","1522.34","3325.38","5018.67"}; 
			BarData  mBarDataThree = getBarData(ccThree,ddThree);  //获取坐标数据
			showBarChart(mBarChart, mBarDataThree); //柱状图效果显示
			break;
		case 4:
			//折线图操作
			String[] aaFour = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbFour = {"12.2","12.3","12.2","12","11","11.6","12.2","12","7.7","8.3","8.6","10","10.6","11","11.2"};  
			LineData mLineDataFour = getLineData(aaFour,bbFour);//获取坐标数据
			showLineChart(mLineChart, mLineDataFour);//折线图效果显示
			//柱状图操作
			String[] ccFour = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddFour = {"920.4","1984","3046.3","4346.7","1043.7","2362.1","3366.8","5256.1","1177.3","2650.5","3710.5","6672.5","1665.51","3593.73","5477.68"}; 
			BarData  mBarDataFour = getBarData(ccFour,ddFour);  //获取坐标数据
			showBarChart(mBarChart, mBarDataFour); //柱状图效果显示
			break;
		case 5:
			//折线图操作
			String[] aaFive = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbFive = {"16","16.2","16","15.9","13.3","13.3","13.1","13.1","12.7","12.6","12.4","12.3","10.6","10.8","10.6"};  
			LineData mLineDataFive = getLineData(aaFive,bbFive);//获取坐标数据
			showLineChart(mLineChart, mLineDataFive);//折线图效果显示
			//柱状图操作
			String[] ccFive = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddFive = {"1314.5","2624","3797.8","5181","1350.5","2688.6","3800.9","5249.7","1438.7","2911","4164.3","5175.8","1231.9","2679.84","3958.95"}; 
			BarData  mBarDataFive = getBarData(ccFive,ddFive);  //获取坐标数据
			showBarChart(mBarChart, mBarDataFive); //柱状图效果显示
			break;
		case 6:
			//折线图操作
			String[] aaSix = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbSix = {"17.7","12.6","13.9","13.9","16.5","15.3","15.3","14.9","14.2","14.4","14.2","14.4","14.7","14.8","15.2"};  
			LineData mLineDataSix = getLineData(aaSix,bbSix);//获取坐标数据
			showLineChart(mLineChart, mLineDataSix);//折线图效果显示
			//柱状图操作
			String[] ccSix = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddSix = {"184.4","425.9","685.1","991.3","217.1","496.3","796.7","1148.3","249.7","571.3","914.7","1356.1","290.44","645.54","1059.72"}; 
			BarData  mBarDataSix = getBarData(ccSix,ddSix);  //获取坐标数据
			showBarChart(mBarChart, mBarDataSix); //柱状图效果显示
			break;
		case 7:
			//折线图操作
			String[] aaSeven = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbSeven = {"9.1","9.4","9.2","9.1","5.9","6.1","8.6","9.2","7","7.3","7.5","9.1","9.1","8.8","9.4"};  
			LineData mLineDataSeven = getLineData(aaSeven,bbSeven);//获取坐标数据
			showLineChart(mLineChart, mLineDataSeven);//折线图效果显示
			//柱状图操作
			String[] ccSeven = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddSeven = {"85.8","238","376.9","515.2","90.6","246","385.9","580.9","95.6","260.9","410.9","705.8","116.87","357.87","971.36"}; 
			BarData  mBarDataSeven = getBarData(ccSeven,ddSeven);  //获取坐标数据
			showBarChart(mBarChart, mBarDataSeven); //柱状图效果显示
			break;
		case 8:
			//折线图操作
			String[] aaEight = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbEight = {"12.2","11.2","11.2","11.7","8.4","9.2","9.8","10","8.1","8.7","8.5","7.4","9.1","9.4","8.5"};  
			LineData mLineDataEight = getLineData(aaEight,bbEight);//获取坐标数据
			showLineChart(mLineChart, mLineDataEight);//折线图效果显示
			//柱状图操作
			String[] ccEight = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddEight = {"191.5","406.3","616.4","848","210.7","450.3","676.8","984.4","230","493.7","740.8","1229.9","282.78","634.49","554.53"}; 
			BarData  mBarDataEight = getBarData(ccEight,ddEight);  //获取坐标数据
			showBarChart(mBarChart, mBarDataEight); //柱状图效果显示
			break;
		default:
			break;
		}
	}

	/**
	 * 初始化折线图坐标轴的一些设置
	 */
	private void showLineChart(LineChart lineChart, LineData lineData) {
		// enable touch gestures
		lineChart.setTouchEnabled(true); // 设置是否可以触摸
		// enable scaling and dragging
		lineChart.setDragEnabled(true);// 是否可以拖拽
		lineChart.setScaleEnabled(true);// 是否可以缩放
		// if disabled, scaling can be done on x- and y-axis separately
		lineChart.setPinchZoom(false);//设置触控放大
				
		lineChart.setDrawBorders(false); // 是否在折线图上添加边框
		// no description text
		lineChart.setDescription("");// 数据描述
		// 如果没有数据的时候，会显示这个，类似listview的emtpyview
		lineChart.setNoDataTextDescription("You need to provide data for the chart.");
		// enable / disable grid background
		lineChart.setDrawGridBackground(false); // 是否显示表格颜色
		lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度
		
		lineChart.setBackgroundColor(Color.WHITE);// 设置背景

		// The Axis 坐标轴相关的,XY轴通用
		xLineAxis.setPosition(XAxisPosition.BOTTOM); // 设置X轴的数据在底部显示  
		xLineAxis.setEnabled(true); // 是否显示X坐标轴 及 对应的刻度竖线，默认是true
		xLineAxis.setDrawAxisLine(false); // 是否绘制坐标轴的线，即含有坐标的那条线，默认是true
		xLineAxis.setDrawGridLines(false); // 是否显示X坐标轴上的刻度竖线，默认是true
		xLineAxis.setDrawLabels(true); // 是否显示X坐标轴上的刻度，默认是true
		
		xLineAxis.setTextSize(5); // X轴上的刻度的字的大小 单位dp
		xLineAxis.setTypeface(Typeface.MONOSPACE); //X轴上的刻度的字体
		xLineAxis.resetLabelsToSkip(); // 将自/动计算坐标相隔多少
		xLineAxis.setAvoidFirstLastClipping(true);//保证第一个和最后一个坐标不隐藏
        
//		xLineAxis.setTextColor(Color.rgb(145, 13, 64)); // X轴上的刻度的颜色
//		xLineAxis.setGridColor(Color.rgb(145, 13, 64)); // X轴上的刻度竖线的颜色
//		xLineAxis.setGridLineWidth(1); // X轴上的刻度竖线的宽 float类型
//		xLineAxis.enableGridDashedLine(40, 3, 0); // 虚线表示X轴上的刻度竖线(float lineLength,
//												// float spaceLength, float
//												// phase)三个参数，1.线长，2.虚线间距，3.虚线开始坐标
//
//		// X轴专用
//		xLineAxis.setLabelsToSkip(1); // 设置坐标相隔多少，参数是int类型
//		xLineAxis.setSpaceBetweenLabels(4);
//		xLineAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);// 把坐标轴放在上下
//																// 参数有：TOP,
//																// BOTTOM,
//																// BOTH_SIDED,
//																// TOP_INSIDE or
//																// BOTTOM_INSIDE.
//
//		// Y轴专用
//		yLineAxis.setStartAtZero(false); // 设置Y轴坐标是否从0开始
//		yLineAxis.setAxisMaxValue(50); // 设置Y轴坐标最大为多少
//		yLineAxis.resetAxisMaxValue(); // 重新设置Y轴坐标最大为多少，自动调整
//		yLineAxis.setAxisMinValue(10); // 设置Y轴坐标最小为多少
//		yLineAxis.resetAxisMinValue(); // 重新设置Y轴坐标，自动调整
//		yLineAxis.setInverted(false); // Y轴坐标反转,默认是false,即下小上大
//		yLineAxis.setSpaceTop(0); // Y轴坐标距顶有多少距离，即留白
//		yLineAxis.setSpaceBottom(0); // Y轴坐标距底有多少距离，即留白
//		yLineAxis.setShowOnlyMinMax(false); // 参数如果为true Y轴坐标只显示最大值和最小值
//		yLineAxis.setLabelCount(10, false); // 第一个参数是Y轴坐标的个数，第二个参数是
//										// 是否不均匀分布，true是不均匀分布
//		yLineAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART); // 参数是INSIDE_CHART(Y轴坐标在内部)
//																	// 或
//																	// OUTSIDE_CHART(在外部（默认是这个）)

		// add data
		lineChart.setData(lineData); // 设置数据

		// get the legend (only possible after setting data)
		Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的

		// modify the legend ...
		// mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
		mLegend.setForm(LegendForm.CIRCLE);// 样式
		mLegend.setFormSize(6f);// 字体
		mLegend.setTextColor(Color.RED);// 颜色
		// mLegend.setTypeface(mTf);// 字体

		lineChart.animateX(1000); // 立即执行的动画,x轴
	}

	/**
	 * 生成折线图坐标点和折线数据
	 */
	private LineData getLineData(String[] xData,String[] yData ) {
  
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < xData.length; i++) {  
            xVals.add(xData[i]);  
        }  
        xVals.add("");
  
        ArrayList<Entry> yVals = new ArrayList<Entry>();  
        for (int i = 0; i < yData.length; i++) {  
            yVals.add(new Entry(Float.parseFloat(yData[i]), i));  
        }  
  
        // create a dataset and give it a type  
        LineDataSet set1 = new LineDataSet(yVals, "累计同比增长（%）");  
  
//        set1.setDrawCubic(true);  //设置曲线为圆滑的线  
        set1.setCubicIntensity(0.2f);  
        set1.setDrawFilled(false);  //设置包括的范围区域填充颜色  
        set1.setDrawCircles(true);  //设置有圆点  
        set1.setCircleColor(getResources().getColor(R.color.magenta)); //设置圆点颜色
        set1.setCircleSize(5f);   //设置圆点的大小  
        set1.setLineWidth(2f);    //设置线的宽度  
        set1.setHighLightColor(Color.BLUE);  //定位十字线颜色
        set1.setColor(getResources().getColor(R.color.mediumorchid));    //设置曲线的颜色  
  
        // create a data object with the datasets  
        LineData data = new LineData(xVals, set1); 

		return data;
	}
	/**
	 * 初始化柱状图坐标轴的一些设置
	 */
	private void showBarChart(BarChart barChart, BarData barData) {  
		
        barChart.setDrawBorders(false);  ////是否在折线图上添加边框   
            
        barChart.setDescription("");// 数据描述      
          
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView      
        barChart.setNoDataTextDescription("You need to provide data for the chart.");      
                 
        barChart.setDrawGridBackground(false); // 是否显示表格颜色      
        barChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度      
        
        barChart.setBackgroundColor(Color.WHITE);// 设置背景
        
        barChart.setTouchEnabled(true); // 设置是否可以触摸      
       
        barChart.setDragEnabled(true);// 是否可以拖拽      
        barChart.setScaleEnabled(true);// 是否可以缩放      
      
        barChart.setPinchZoom(false);////设置触控放大       
      
//      barChart.setBackgroundColor();// 设置背景      
          
        barChart.setDrawBarShadow(true);  
        
         
        barChart.setData(barData); // 设置数据      
  
        Legend mLegend = barChart.getLegend(); // 设置比例图标示  
      
        mLegend.setForm(LegendForm.CIRCLE);// 样式      
        mLegend.setFormSize(6f);// 字体      
        mLegend.setTextColor(Color.RED);// 颜色      
          
        // The Axis 坐标轴相关的,XY轴通用
        xBarAxis.setPosition(XAxisPosition.BOTTOM); // 设置X轴的数据在底部显示  
        xBarAxis.setEnabled(true); // 是否显示X坐标轴 及 对应的刻度竖线，默认是true
        xBarAxis.setDrawAxisLine(false); // 是否绘制坐标轴的线，即含有坐标的那条线，默认是true
        xBarAxis.setDrawGridLines(false); // 是否显示X坐标轴上的刻度竖线，默认是true
        xBarAxis.setDrawLabels(true); // 是否显示X坐标轴上的刻度，默认是true
        
        xBarAxis.setTextSize(5); // X轴上的刻度的字的大小 单位dp
        xBarAxis.setTypeface(Typeface.MONOSPACE); //X轴上的刻度的字体
        xBarAxis.resetLabelsToSkip(); // 将自/动计算坐标相隔多少
        xBarAxis.setAvoidFirstLastClipping(true);//保证第一个和最后一个坐标不隐藏
        
        xBarAxis.setAxisLineWidth(0.05f);
        yBarAxis.setAxisLineWidth(0.05f);
        
        barChart.animateX(1000); // 立即执行的动画,x轴    
    }  
	/**
	 * 生成柱状图柱子的柱子坐标数据
	 */
    private BarData getBarData(String[] xData,String[] yData ) {  
        //柱子的宽度根据柱状图BarChart控件的宽度除以坐标点个数 获得，目前只找到柱子间隙宽度的设置方法
  
        ArrayList<String> xValues = new ArrayList<String>();  
        for (int i = 0; i < xData.length; i++) {  
        	xValues.add(xData[i]);  
        }  
        xValues.add("");
        
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();  
  
        for (int i = 0; i < yData.length; i++) {  
        	yValues.add(new BarEntry(Float.parseFloat(yData[i]), i));  
        }  
          
        // y轴的数据集合      
        BarDataSet barDataSet = new BarDataSet(yValues, "本季累计（万元）");   
        barDataSet.setBarSpacePercent(40f);//柱状之间的间距
        barDataSet.setBarShadowColor(Color.alpha(0x70FFFFFF));//柱子背景色，设为透明
        barDataSet.setColor(getResources().getColor(R.color.mediumorchid));//柱子色 
       
        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();      
        barDataSets.add(barDataSet); // add the datasets  
      
        BarData barData = new BarData(xValues, barDataSets);  
        
        return barData;  
    }  

}

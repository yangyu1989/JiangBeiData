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
 * ��ϸ��Ϣ֮ͼ����ʽ����
 * */
public class DetailImageActivity extends Activity {
	public static DetailImageActivity detailImage;

	private LineChart mLineChart;
	private XAxis xLineAxis; // X������
	private YAxis yLineAxis; // Y������
	
	private BarChart mBarChart;
	private XAxis xBarAxis; // X������
	private YAxis yBarAxis; // Y������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_image_activity);
		detailImage = this;
		mLineChart = (LineChart) findViewById(R.id.detail_line_chart);
		mBarChart = (BarChart) findViewById(R.id.detail_bar_chart);
		
		//����ͼ����
		xLineAxis = mLineChart.getXAxis();
		yLineAxis = mLineChart.getAxisLeft();
		String[] aa = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
        String[] bb = {"14.4","14","13.8","13.6","12.5","12.4","12.4","12.3","10.9","10.9","10.8","10.9","10.7","11","11"};  
		LineData mLineData = getLineData(aa,bb);//��ȡ��������
		showLineChart(mLineChart, mLineData);//����ͼЧ����ʾ
		
		//��״ͼ����
		xBarAxis = mBarChart.getXAxis();
		yBarAxis = mBarChart.getAxisLeft();
		String[] cc = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
        String[] dd = {"2523.9","5307.2","8158","11459","2725.9","5840.5","8637.1","12656.7","2982.7","6440.5","9500.8","14265.4","3306.69","7237.9","11252.67"}; 
		BarData  mBarData = getBarData(cc,dd);  //��ȡ��������
		showBarChart(mBarChart, mBarData); //��״ͼЧ����ʾ
		
		
	}
	/**
	 * ������ʾ�ӷ������б�
	 * */
	public void refresh(int regionNumber) {
		switch (regionNumber) {
		case 1:
			//����ͼ����
			String[] aa = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bb = {"14.4","14","13.8","13.6","12.5","12.4","12.4","12.3","10.9","10.9","10.8","10.9","10.7","11","11"};  
			LineData mLineData = getLineData(aa,bb);//��ȡ��������
			showLineChart(mLineChart, mLineData);//����ͼЧ����ʾ
			//��״ͼ����
			String[] cc = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] dd = {"2523.9","5307.2","8158","11459","2725.9","5840.5","8637.1","12656.7","2982.7","6440.5","9500.8","14265.4","3306.69","7237.9","11252.67"}; 
			BarData  mBarData = getBarData(cc,dd);  //��ȡ��������
			showBarChart(mBarChart, mBarData); //��״ͼЧ����ʾ
			break;
		case 2:
			//����ͼ����
			String[] aaTwo = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbTwo = {"3.9","4.7","4.9","5.3","4.2","3.5",".38","4.7","4","3.8","4.2","4.4","3.7","4.2","4.3"};  
			LineData mLineDataTwo = getLineData(aaTwo,bbTwo);//��ȡ��������
			showLineChart(mLineChart, mLineDataTwo);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccTwo = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddTwo = {"104.5","273.3","628.9","940","114.6","293.5","672.7","1002.7","117.1","307.8","711.4","1061","118.84","318.79","756.32"}; 
			BarData  mBarDataTwo = getBarData(ccTwo,ddTwo);  //��ȡ��������
			showBarChart(mBarChart, mBarDataTwo); //��״ͼЧ����ʾ
			break;
		case 3:
			//����ͼ����
			String[] aaThree = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbThree = {"16.2","15.7","15.7","15.6","13.7","13.6","13.4","13.4","12.9","12.8","12.6","12.7","11.2","11.5","11.4"};  
			LineData mLineDataThree = getLineData(aaThree,bbThree);//��ȡ��������
			showLineChart(mLineChart, mLineDataThree);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccThree = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddThree = {"1498.9","3049.9","4482.9","6172.3","1567.6","3185","4597.7","6397.9","1688.4","3482.3","5079","6531.9","1522.34","3325.38","5018.67"}; 
			BarData  mBarDataThree = getBarData(ccThree,ddThree);  //��ȡ��������
			showBarChart(mBarChart, mBarDataThree); //��״ͼЧ����ʾ
			break;
		case 4:
			//����ͼ����
			String[] aaFour = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbFour = {"12.2","12.3","12.2","12","11","11.6","12.2","12","7.7","8.3","8.6","10","10.6","11","11.2"};  
			LineData mLineDataFour = getLineData(aaFour,bbFour);//��ȡ��������
			showLineChart(mLineChart, mLineDataFour);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccFour = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddFour = {"920.4","1984","3046.3","4346.7","1043.7","2362.1","3366.8","5256.1","1177.3","2650.5","3710.5","6672.5","1665.51","3593.73","5477.68"}; 
			BarData  mBarDataFour = getBarData(ccFour,ddFour);  //��ȡ��������
			showBarChart(mBarChart, mBarDataFour); //��״ͼЧ����ʾ
			break;
		case 5:
			//����ͼ����
			String[] aaFive = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbFive = {"16","16.2","16","15.9","13.3","13.3","13.1","13.1","12.7","12.6","12.4","12.3","10.6","10.8","10.6"};  
			LineData mLineDataFive = getLineData(aaFive,bbFive);//��ȡ��������
			showLineChart(mLineChart, mLineDataFive);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccFive = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddFive = {"1314.5","2624","3797.8","5181","1350.5","2688.6","3800.9","5249.7","1438.7","2911","4164.3","5175.8","1231.9","2679.84","3958.95"}; 
			BarData  mBarDataFive = getBarData(ccFive,ddFive);  //��ȡ��������
			showBarChart(mBarChart, mBarDataFive); //��״ͼЧ����ʾ
			break;
		case 6:
			//����ͼ����
			String[] aaSix = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbSix = {"17.7","12.6","13.9","13.9","16.5","15.3","15.3","14.9","14.2","14.4","14.2","14.4","14.7","14.8","15.2"};  
			LineData mLineDataSix = getLineData(aaSix,bbSix);//��ȡ��������
			showLineChart(mLineChart, mLineDataSix);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccSix = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddSix = {"184.4","425.9","685.1","991.3","217.1","496.3","796.7","1148.3","249.7","571.3","914.7","1356.1","290.44","645.54","1059.72"}; 
			BarData  mBarDataSix = getBarData(ccSix,ddSix);  //��ȡ��������
			showBarChart(mBarChart, mBarDataSix); //��״ͼЧ����ʾ
			break;
		case 7:
			//����ͼ����
			String[] aaSeven = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbSeven = {"9.1","9.4","9.2","9.1","5.9","6.1","8.6","9.2","7","7.3","7.5","9.1","9.1","8.8","9.4"};  
			LineData mLineDataSeven = getLineData(aaSeven,bbSeven);//��ȡ��������
			showLineChart(mLineChart, mLineDataSeven);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccSeven = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddSeven = {"85.8","238","376.9","515.2","90.6","246","385.9","580.9","95.6","260.9","410.9","705.8","116.87","357.87","971.36"}; 
			BarData  mBarDataSeven = getBarData(ccSeven,ddSeven);  //��ȡ��������
			showBarChart(mBarChart, mBarDataSeven); //��״ͼЧ����ʾ
			break;
		case 8:
			//����ͼ����
			String[] aaEight = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] bbEight = {"12.2","11.2","11.2","11.7","8.4","9.2","9.8","10","8.1","8.7","8.5","7.4","9.1","9.4","8.5"};  
			LineData mLineDataEight = getLineData(aaEight,bbEight);//��ȡ��������
			showLineChart(mLineChart, mLineDataEight);//����ͼЧ����ʾ
			//��״ͼ����
			String[] ccEight = {"2012-Q1","2012-Q1-2","2012-Q1-3","2012-Q1-4","2013-Q1","2013-Q1-2","2013-Q1-3","2013-Q1-4","2014-Q1","2014-Q1-2","2014-Q1-3","2014-Q1-4","2015-Q1","2015-Q1-2","2015-Q1-3"};  
	        String[] ddEight = {"191.5","406.3","616.4","848","210.7","450.3","676.8","984.4","230","493.7","740.8","1229.9","282.78","634.49","554.53"}; 
			BarData  mBarDataEight = getBarData(ccEight,ddEight);  //��ȡ��������
			showBarChart(mBarChart, mBarDataEight); //��״ͼЧ����ʾ
			break;
		default:
			break;
		}
	}

	/**
	 * ��ʼ������ͼ�������һЩ����
	 */
	private void showLineChart(LineChart lineChart, LineData lineData) {
		// enable touch gestures
		lineChart.setTouchEnabled(true); // �����Ƿ���Դ���
		// enable scaling and dragging
		lineChart.setDragEnabled(true);// �Ƿ������ק
		lineChart.setScaleEnabled(true);// �Ƿ��������
		// if disabled, scaling can be done on x- and y-axis separately
		lineChart.setPinchZoom(false);//���ô��طŴ�
				
		lineChart.setDrawBorders(false); // �Ƿ�������ͼ����ӱ߿�
		// no description text
		lineChart.setDescription("");// ��������
		// ���û�����ݵ�ʱ�򣬻���ʾ���������listview��emtpyview
		lineChart.setNoDataTextDescription("You need to provide data for the chart.");
		// enable / disable grid background
		lineChart.setDrawGridBackground(false); // �Ƿ���ʾ�����ɫ
		lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // ���ĵ���ɫ�����������Ǹ���ɫ����һ��͸����
		
		lineChart.setBackgroundColor(Color.WHITE);// ���ñ���

		// The Axis ��������ص�,XY��ͨ��
		xLineAxis.setPosition(XAxisPosition.BOTTOM); // ����X��������ڵײ���ʾ  
		xLineAxis.setEnabled(true); // �Ƿ���ʾX������ �� ��Ӧ�Ŀ̶����ߣ�Ĭ����true
		xLineAxis.setDrawAxisLine(false); // �Ƿ������������ߣ�����������������ߣ�Ĭ����true
		xLineAxis.setDrawGridLines(false); // �Ƿ���ʾX�������ϵĿ̶����ߣ�Ĭ����true
		xLineAxis.setDrawLabels(true); // �Ƿ���ʾX�������ϵĿ̶ȣ�Ĭ����true
		
		xLineAxis.setTextSize(5); // X���ϵĿ̶ȵ��ֵĴ�С ��λdp
		xLineAxis.setTypeface(Typeface.MONOSPACE); //X���ϵĿ̶ȵ�����
		xLineAxis.resetLabelsToSkip(); // ����/�����������������
		xLineAxis.setAvoidFirstLastClipping(true);//��֤��һ�������һ�����겻����
        
//		xLineAxis.setTextColor(Color.rgb(145, 13, 64)); // X���ϵĿ̶ȵ���ɫ
//		xLineAxis.setGridColor(Color.rgb(145, 13, 64)); // X���ϵĿ̶����ߵ���ɫ
//		xLineAxis.setGridLineWidth(1); // X���ϵĿ̶����ߵĿ� float����
//		xLineAxis.enableGridDashedLine(40, 3, 0); // ���߱�ʾX���ϵĿ̶�����(float lineLength,
//												// float spaceLength, float
//												// phase)����������1.�߳���2.���߼�࣬3.���߿�ʼ����
//
//		// X��ר��
//		xLineAxis.setLabelsToSkip(1); // ��������������٣�������int����
//		xLineAxis.setSpaceBetweenLabels(4);
//		xLineAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);// ���������������
//																// �����У�TOP,
//																// BOTTOM,
//																// BOTH_SIDED,
//																// TOP_INSIDE or
//																// BOTTOM_INSIDE.
//
//		// Y��ר��
//		yLineAxis.setStartAtZero(false); // ����Y�������Ƿ��0��ʼ
//		yLineAxis.setAxisMaxValue(50); // ����Y���������Ϊ����
//		yLineAxis.resetAxisMaxValue(); // ��������Y���������Ϊ���٣��Զ�����
//		yLineAxis.setAxisMinValue(10); // ����Y��������СΪ����
//		yLineAxis.resetAxisMinValue(); // ��������Y�����꣬�Զ�����
//		yLineAxis.setInverted(false); // Y�����귴ת,Ĭ����false,����С�ϴ�
//		yLineAxis.setSpaceTop(0); // Y������ඥ�ж��پ��룬������
//		yLineAxis.setSpaceBottom(0); // Y���������ж��پ��룬������
//		yLineAxis.setShowOnlyMinMax(false); // �������Ϊtrue Y������ֻ��ʾ���ֵ����Сֵ
//		yLineAxis.setLabelCount(10, false); // ��һ��������Y������ĸ������ڶ���������
//										// �Ƿ񲻾��ȷֲ���true�ǲ����ȷֲ�
//		yLineAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART); // ������INSIDE_CHART(Y���������ڲ�)
//																	// ��
//																	// OUTSIDE_CHART(���ⲿ��Ĭ���������)

		// add data
		lineChart.setData(lineData); // ��������

		// get the legend (only possible after setting data)
		Legend mLegend = lineChart.getLegend(); // ���ñ���ͼ��ʾ�������Ǹ�һ��y��value��

		// modify the legend ...
		// mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
		mLegend.setForm(LegendForm.CIRCLE);// ��ʽ
		mLegend.setFormSize(6f);// ����
		mLegend.setTextColor(Color.RED);// ��ɫ
		// mLegend.setTypeface(mTf);// ����

		lineChart.animateX(1000); // ����ִ�еĶ���,x��
	}

	/**
	 * ��������ͼ��������������
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
        LineDataSet set1 = new LineDataSet(yVals, "�ۼ�ͬ��������%��");  
  
//        set1.setDrawCubic(true);  //��������ΪԲ������  
        set1.setCubicIntensity(0.2f);  
        set1.setDrawFilled(false);  //���ð����ķ�Χ���������ɫ  
        set1.setDrawCircles(true);  //������Բ��  
        set1.setCircleColor(getResources().getColor(R.color.magenta)); //����Բ����ɫ
        set1.setCircleSize(5f);   //����Բ��Ĵ�С  
        set1.setLineWidth(2f);    //�����ߵĿ��  
        set1.setHighLightColor(Color.BLUE);  //��λʮ������ɫ
        set1.setColor(getResources().getColor(R.color.mediumorchid));    //�������ߵ���ɫ  
  
        // create a data object with the datasets  
        LineData data = new LineData(xVals, set1); 

		return data;
	}
	/**
	 * ��ʼ����״ͼ�������һЩ����
	 */
	private void showBarChart(BarChart barChart, BarData barData) {  
		
        barChart.setDrawBorders(false);  ////�Ƿ�������ͼ����ӱ߿�   
            
        barChart.setDescription("");// ��������      
          
        // ���û�����ݵ�ʱ�򣬻���ʾ���������ListView��EmptyView      
        barChart.setNoDataTextDescription("You need to provide data for the chart.");      
                 
        barChart.setDrawGridBackground(false); // �Ƿ���ʾ�����ɫ      
        barChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // ���ĵ���ɫ�����������Ǹ���ɫ����һ��͸����      
        
        barChart.setBackgroundColor(Color.WHITE);// ���ñ���
        
        barChart.setTouchEnabled(true); // �����Ƿ���Դ���      
       
        barChart.setDragEnabled(true);// �Ƿ������ק      
        barChart.setScaleEnabled(true);// �Ƿ��������      
      
        barChart.setPinchZoom(false);////���ô��طŴ�       
      
//      barChart.setBackgroundColor();// ���ñ���      
          
        barChart.setDrawBarShadow(true);  
        
         
        barChart.setData(barData); // ��������      
  
        Legend mLegend = barChart.getLegend(); // ���ñ���ͼ��ʾ  
      
        mLegend.setForm(LegendForm.CIRCLE);// ��ʽ      
        mLegend.setFormSize(6f);// ����      
        mLegend.setTextColor(Color.RED);// ��ɫ      
          
        // The Axis ��������ص�,XY��ͨ��
        xBarAxis.setPosition(XAxisPosition.BOTTOM); // ����X��������ڵײ���ʾ  
        xBarAxis.setEnabled(true); // �Ƿ���ʾX������ �� ��Ӧ�Ŀ̶����ߣ�Ĭ����true
        xBarAxis.setDrawAxisLine(false); // �Ƿ������������ߣ�����������������ߣ�Ĭ����true
        xBarAxis.setDrawGridLines(false); // �Ƿ���ʾX�������ϵĿ̶����ߣ�Ĭ����true
        xBarAxis.setDrawLabels(true); // �Ƿ���ʾX�������ϵĿ̶ȣ�Ĭ����true
        
        xBarAxis.setTextSize(5); // X���ϵĿ̶ȵ��ֵĴ�С ��λdp
        xBarAxis.setTypeface(Typeface.MONOSPACE); //X���ϵĿ̶ȵ�����
        xBarAxis.resetLabelsToSkip(); // ����/�����������������
        xBarAxis.setAvoidFirstLastClipping(true);//��֤��һ�������һ�����겻����
        
        xBarAxis.setAxisLineWidth(0.05f);
        yBarAxis.setAxisLineWidth(0.05f);
        
        barChart.animateX(1000); // ����ִ�еĶ���,x��    
    }  
	/**
	 * ������״ͼ���ӵ�������������
	 */
    private BarData getBarData(String[] xData,String[] yData ) {  
        //���ӵĿ�ȸ�����״ͼBarChart�ؼ��Ŀ�ȳ����������� ��ã�Ŀǰֻ�ҵ����Ӽ�϶��ȵ����÷���
  
        ArrayList<String> xValues = new ArrayList<String>();  
        for (int i = 0; i < xData.length; i++) {  
        	xValues.add(xData[i]);  
        }  
        xValues.add("");
        
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();  
  
        for (int i = 0; i < yData.length; i++) {  
        	yValues.add(new BarEntry(Float.parseFloat(yData[i]), i));  
        }  
          
        // y������ݼ���      
        BarDataSet barDataSet = new BarDataSet(yValues, "�����ۼƣ���Ԫ��");   
        barDataSet.setBarSpacePercent(40f);//��״֮��ļ��
        barDataSet.setBarShadowColor(Color.alpha(0x70FFFFFF));//���ӱ���ɫ����Ϊ͸��
        barDataSet.setColor(getResources().getColor(R.color.mediumorchid));//����ɫ 
       
        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();      
        barDataSets.add(barDataSet); // add the datasets  
      
        BarData barData = new BarData(xValues, barDataSets);  
        
        return barData;  
    }  

}

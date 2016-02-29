package com.jiangbei.detail;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jiangbei.R;
import com.jiangbei.util.Util;
/**
 * ��ϸ��Ϣ֮�����ʽ����
 * */
public class DetailListActivity extends Activity {
	public static DetailListActivity detailList;
	private TextView regionName;//��������
	private TableLayout tableLayout;  //��񲼾�����
	private String [][] listDataOne ={{"2015","54668","-3.4"},{"2014","46680","-5.4"},{"2013","66338","-1.4"},{"2012","86683","0.7"},{"2011","96683","1.3"}
	                                 ,{"2010","76847","2.7"},{"2009","25765","4.3"}};
	private String [][] listDataTwo ={{"2015","25765","1.4"},{"2014","28876","1.6"},{"2013","36338","2.4"},{"2012","46683","3.4"},{"2011","16683","-1.3"}
    ,{"2010","36847","1.9"},{"2009","15765","-0.3"}};
	private String [][] listDataThree ={{"2015","64964","-4.4"},{"2014","85464","-1.5"},{"2013","88475","0.4"},{"2012","24574","-3.7"},{"2011","32457","-1.3"}
    ,{"2010","97784","1.9"},{"2009","75474","0.7"}};
	private String [][] listDataFour ={{"2015","85747","-1.4"},{"2014","98415","-0.7"},{"2013","65458","-3.2"},{"2012","54717","2.7"},{"2011","49845","1.3"}
    ,{"2010","24674","-3.6"},{"2009","15458","-5.3"}};
	private String [][] listDataFive ={{"2015","360460","-3.7"},{"2014","256741","-2.8"},{"2013","195154","4.5"},{"2012","2561745","5.6"},{"2011","574145","8.3"}
    ,{"2010","120120","15.6"},{"2009","82515","9.6"}};
	private String [][] listDataSix ={{"2015","238370","-1.8"},{"2014","295812","5.4"},{"2013","156747","14.5"},{"2012","84175","8.9"},{"2011","72159","15.2"}
    ,{"2010","57981","5.3"},{"2009","55754","12.3"}};
	private String [][] listDataSeven ={{"2015","358002","3.1"},{"2014","309541","7.9"},{"2013","299475","24.5"},{"2012","164874","14.4"},{"2011","105571","25.2"}
    ,{"2010","75742","8.5"},{"2009","65741","22.8"}};
	private String [][] listDataEight ={{"2015","1887799","-3.0"},{"2014","2001471","30.5"},{"2013","1457894","40.9"},{"2012","915684","16.6"},{"2011","795512","36.8"}
    ,{"2010","498574","6.9"},{"2009","467521","23.1"}};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_list_activity);
		detailList = this;
		regionName = (TextView)findViewById(R.id.detail_form_header_two);
		tableLayout = (TableLayout) findViewById(R.id.detail_list_tablelayut);
		
		//��ʼ��������� 
		tableLayout.removeAllViews();
		for(int i=0;i<listDataOne.length;i++){
			changeRegionData(listDataOne[i]);
		}
	}
	/**
	 * ������ʾ�ӷ������б�
	 * */
	public void refresh(int regionNumber) {
		switch (regionNumber) {
		case 1:
			regionName.setText("����ֵ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataOne.length;i++){
				changeRegionData(listDataOne[i]);
			}
			break;
		case 2:
			regionName.setText("��ɳ�ֵ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataTwo.length;i++){
				changeRegionData(listDataTwo[i]);
			}
			break;
		case 3:
			regionName.setText("���ֵֽ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataThree.length;i++){
				changeRegionData(listDataThree[i]);
			}
			break;
		case 4:
			regionName.setText("�Ľֵ̽�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataFour.length;i++){
				changeRegionData(listDataFour[i]);
			}
			break;
		case 5:
			regionName.setText("𮽭�ֵ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataFive.length;i++){
				changeRegionData(listDataFive[i]);
			}
			break;
		case 6:
			regionName.setText("ׯ�Žֵ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataSix.length;i++){
				changeRegionData(listDataSix[i]);
			}
			break;
		case 7:
			regionName.setText("�����ֵ�");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataSeven.length;i++){
				changeRegionData(listDataSeven[i]);
			}
			break;
		case 8:
			regionName.setText("�ȳ���");
			tableLayout.removeAllViews();
			for(int i=0;i<listDataEight.length;i++){
				changeRegionData(listDataEight[i]);
			}
			break;
		default:
			break;
		}
	}
	/**
	 * �ӷ������б�����ˢ��
	 * */
	private void changeRegionData(String[] oneData)  
    {  
        TableRow tableRow = new TableRow(this);  
        
        TextView yearView = new TextView(this);
        int yearWidth = Util.DipToPx(this, 90);
        int yearHeight = Util.DipToPx(this, 35);
        int yearTop = Util.DipToPx(this, 5);
        TableRow.LayoutParams yearlayoutParam = new TableRow.LayoutParams(yearWidth, yearHeight);//���
        yearlayoutParam.setMargins(yearTop, yearTop, 0, 0);//�߾�
        yearView.setBackgroundResource(R.color.gray);
        yearView.setGravity(Gravity.CENTER);
        yearView.setTextSize(18);
        yearView.setText(oneData[0]);
        tableRow.addView(yearView,yearlayoutParam);
        
        TextView valueView = new TextView(this);
        int valueWidth = Util.DipToPx(this, 120);
        int valueHeight = Util.DipToPx(this, 35);
        int valueTop = Util.DipToPx(this, 5);
        TableRow.LayoutParams valuelayoutParam = new TableRow.LayoutParams(valueWidth, valueHeight);//���
        valuelayoutParam.setMargins(valueTop, valueTop, 0, 0);//�߾�
        valueView.setBackgroundResource(R.color.white);
        valueView.setGravity(Gravity.CENTER);
        valueView.setTextSize(18);
        valueView.setText(oneData[1]);
        tableRow.addView(valueView,valuelayoutParam);
        
        TextView sameView = new TextView(this);
        int sameWidth = Util.DipToPx(this, 100);
        int sameHeight = Util.DipToPx(this, 35);
        int sameTop = Util.DipToPx(this, 5);
        TableRow.LayoutParams samelayoutParam = new TableRow.LayoutParams(sameWidth, sameHeight);//���
        samelayoutParam.setMargins(sameTop, sameTop, 0, 0);//�߾�
        sameView.setBackgroundResource(R.color.white);
        sameView.setGravity(Gravity.CENTER);
        sameView.setTextSize(18);
        sameView.setText(oneData[2]);
        tableRow.addView(sameView,samelayoutParam);
          
        tableLayout.addView(tableRow);   
    }  

}

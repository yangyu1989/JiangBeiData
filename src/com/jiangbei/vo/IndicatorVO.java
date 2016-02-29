package com.jiangbei.vo;

/**
 * 标实体类
 * */
public class IndicatorVO {
	private String indicator_id;
	private String name;// 指标名称
	private String value;// 绝对量
	private String percent;// 同比增长
	private String level_id;// 等级
	private String type_id;// 类型
	private String indicator_desc;// 指标解释
	private String unit;// 单位
	private String platform_id;// 平台类型
	private String status;// 状态
	public String getIndicator_id() {
		return indicator_id;
	}
	public void setIndicator_id(String indicator_id) {
		this.indicator_id = indicator_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getLevel_id() {
		return level_id;
	}
	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getIndicator_desc() {
		return indicator_desc;
	}
	public void setIndicator_desc(String indicator_desc) {
		this.indicator_desc = indicator_desc;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

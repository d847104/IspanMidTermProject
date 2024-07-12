package com.ycw.bean;

import java.sql.Date;

public class AirBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String content;
    private Date publishtime;
    private String area;
    private String majorPollutant;
    private Date forecastDate;
    private int aqi;
    private String minorPollutant;
    private int minorPollutantAqi;
    private Date createtime;
    
	public void setId(int id) {	this.id = id;}
	public void setContent(String content) { this.content = content;}
	public void setPublishtime(Date publishtime) { this.publishtime = publishtime;}
	public void setArea(String area) { this.area = area;}
	public void setMajorPollutant(String majorPollutant) { this.majorPollutant = majorPollutant;}
	public void setForecastDate(Date forecastDate) { this.forecastDate = forecastDate;}
	public void setAqi(int aqi) { this.aqi = aqi;}
	public void setMinorPollutant(String minorPollutant) { this.minorPollutant = minorPollutant;}
	public void setMinorPollutantAqi(int minorPollutantAqi) { this.minorPollutantAqi = minorPollutantAqi;}
	public void setCreatetime(Date createtime) { this.createtime = createtime;}
	
	public int getId() { return id;}
	public String getContent() { return content;}
	public Date getPublishtime() { return publishtime;}
	public String getArea() { return area;}
	public String getMajorPollutant() { return majorPollutant;}
	public Date getForecastDate() {	return forecastDate;}
	public int getAqi() { return aqi;}
	public String getMinorPollutant() {	return minorPollutant;}
	public int getMinorPollutantAqi() {	return minorPollutantAqi;}
	public Date getCreatetime() { return createtime;}
}
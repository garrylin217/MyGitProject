package model;

import java.sql.*;

public class myStock {

	public Integer myId;
	public Date myDate;
	public String stockID;
	public String stockName;
	public String groupName;
	public String techFeature ;
	public String chipFeature ;
	public String eventFeature ;
	public String newsFeature ;
	public double todayOpen;
	public double todayClose;
	public double yesterdayOpen;
	public double yesterdayClose;
    public String keyBrokers;
    public String myContext;
    public String myComment;
	public myStock(Integer myId, Date myDate, String stockID, String stockName, String groupName, String techFeature,
			String chipFeature, String eventFeature, String newsFeature, double todayOpen, double todayClose,
			double yesterdayOpen, double yesterdayClose, String keyBrokers, String myContext, String myComment) {
		super();
		this.myId = myId;
		this.myDate = myDate;
		this.stockID = stockID;
		this.stockName = stockName;
		this.groupName = groupName;
		this.techFeature = techFeature;
		this.chipFeature = chipFeature;
		this.eventFeature = eventFeature;
		this.newsFeature = newsFeature;
		this.todayOpen = todayOpen;
		this.todayClose = todayClose;
		this.yesterdayOpen = yesterdayOpen;
		this.yesterdayClose = yesterdayClose;
		this.keyBrokers = keyBrokers;
		this.myContext = myContext;
		this.myComment = myComment;
	}
	public Integer getMyId() {
		return myId;
	}
	public void setMyId(Integer myId) {
		this.myId = myId;
	}
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	public String getStockID() {
		return stockID;
	}
	public void setStockID(String stockID) {
		this.stockID = stockID;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTechFeature() {
		return techFeature;
	}
	public void setTechFeature(String techFeature) {
		this.techFeature = techFeature;
	}
	public String getChipFeature() {
		return chipFeature;
	}
	public void setChipFeature(String chipFeature) {
		this.chipFeature = chipFeature;
	}
	public String getEventFeature() {
		return eventFeature;
	}
	public void setEventFeature(String eventFeature) {
		this.eventFeature = eventFeature;
	}
	public String getNewsFeature() {
		return newsFeature;
	}
	public void setNewsFeature(String newsFeature) {
		this.newsFeature = newsFeature;
	}
	public double getTodayOpen() {
		return todayOpen;
	}
	public void setTodayOpen(double todayOpen) {
		this.todayOpen = todayOpen;
	}
	public double getTodayClose() {
		return todayClose;
	}
	public void setTodayClose(double todayClose) {
		this.todayClose = todayClose;
	}
	public double getYesterdayOpen() {
		return yesterdayOpen;
	}
	public void setYesterdayOpen(double yesterdayOpen) {
		this.yesterdayOpen = yesterdayOpen;
	}
	public double getYesterdayClose() {
		return yesterdayClose;
	}
	public void setYesterdayClose(double yesterdayClose) {
		this.yesterdayClose = yesterdayClose;
	}
	public String getKeyBrokers() {
		return keyBrokers;
	}
	public void setKeyBrokers(String keyBrokers) {
		this.keyBrokers = keyBrokers;
	}
	public String getMyContext() {
		return myContext;
	}
	public void setMyContext(String myContext) {
		this.myContext = myContext;
	}
	public String getMyComment() {
		return myComment;
	}
	public void setMyComment(String myComment) {
		this.myComment = myComment;
	}
	@Override
	public String toString() {
		return "myStock [myId=" + myId + ", myDate=" + myDate + ", stockID=" + stockID + ", stockName=" + stockName
				+ ", groupName=" + groupName + ", techFeature=" + techFeature + ", chipFeature=" + chipFeature
				+ ", eventFeature=" + eventFeature + ", newsFeature=" + newsFeature + ", todayOpen=" + todayOpen
				+ ", todayClose=" + todayClose + ", yesterdayOpen=" + yesterdayOpen + ", yesterdayClose="
				+ yesterdayClose + ", keyBrokers=" + keyBrokers + ", myContext=" + myContext + ", myComment="
				+ myComment + "]";
	}
	
    
    
    
    


    

}

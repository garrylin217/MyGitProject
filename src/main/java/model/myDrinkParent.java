package model;

import java.io.Serializable;

//啟始產品分類
//id 
//myDrinkParenNtame : 大分類產品名稱
//myDrinkParentDescription: 大分類產品說明
//myDrinkParentCategory : 大分類產產品描述
public class myDrinkParent implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer myDrinkParentid;
	private String  myDrinkParenNtame;
	private String  myDrinkParentDescription;
	private String  myDrinkParentCategory;
	 
	 
	 // 建構式 overloading
    public myDrinkParent() {};
	 
	public myDrinkParent(String myDrinkParenNtame, String myDrinkParentDescription, String myDrinkParentCategory) {

		this.myDrinkParenNtame = myDrinkParenNtame;
		this.myDrinkParentDescription = myDrinkParentDescription;
		this.myDrinkParentCategory = myDrinkParentCategory;
	}
	
	

	public Integer getMyDrinkParenid() {
		return myDrinkParentid;
	}

	public void setMyDrinkParenid(Integer myDrinkParenid) {
		this.myDrinkParentid = myDrinkParenid;
	}

	public String getMyDrinkParenNtame() {
		return myDrinkParenNtame;
	}
	public void setMyDrinkParenNtame(String myDrinkParenNtame) {
		this.myDrinkParenNtame = myDrinkParenNtame;
	}
	public String getMyDrinkParentDescription() {
		return myDrinkParentDescription;
	}
	public void setMyDrinkParentDescription(String myDrinkParentDescription) {
		this.myDrinkParentDescription = myDrinkParentDescription;
	}
	public String getMyDrinkParentCategory() {
		return myDrinkParentCategory;
	}
	public void setMyDrinkParentCategory(String myDrinkParentCategory) {
		this.myDrinkParentCategory = myDrinkParentCategory;
	}
	public String show() {
		return "myDrinkParenid="+this.myDrinkParentid+"\n"+this.getMyDrinkParenNtame()+"\n"+
				"myDrinkParentCategory="+this.myDrinkParentCategory+"myDrinkParentCategory="+
				this.myDrinkParentCategory;
	}
	
	
}

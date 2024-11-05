package model;

import java.io.Serializable;

public class myDrink1 implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer drinkid;
	private Integer mydrinkparentid;
	private String drinkname;
	private Integer drinkprice;
	private String drinkdescription;
	private String drinkcategory;
	
	
    public myDrink1() {}
	public myDrink1(int mydrinkparentid,
			 String drinkname, int drinkprice,
			 String drinkdescription,String drinkcategory ){
		
		
		this.mydrinkparentid = mydrinkparentid;
		this.drinkname = drinkname;
		this.drinkprice= drinkprice;
		this.drinkdescription = drinkdescription;
		this.drinkcategory= drinkcategory;
		
	}

	public Integer getDrinkid() {
		return drinkid;
	}

	public void setDrinkid(Integer drinkid) {
		this.drinkid = drinkid;
	}

	public Integer getMydrinkparentid() {
		return mydrinkparentid;
	}

	public void setMydrinkparentid(Integer mydrinkparentid) {
		this.mydrinkparentid = mydrinkparentid;
	}

	public String getDrinkname() {
		return drinkname;
	}

	public void setDrinkname(String drinkname) {
		this.drinkname = drinkname;
	}

	public Integer getDrinkprice() {
		return drinkprice;
	}

	public void setDrinkprice(Integer drinkprice) {
		this.drinkprice = drinkprice;
	}

	public String getDrinkdescription() {
		return drinkdescription;
	}

	public void setDrinkdescription(String drinkdescription) {
		this.drinkdescription = drinkdescription;
	}

	public String getDrinkcategory() {
		return drinkcategory;
	}

	public void setDrinkcategory(String drinkcategory) {
		this.drinkcategory = drinkcategory;
	}
	
	

}

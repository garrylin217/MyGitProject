package model;


public class myDrink {

private Integer drinkid;
private String drinkname;
private Integer drinkprice;
private String drinkdescription;
private String drinkcategory;


public myDrink() {}
public myDrink( Integer drinkid,String drinkname, int drinkprice,String drinkdescription,String drinkcategory ){
	this.drinkid= drinkid;
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

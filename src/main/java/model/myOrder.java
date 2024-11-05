package model;

import java.sql.Timestamp;


public class myOrder {
	
    private Integer orderid;        // 訂單id
    private Integer memberid;       // 會員id
    private Timestamp orderdatetime;  //訂單成立時間
    private Integer drinkid;         // 購買商品ID
    private String drinkname;
    private Integer orderqty;       //  購買數量
    private Integer drinkprice;      // 購買商品單價
    private Integer ordersum;       // 訂單總金額
    
     
	public myOrder() {
		// TODO Auto-generated constructor stub
	}


	public myOrder( Integer memberid, Timestamp  orderdatetime, Integer drinkid, Integer orderqty,
			 Integer drinkprice) {
		
		this.memberid = memberid;
		this.orderdatetime = orderdatetime;
		this.drinkid = drinkid;
		this.orderqty = orderqty;
		this.drinkprice = drinkprice;
		this.drinkname = "";
		this.ordersum = orderqty*drinkprice;
	}


	public String getDrinkname() {
		return drinkname;
	}


	public void setDrinkname(String drinkname) {
		this.drinkname = drinkname;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public Integer getMemberid() {
		return memberid;
	}


	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}


	public Timestamp  getOrderdatetime() {
		return orderdatetime;
	}


	public void setOrderdatetime(Timestamp dd) {
		this.orderdatetime = dd;
	}


	public Integer getDrinkid() {
		return drinkid;
	}


	public void setDrinkid(Integer drinkid) {
		this.drinkid = drinkid;
	}


	public Integer getOrderqty() {
		return orderqty;
	}


	public void setOrderqty(Integer orderqty) {
		this.orderqty = orderqty;
	//	setOrdersum();
		
	}


	public Integer getDrinkprice() {
		return drinkprice;
	}


	public void setDrinkprice(Integer drinkprice) {
		this.drinkprice = drinkprice;
	//	setOrdersum();
	}


	public Integer getOrdersum() {
		return this.orderqty*this.drinkprice;
	}


	public void setOrdersum() {
		this.ordersum = this.orderqty*this.drinkprice;
	}

    public String  show() {
    	return "訂單編號:" + this.orderid + "\t" + 
               "會員編號:" + this.memberid + "\t" +
    		   "訂單日期:" + this.orderdatetime + "\t" +
               "貨品號碼:" + this.drinkid + "\t" +
    		   "貨品數量:" + this.orderqty + "\t" +
               "貨品單價:" + this.drinkprice + "\t" +
    		   "總價:" + this.ordersum;
    }
    public String  show1() {
    	return 
               
    		    this.orderdatetime + "\t" +
               this.drinkname + "\t" +
    		   this.orderqty + "\t" +
               "單價:" + this.drinkprice + "\t" +
    		   "總價:" + this.ordersum;
    }
	
	
	
	

}

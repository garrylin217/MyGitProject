package model;

import java.sql.Timestamp;;


public class tmpMyOrder {
	
 
    private Timestamp orderdatetime;  //訂單成立時間  
    private String drinkname;
    private Integer orderqty;       //  購買數量
    private Integer drinkprice;      // 購買商品單價
    private Integer ordersum;       // 訂單總金額
    
     
	public tmpMyOrder() {
		// TODO Auto-generated constructor stub
	}


	public tmpMyOrder(  Timestamp  orderdatetime,String drinkname, Integer orderqty,
			 Integer drinkprice) {
		
		this.orderdatetime = orderdatetime;
		this.drinkname=drinkname;	 
		this.orderqty = orderqty;
		this.drinkprice = drinkprice;
		this.ordersum = orderqty*drinkprice;
	}
    public String  show() {
    	return 
               
    		   this.orderdatetime + "\t" +
               this.drinkname + "\t" +
    		   this.orderqty + "\t" +
               "單價:" + this.drinkprice + "\t" +
    		   "總價:" + this.ordersum;
    }
	
	
	
	

}

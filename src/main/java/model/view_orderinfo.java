package model;

import java.sql.Timestamp;


public class view_orderinfo {

		private Integer orderid;
		private Timestamp orderdatetime;
		private Integer memberid;
		private String membername;
		private String level;
		private Integer levelid;
		private Integer drinkid;
		private String drinkname;
		private Integer drinkprice;
		private Integer orderqty;
		private Integer ordersum;
		
		public view_orderinfo() {}

		public Integer getOrderid() {
			return orderid;
		}

		public void setOrderid(Integer orderid) {
			this.orderid = orderid;
		}

		public Timestamp  getOrderdatetime() {
			return orderdatetime;
		}

		public void setOrderdatetime(Timestamp  orderdatetime) {
			this.orderdatetime = orderdatetime;
		}

		public Integer getMemberid() {
			return memberid;
		}

		public void setMemberid(Integer memberid) {
			this.memberid = memberid;
		}

		public String getMembername() {
			return membername;
		}

		public void setMembername(String membername) {
			this.membername = membername;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public Integer getLevelid() {
			return levelid;
		}

		public void setLevelid(Integer levelid) {
			this.levelid = levelid;
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

		public Integer getOrderqty() {
			return orderqty;
		}

		public void setOrderqty(Integer orderqty) {
			this.orderqty = orderqty;
		}

		public Integer getOrdersum() {
			return ordersum;
		}

		public void setOrdersum(Integer ordersum) {
			this.ordersum = ordersum;
		}
		  public String  show() {
		    	return "訂單編號:" + this.orderid + "\t" + 
		               "會員編號:" + this.memberid + "\t" +
		               "會員名稱:" + this.membername + "\t" +	
		    		   "訂單日期:" + this.orderdatetime + "\t" +
		               "貨品號碼:" + this.drinkid + "\t" +
		    		   "貨品數量:" + this.orderqty + "\t" +
		               "貨品單價:" + this.drinkprice + "\t" +
		    		   "總價:" + this.ordersum;
		    }
		
				
	}

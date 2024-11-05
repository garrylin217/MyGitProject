package model;

public class discountlevel {

	    private Integer id;       //會員等級 1-金會員 2-銀會員 3-一般會員 0. 管理員 
		//會員等級 1-金會員 2-銀會員 3-一般會員 0. 管理員 
		private Double discount;  // 折數
		private String levelname; //等級名稱
		
		public discountlevel(){}
		public discountlevel( Double discount, String levelname) {
	
			
			this.discount = discount;
			this.levelname = levelname;
		}
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
	
		public Double getDiscount() {
			return discount;
		}
		public void setDiscount(Double discount) {
			this.discount = discount;
		}
		public String getLevelname() {
			return levelname;
		}
		public void setLevelname(String levelname) {
			this.levelname = levelname;
		}
		public String show() {
			return "會員等級="+this.id+"\n" +
				   "會員折數="+this.discount+"\n" +
				   "等級名稱="+this.levelname+"\n" ;
		}
		
		
		
		

}

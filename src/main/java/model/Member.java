// model , 每個資料表要做一個class
package model;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  memberid;
	private String  membername;
	private String  username;
	private String  password;
	private String  phone;
	private String  level;  // 會員等級 1-金會員 2-銀會員 3-一般會員 0. 管理員
	private Integer levelid; //會員id
	
	public Member() {	
		// TODO Auto-generated constructor stub
	}


	public Member( String membername, String username, String password, String phone, String level,int levelid) {
		
		
		this.membername = membername;
		this.username = username;
		this.password = password;
		this.level = level;
		this.phone = phone;
		this.levelid = levelid;
	}



	public void setLevelid(Integer levelid) {
		this.levelid = levelid;
	}


	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", membername=" + membername + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", level=" + level + ", levelid=" + levelid + "]";
	}


	public int getLevelid() {
		return levelid;
	}


	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}


	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	
	
	

}
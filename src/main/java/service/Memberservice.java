package service;

import java.util.List;

import model.Member;


public interface Memberservice {
	
	
	List<Member> findAll();      //查詢	
	boolean findByMember(String username);
	void deleteMember(int id); //刪除
	void updateMember(Member m); //修改
	void addMember(String membername, String username, String password, String phone);
	void addMember(String membername, String username, String password, String phone, String level, Integer levelid);
	public boolean memberlogin(String username,String password);
	List<Member> selectByUsername(String username);
	List<Member> selectById(int memberid);
}

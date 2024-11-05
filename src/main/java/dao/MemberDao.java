package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void add(Member m);//inject 	
	//read
	List<Member> selectAll();//查全部
	List<Member> selectById(int memberid);
	List<Member> selectByUsername(String username);
	
	
	//update
	void update(Member m);
	//delete
    void delete(int memberid);
    

}
package service.impl;


import java.util.ArrayList;
import java.util.List;



import dao.impl.MemberDaoImpl;
import model.Member;
import service.Memberservice;


public class MemberserviceImpl implements Memberservice{
	
	private static MemberDaoImpl mdi=new MemberDaoImpl();  // 使用 DaoImpl 類別來存取資料表
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	 MemberserviceImpl ml = new MemberserviceImpl();	 
//	 System.out.println(ml.findByMember("aaa"));
//	 ml.addMember("ggyy11", "ggyy111", "ccc111","12345");
	//	System.out.println(new MemberserviceImpl().memberlogin("111vivian","111"));
/*
		MemberserviceImpl ml = new MemberserviceImpl();
		List<Member> l = ml.selectByUsername("vivian");
	    if (! l.isEmpty())  {
			Member m = new Member();
					m= l.get(0);
					System.out.println(m.getLevel());
					System.out.println(m.getLevelid());
			
		}
	*/	 
//	}

	
	@Override
	public void addMember(String membername,String username,String password,String phone)
	  {
		Member m=new Member(membername,username,password,phone,"一般會員",3);
		
		// TODO Auto-generated method stub
		
		mdi.add(m);
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		List <Member> l  = new ArrayList<Member>();
				l = mdi.selectAll()		;
				return l;
	}

	@Override
	public void deleteMember(int m) {
		mdi.delete(m);
		
	}

	@Override
	public void updateMember(Member m) {
		// TODO Auto-generated method stub
		mdi.update(m);
	}

	@Override
	public void addMember(String membername, String username, String password, String phone, String level,
			Integer levelid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean findByMember(String username) {
		
			List<Member> l=mdi.selectByUsername(username);
			boolean x=false;
			if (! l.isEmpty()) 
			{
				x=true;
			}
			
			return x;
		}


	public boolean memberlogin(String username, String password) {
		List<Member> l =  mdi.selectByUsername(username);
		if(!l.isEmpty()) {
			if (l.get(0).getPassword().equals(password))
		      return true;
		}
		return false; 
	}


	@Override
	public List<Member> selectByUsername(String username) {
		List<Member> l =  mdi.selectByUsername(username);
		return l;
	}

	@Override
	public List<Member> selectById(int memberid) {
		// TODO Auto-generated method stub
		List<Member> l =mdi.selectById(memberid);
		return l;
	}

	}
	



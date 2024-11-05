package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
	//新增測試
	//	  Member a = new Member("GARRY","garrylin","12345","0936481939","系統管理員",1);
	//	  System.out.println(a.getMembername());
	  
		//  new MemberDaoImpl().add(a);
		 
		
		/*查詢測試
		 List<Member> l=new MemberDaoImpl().selectAll();//selectById(3) ,selectMember("abc", "44"); ,selectByUsername("aa")
		
		for(Member m:l)
		{
			System.out.println(m.getMemberid()+"\t"+m.getMembername()+"\t"+m.getPassword());
		}
		*/
		
		//update測試
		
	//	  List<Member> l=
	//		new MemberDaoImpl().selectByUsername("llllllllllllllll");
	//      if (! l.isEmpty()) 
	//      {
	//	    Member m=l.get(0);
	//	    System.out.println(m.getMembername());
	//	    System.out.println(m.getUsername());
	//	    System.out.println(m.getPassword());
	//      }
		 
	//	Member m = new Member("Gxxx","abc","abc","abc","高雄");
	//	 m.setMemberid(3);
	//     m.setMembername("林永金");		  
	//   	new MemberDaoImpl().update(m);
		 
		
		//delete測試		
		//new MemberDaoImpl().delete(3);
		  
		 
		
	}

	@Override
	public void add(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into member (membername,username,password,phone,level,levelid) "
				+ "values(?,?,?,?,?,?)";
	
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);			
			ps.setString(1, m.getMembername());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getLevel());
			ps.setInt(6, m.getLevelid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Member> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l=new ArrayList<Member>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m=new Member();
				m.setMemberid(rs.getInt("memberid"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setLevel(rs.getString("level"));
				m.setLevelid(rs.getInt("levelid"));
				l.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public List<Member> selectById(int memberid) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where memberid=?";
		List<Member> l=new ArrayList<Member>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, memberid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m=new Member();
				m.setMemberid(rs.getInt("memberid"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setLevel(rs.getString("level"));
				m.setLevelid(rs.getInt("levelid"));
				l.add(m);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where username=?";
		List<Member> l=new ArrayList<Member>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Member m=new Member();
				m.setMemberid(rs.getInt("memberid"));
				m.setMembername(rs.getString("membername"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setLevel(rs.getString("level"));
				m.setLevelid(rs.getInt("levelid"));
				l.add(m);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public void update(Member m) {
		Connection conn=DbConnection.getDb();
		String sQL="update member set membername=?,username=?,password=?,phone=?,level=?,levelid=? where memberid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getMembername());
			ps.setString(2, m.getUsername());
			ps.setString(3,m.getPassword());
			ps.setString(4,m.getPhone());
			ps.setString(5,m.getLevel());
			ps.setInt(6,m.getLevelid());
			ps.setInt(7,m.getMemberid());
		
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int memberid) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where memberid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, memberid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MyDrinkParentDao;
import model.myDrinkParent;

public class MyDrinkParentDaoImpl implements MyDrinkParentDao{

	public static void main(String[] args) {
		//新增測試
		// myDrinkParent m = new myDrinkParent("牛角堡","牛角堡","牛角堡");
		//  new MyDrinkParentDaoImpl().add(m);
		 
		
		//查詢測試
		/*
		 List<myDrinkParent> l=new MyDrinkParentDaoImpl().selectAll();
		
		for(myDrinkParent m:l)
		{
			System.out.println(m.show());
		}
		*/
	
		//List<myDrinkParent> l=new MyDrinkParentDaoImpl().selectById(5);
		//update測試
	
		//myDrinkParent m=l.get(0);
		
		//System.out.println(m.show());
		/* 
		myDrinkParent m = new myDrinkParent("牛角堡","牛堡","牛角堡");
		m.setMyDrinkParenid(9);		  
	    new MyDrinkParentDaoImpl().update(m);
		 */
		
		//delete測試
		
		/*
		  new MemberDaoImpl().delete(1);
		  
		 */
		
	}
	@Override
	public void add(myDrinkParent m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into myDrinkParent(myDrinkParenNtame,myDrinkParentDescription,myDrinkParentCategory) "
				+ "values(?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getMyDrinkParenNtame());
			ps.setString(2, m.getMyDrinkParentCategory());
			ps.setString(3, m.getMyDrinkParentDescription());			
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<myDrinkParent> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from myDrinkParent";
		List<myDrinkParent> l=new ArrayList<myDrinkParent>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			    myDrinkParent m=new myDrinkParent();
				m.setMyDrinkParenid(rs.getInt("mydrinkparentid"));
				m.setMyDrinkParenNtame(rs.getString("myDrinkParenNtame"));
				m.setMyDrinkParentCategory(rs.getString("myDrinkParentDescription"));
				m.setMyDrinkParentDescription(rs.getString("myDrinkParentCategory"));

				
				l.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}
	

	@Override
	public List<myDrinkParent> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from mydrinkparent where mydrinkparentid=?";
		List<myDrinkParent> l=new ArrayList<myDrinkParent>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
			System.out.println(rs.getInt("mydrinkparentid"));
			
				myDrinkParent m=new myDrinkParent();
				m.setMyDrinkParenid(rs.getInt("mydrinkparentid"));
				m.setMyDrinkParenNtame(rs.getString("myDrinkParenNtame"));
				m.setMyDrinkParentDescription(rs.getString("myDrinkParentDescription"));
				m.setMyDrinkParentCategory(rs.getString("myDrinkParentCategory"));
				l.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	

	@Override
	public void update(myDrinkParent m) {

			Connection conn=DbConnection.getDb();
			String SQL="update mydrinkparent set myDrinkParenNtame=?,myDrinkParentDescription=?,myDrinkParentCategory=? where mydrinkparentid=?";
			
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ps.setString(1,m.getMyDrinkParenNtame());
				ps.setString(2,m.getMyDrinkParentDescription());
				ps.setString(3,m.getMyDrinkParentCategory());	
				ps.setInt(4,m.getMyDrinkParenid());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<myDrinkParent> selectByDrinkParenNtame(String DrinkParenNtame) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from mydrinkparent where myDrinkParenNtame=?";
		List<myDrinkParent> l=new ArrayList<myDrinkParent>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, DrinkParenNtame);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
			
			System.out.println(rs.getInt("mydrinkparentid"));
			
				myDrinkParent m=new myDrinkParent();
				m.setMyDrinkParenid(rs.getInt("mydrinkparentid"));
				m.setMyDrinkParenNtame(rs.getString("myDrinkParenNtame"));
				m.setMyDrinkParentDescription(rs.getString("myDrinkParentDescription"));
				m.setMyDrinkParentCategory(rs.getString("myDrinkParentCategory"));
				l.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	}

	

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MyDrink1Dao;

import model.myDrink1;

public class MyDrink1DaoImpl implements MyDrink1Dao{



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 新增測試
		//myDrink1 m = new myDrink1(1,"香雞蛋",45,"香雞蛋","香雞蛋");
		//	  System.out.println(m.getDrinkname());
		//	  new MyDrink1DaoImpl().add(m);
			 
			
			//select all 測試
		    /*
			 List<myDrink1> l=new MyDrink1DaoImpl().selectAll();//selectById(3) ,selectMember("abc", "44"); ,selectByUsername("aa")
			
			for(myDrink1 m:l)
			{
				System.out.println(m.getMydrinkparentid()+"\t"+m.getDrinkname()+"\t"+m.getDrinkprice());
			}
	    		
			
			// selectById 測試
			
			  List<myDrink1> l=new MyDrink1DaoImpl().selectById(4);
			  myDrink1 m = new myDrink1();
		      m=l.get(0);
			  System.out.println(m.getDrinkname());
			  System.out.println(m.getDrinkprice());
*             
			
		///update測試	 
			 m.setDrinkprice(500);
			 new MyDrink1DaoImpl().update(m);
		*/ 
			
		//delete測試		
		//new MyDrink1DaoImpl().delete(10);
	}

	
	
	@Override
	public void add(myDrink1 m) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "insert into drinkitem" +
                     " (mydrinkparentid,drinkname,drinkprice,drinkdescription,drinkcategory) " +
                     " Values (?,?,?,?,?)";	
	//	System.out.println(SQL);
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
		
			ps.setInt(1,m.getMydrinkparentid());
			ps.setString(2,m.getDrinkname());
			ps.setInt(3,m.getDrinkprice());
			ps.setString(4,m.getDrinkdescription());
			ps.setString(5,m.getDrinkcategory());
			ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<myDrink1> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "select * from drinkitem order by mydrinkparentid,drinkid";
		List<myDrink1> l= new ArrayList<myDrink1>();
			
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				myDrink1 m = new myDrink1();
				m.setDrinkid(rs.getInt("drinkid"));
				m.setMydrinkparentid(rs.getInt("mydrinkparentid"));
				m.setDrinkname(rs.getString("drinkname"));
				m.setDrinkprice(rs.getInt("drinkprice"));
				m.setDrinkdescription(rs.getString("drinkdescription"));
				m.setDrinkcategory(rs.getString("drinkcategory"));	
				l.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<myDrink1> selectById(int myDrinkid) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from drinkitem where drinkid=?";
		List<myDrink1> l=new ArrayList<myDrink1>();
		
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1, myDrinkid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			myDrink1 m = new myDrink1();
			m.setDrinkid(rs.getInt("drinkid"));
			m.setMydrinkparentid(rs.getInt("mydrinkparentid"));
			m.setDrinkname(rs.getString("drinkname"));
			m.setDrinkprice(rs.getInt("drinkprice"));
			m.setDrinkdescription(rs.getString("drinkdescription"));
			m.setDrinkcategory(rs.getString("drinkcategory"));	
			l.add(m);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return l;
		
	
	}



	@Override
	public void update(myDrink1 m) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "update drinkitem set " +
                     " mydrinkparentid=?, "+
				     " drinkname=?,"+
                     " drinkprice=?, "+
				     " drinkdescription=?, "+
				     " drinkcategory=? where drinkid=?";
		try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1,m.getMydrinkparentid());
		ps.setString(2,m.getDrinkname());
		ps.setInt(3,m.getDrinkprice());
		ps.setString(4,m.getDrinkdescription());
		ps.setString(5,m.getDrinkcategory());
		ps.setInt(6,m.getDrinkid());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		         	
	}

	@Override
	public void delete(int drinkid) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="delete from drinkitem where drinkid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, drinkid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	@Override
	public List<myDrink1> selectByParentidAndDrinkName(int mydrinkparentid, String drinkname) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from drinkitem where mydrinkparentid=? and drinkname=?";
		List<myDrink1> l=new ArrayList<myDrink1>();
		
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1, mydrinkparentid);
		ps.setString(2, drinkname);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			myDrink1 m = new myDrink1();
			m.setDrinkid(rs.getInt("drinkid"));
			m.setMydrinkparentid(rs.getInt("mydrinkparentid"));
			m.setDrinkname(rs.getString("drinkname"));
			m.setDrinkprice(rs.getInt("drinkprice"));
			m.setDrinkdescription(rs.getString("drinkdescription"));
			m.setDrinkcategory(rs.getString("drinkcategory"));	
			l.add(m);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return l;
		
	
	}



	
}

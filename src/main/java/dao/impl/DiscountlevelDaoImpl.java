package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.DiscountlevelDao;
import model.discountlevel;



public class DiscountlevelDaoImpl implements DiscountlevelDao {

	
	public static void main(String[] args) {
		// 新增測試
		// discountlevel d = new discountlevel((double)0.3,"鐵質會員");
		//	  System.out.println(d.show());
		//	  new DiscountlevelDaoImpl().add(d);
			 
			
		//Select all 測試
		/*
		 List<discountlevel> l=new DiscountlevelDaoImpl().selectAll();
		 for(discountlevel d:l)
			{
				System.out.println(d.show());
			}
		 */	
		
		
			// selectById 測試
			  /*
		      List<discountlevel> l=new DiscountlevelDaoImpl().selectById(2);
		      discountlevel d = new discountlevel();
		      d=l.get(0);
			  System.out.println(d.show());
              */
			
		
		     //update測試
		     /*
			 d.setDiscount((Double)0.8);
			 new DiscountlevelDaoImpl().update(d);
			 System.out.println(d.show());
			 */
		
		     //delete測試		
		     //new MyDrink1DaoImpl().delete(10);
		
			
			
			
			
			
	}	
			

		
		



	@Override
	public void add(discountlevel d) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb()	;
		String SQL = "insert into discountlevel" +
	                 " (discount,levelname) " +
	                 " Values (?,?)";	
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			
			ps.setDouble(1,d.getDiscount());
			ps.setString(2,d.getLevelname());		
			ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public List<discountlevel> selectAll() {
		// TODO Auto-generated method stub
		Connection conn  = DbConnection.getDb();
		String SQL = "select * from discountlevel";
		List<discountlevel> l= new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				discountlevel d = new discountlevel();
				d.setId(rs.getInt("id"));
			
				d.setDiscount(rs.getDouble("discount"));
				d.setLevelname(rs.getString("levelname"));		
				l.add(d);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<discountlevel> selectById(int levelid) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from discountlevel where id=?";
		List<discountlevel> l=new ArrayList<discountlevel>();
		
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1, levelid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {			
			discountlevel d = new discountlevel();
			d.setId(rs.getInt("id"));
			d.setDiscount(rs.getDouble("discount"));
			d.setLevelname(rs.getString("levelname"));				
			l.add(d);	
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return l;
	}

	@Override
	public List<discountlevel> selectBylevelname(String levelname) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from discountlevel where levelname=?";
		List<discountlevel> l=new ArrayList<discountlevel>();
		
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setString(1, levelname);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {			
			discountlevel d = new discountlevel();
			d.setId(rs.getInt("id"));
			d.setDiscount(rs.getDouble("discount"));
			d.setLevelname(rs.getString("levelname"));				
			l.add(d);	
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return l;
	}
	@Override
	public void update(discountlevel d) {
		Connection conn = DbConnection.getDb();
		String SQL = "update discountlevel set " +
				     " discount=?,"+
                     " levelname=? where id=?";

		try {
		PreparedStatement ps=conn.prepareStatement(SQL);
	
		ps.setDouble(1,d.getDiscount());
		ps.setString(2,d.getLevelname());
		ps.setInt(3,d.getId());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="delete from discountlevel where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

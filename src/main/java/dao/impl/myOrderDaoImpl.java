package dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.myOrderDao;
import model.myOrder;
public class myOrderDaoImpl implements  myOrderDao{



	public static void main(String[] args) {
		// 新增測試
	//	 myOrder m = new myOrder(9,null,1,1000,100);
	//	  new myOrderDaoImpl().add(m);
		
		//select all 測試
		// List<myOrder> l=new myOrderDaoImpl().selectAll();
		//	for(myOrder m:l)
		//	{
		//		System.out.println(m.show());
		//	}
		
		// selectById 測試
		//  List<myOrder> l=new myOrderDaoImpl().selectById(4);
		//  myOrder m = new myOrder();
	    //  m=l.get(0);
        //  System.out.println(  m.show());
          
          
          
		//update測試	 
          
	//	 m.setOrderqty(200);
	//	 m.setDrinkprice(300);
	//	 new myOrderDaoImpl().update(m);
	 

	}

	@Override
	public void add(myOrder m) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "insert into myorder" +
                     " (memberid,drinkid,orderqty,drinkprice,ordersum) " +
                     " Values (?,?,?,?,?)";	
	//	System.out.println(SQL);
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
		
			ps.setInt(1,m.getMemberid());			
			ps.setInt(2,m.getDrinkid());
			ps.setInt(3,m.getOrderqty());
			ps.setInt(4,m.getDrinkprice());
			ps.setInt(5,m.getOrdersum());
			ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<myOrder> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "select * from myorder";
		List<myOrder> l= new ArrayList<myOrder>();
			
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			
				myOrder m = new myOrder();
				m.setOrderid(rs.getInt("orderid")); 
				m.setMemberid(rs.getInt("memberid"));
				m.setOrderdatetime(rs.getTimestamp("orderdatetime"));
				m.setDrinkid(rs.getInt("drinkid"));
				m.setOrderqty(rs.getInt("orderqty"));
				m.setDrinkprice(rs.getInt("drinkprice"));
				m.setOrdersum();	
				l.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}


	@Override
	public List<myOrder> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from myOrder where orderid=?";
		List<myOrder> l=new ArrayList<myOrder>();
		
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			myOrder m = new myOrder();
			m.setOrderid(rs.getInt("orderid"));
			m.setMemberid(rs.getInt("memberid"));
			m.setOrderdatetime(rs.getTimestamp("orderdatetime"));
			m.setDrinkid(rs.getInt("drinkid"));
			m.setOrderqty(rs.getInt("orderqty"));
			m.setDrinkprice(rs.getInt("drinkprice"));
			m.setOrdersum();	
			l.add(m);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return l;	
	
	}
	
	
	@Override
	public void update(myOrder m) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "update myorder set " +
                     " memberid=?, "+
				     " orderdatetime=?,"+
                     " drinkid=?, "+
				     " orderqty=?,"+
				     " drinkprice=?, "+
				     " ordersum=? where orderid=?";
		try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1,m.getMemberid());
		ps.setTimestamp(2,m.getOrderdatetime());
		ps.setInt(3,m.getDrinkid());
		ps.setInt(4,m.getOrderqty());
		ps.setInt(5,m.getDrinkprice());
		ps.setInt(6,m.getOrdersum());
		ps.setInt(7,m.getOrderid());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		         	
		
	}

	@Override
	public void delete(int orderid) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="delete from myorder where orderid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, orderid);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

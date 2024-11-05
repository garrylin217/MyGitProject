package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.view_orderinfoDao;
import model.view_mydrinkdata;
import model.view_orderinfo;

public class view_orderinfoImpl implements view_orderinfoDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Select all 測試
		
	//	 List<view_orderinfo> l=new view_orderinfoImpl().selectAll();
	//		for(view_orderinfo v:l)
	//		{
		
	//			System.out.println(v.show());
	//	}
	     	
		
	}

	@Override
	public List<view_orderinfo> selectAll() {
	
			// TODO Auto-generated method stub
			Connection conn = DbConnection.getDb();
			String SQL = "select * from view_orderinfo";
			List<view_orderinfo> l= new ArrayList<>();
				
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					view_orderinfo m = new view_orderinfo();
					m.setOrderid(rs.getInt("orderid"));
					m.setOrderdatetime(rs.getTimestamp("orderdatetime"));
					m.setMemberid(rs.getInt("memberid"));
					m.setMembername(rs.getString("membername"));
					m.setLevel(rs.getString("levelname"));
					m.setLevelid(rs.getInt("levelid"));
					m.setDrinkid(rs.getInt("drinkid"));
					m.setDrinkname(rs.getString("drinkname"));
					m.setDrinkprice(rs.getInt("drinkprice"));
					m.setOrderqty(rs.getInt("orderqty"));
					m.setOrdersum(rs.getInt("ordersum"));
				    l.add(m);			
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return l;
		}
}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.view_mydrinkdataDao;
import model.view_mydrinkdata;


public class view_mydrinkdataDaoImpl implements view_mydrinkdataDao{

/*
	public static void main(String[] args) {
		//Select all 測試
		
		 List<view_mydrinkdata> l=new view_mydrinkdataDaoImpl().selectByDrinkParenNtame("xxxxxx");
			for(view_mydrinkdata v:l)
			{
		
				System.out.println(v.show());
			}
	     	
		

	}
*/
	@Override
	public List<view_mydrinkdata> selectAll() {
	
			// TODO Auto-generated method stub
			Connection conn = DbConnection.getDb();
			String SQL = "select * from view_mydrinkdata ";
			List<view_mydrinkdata> l= new ArrayList<>();
				
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					view_mydrinkdata m = new view_mydrinkdata();
					m.setMyDrinkParentid(rs.getInt("mydrinkparentid"));
					m.setMyDrinkParentName(rs.getString("myDrinkParenNtame"));
					m.setMyDrinkParentDescription(rs.getString("myDrinkParentDescription"));
					m.setMyDrinkParentCategory(rs.getString("myDrinkParentCategory"));
					m.setDrinkId(rs.getInt("drinkid"));
					m.setDrinkName(rs.getString("drinkName"));
					m.setDrinkPrice(rs.getInt("drinkprice"));
					m.setDrinkDescription(rs.getString("drinkdescription"));
					m.setDrinkCategory(rs.getString("drinkcategory"));
				    l.add(m);			
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return l;
		}

	@Override
	public List<view_mydrinkdata> selectByDrinkParenNtame(String DrinkParenNtame) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "select * from view_mydrinkdata where myDrinkParenNtame=?";
		List<view_mydrinkdata> l= new ArrayList<>();
			
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,DrinkParenNtame);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				view_mydrinkdata m = new view_mydrinkdata();
				m.setMyDrinkParentid(rs.getInt("mydrinkparentid"));
				m.setMyDrinkParentName(rs.getString("myDrinkParenNtame"));
				m.setMyDrinkParentDescription(rs.getString("myDrinkParentDescription"));
				m.setMyDrinkParentCategory(rs.getString("myDrinkParentCategory"));
				m.setDrinkId(rs.getInt("drinkid"));
				m.setDrinkName(rs.getString("drinkName"));
				m.setDrinkPrice(rs.getInt("drinkprice"));
				m.setDrinkDescription(rs.getString("drinkdescription"));
				m.setDrinkCategory(rs.getString("drinkcategory"));
			    l.add(m);			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<view_mydrinkdata> selectById(int id) {
		Connection conn = DbConnection.getDb();
		String SQL = "select * from view_mydrinkdata where drinkid=?";
		List<view_mydrinkdata> l= new ArrayList<>();
			
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				view_mydrinkdata m = new view_mydrinkdata();
				m.setMyDrinkParentid(rs.getInt("mydrinkparentid"));
				m.setMyDrinkParentName(rs.getString("myDrinkParenNtame"));
				m.setMyDrinkParentDescription(rs.getString("myDrinkParentDescription"));
				m.setMyDrinkParentCategory(rs.getString("myDrinkParentCategory"));
				m.setDrinkId(rs.getInt("drinkid"));
				m.setDrinkName(rs.getString("drinkName"));
				m.setDrinkPrice(rs.getInt("drinkprice"));
				m.setDrinkDescription(rs.getString("drinkdescription"));
				m.setDrinkCategory(rs.getString("drinkcategory"));
			    l.add(m);							
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}


	}



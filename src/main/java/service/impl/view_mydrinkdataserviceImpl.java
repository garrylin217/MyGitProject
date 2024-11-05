package service.impl;

import java.util.List;

import model.view_mydrinkdata;
import service.view_mydrinkdataservice;
import dao.impl.view_mydrinkdataDaoImpl;

public class view_mydrinkdataserviceImpl implements view_mydrinkdataservice{
	private static view_mydrinkdataDaoImpl vmd=
		new view_mydrinkdataDaoImpl();  // 使用 DaoImpl 類別來存取資料表
/*	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<view_mydrinkdata> l = 
		new view_mydrinkdataserviceImpl().selectByDrinkParenNtame("漢堡類");
		for(view_mydrinkdata v:l)
		{
	
			System.out.println(v.show());
		}
	}
*/
	@Override
	public List<view_mydrinkdata> selectAll() {
		// TODO Auto-generated method stub
		return vmd.selectAll();
	}

	@Override
	public List<view_mydrinkdata> selectByDrinkParenNtame(String DrinkParenNtame) {
		// TODO Auto-generated method stub
		return vmd.selectByDrinkParenNtame(DrinkParenNtame);
	}

	@Override
	public List<view_mydrinkdata> selectById(int id) {
		// TODO Auto-generated method stub
		return vmd.selectById(id);
	}

}

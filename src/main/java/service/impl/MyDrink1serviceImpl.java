package service.impl;

import java.util.List;

import dao.impl.MyDrink1DaoImpl;
import model.myDrink1;
import service.MyDrink1service;

public class MyDrink1serviceImpl implements MyDrink1service {
	
	private static MyDrink1DaoImpl mdi=new MyDrink1DaoImpl();  // 使用 DaoImpl 類別來存取資料表
	
//	public static void main(String[] args) {
		
		
		
		//select all 測試
	    /*
		 List<myDrink1> l=new MyDrink1serviceImpl().selectAll();
		
		for(myDrink1 m:l)
		{
			System.out.println(m.getMydrinkparentid()+"\t"+m.getDrinkname()+"\t"+m.getDrinkprice());
		}
		*/
//	}

	@Override
	public void add(myDrink1 m) {
		// TODO Auto-generated method stub
		mdi.add(m);
	}

	@Override
	public List<myDrink1> selectAll() {
		// TODO Auto-generated method stub
		return mdi.selectAll();
	}

	@Override
	public List<myDrink1> selectById(int id) {
		// TODO Auto-generated method stub
		return mdi.selectById(id);
	}

	@Override
	public void update(myDrink1 m) {
		// TODO Auto-generated method stub
		mdi.update(m);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mdi.delete(id);
	}

	@Override
	public List<myDrink1> selectByParentidAndDrinkName(int id, String drinkname) {
		// TODO Auto-generated method stub
		return mdi.selectByParentidAndDrinkName(id, drinkname);
	}



	}


	



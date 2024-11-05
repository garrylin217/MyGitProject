package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.MyDrinkParentDaoImpl;
import model.myDrinkParent;
import service.myDrinkParentservice;

public class myDrinkParentserviceImpl implements myDrinkParentservice{
	private static MyDrinkParentDaoImpl mdi=new MyDrinkParentDaoImpl();  // 使用 DaoImpl 類別來存取資料表
	
	//public static void main(String[] args) {
		//select all
	/*
		myDrinkParent mm = new myDrinkParent();
		List <myDrinkParent> l = new myDrinkParentserviceImpl().selectByDrinkParenNtame("xxxxxxabc");
		mm= l.get(0);
	    mm.setMyDrinkParenNtame("GGYYGGYGGYY");
	    mm.setMyDrinkParentCategory("Good News");
	    mdi.update(mm);
	*/	
	//}

	@Override
	public void add(myDrinkParent m) {
		// TODO Auto-generated method stub
		mdi.add(m);
	}

	@Override
	public List<myDrinkParent> selectAll() {
		// TODO Auto-generated method stub
		List <myDrinkParent> l  = new ArrayList<myDrinkParent>();
		l = mdi.selectAll()	;	
		return l;
	}
	

	@Override
	public List<myDrinkParent> selectById(int id) {
		// TODO Auto-generated method stub
		return mdi.selectById(id);
	}

	@Override
	public void update(myDrinkParent m) {
		// TODO Auto-generated method stub
		mdi.update(m);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<myDrinkParent> selectByDrinkParenNtame(String DrinkParenNtame) {
		// TODO Auto-generated method stub
		return mdi.selectByDrinkParenNtame(DrinkParenNtame);
	}

}

package service.impl;

import java.util.List;

import dao.impl.DiscountlevelDaoImpl;

import model.discountlevel;
import service.Discountlevelservice;


public class DiscountlevelserviceImpl implements  Discountlevelservice {
   
	private static DiscountlevelDaoImpl dldi = new DiscountlevelDaoImpl();  // 使用 DaoImpl 類別來存取資料表
	public static void main(String[] args) {
		System.out.println(new DiscountlevelserviceImpl().selectBylevelname("金質會員").get(0).getId());
	}
	@Override
	public void add(discountlevel d) {
		// TODO Auto-generated method stub
		dldi.add(d);
	}
	@Override
	public List<discountlevel> selectAll() {
		// TODO Auto-generated method stub
		return dldi.selectAll();
	}
	@Override
	public List<discountlevel> selectById(int id) {
		// TODO Auto-generated method stub
		return dldi.selectById(id);
	}
	@Override
	public List<discountlevel> selectBylevelname(String levelname) {
		// TODO Auto-generated method stub
		return dldi.selectBylevelname(levelname);
	}
	@Override
	public void update(discountlevel m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dldi.delete(id);
	}


}

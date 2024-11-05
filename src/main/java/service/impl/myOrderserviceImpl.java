package service.impl;

import java.util.List;


import dao.impl.myOrderDaoImpl;
import model.myOrder;
import service.myOrderservice;

public class myOrderserviceImpl implements myOrderservice{
	private static myOrderDaoImpl modi=new myOrderDaoImpl();  // 使用 DaoImpl 類別來存取資料表

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	}

	@Override
	public List<myOrder> selectAll() {
		// TODO Auto-generated method stub
		return modi.selectAll();
	}

	@Override
	public List<myOrder> selectById(int id) {
		// TODO Auto-generated method stub
		return modi.selectById(id);
	}

	@Override
	public void update(myOrder m) {
		// TODO Auto-generated method stub
		modi.update(m);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		modi.delete(id);
	}

	@Override
	public void add(myOrder m) {
		// TODO Auto-generated method stub
		modi.add(m);
	}

}

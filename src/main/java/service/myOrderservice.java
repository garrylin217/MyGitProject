package service;

import java.util.List;

import model.myOrder;

public interface myOrderservice {
	
	
	void add(myOrder m);   //inject 	
	//read

	List<myOrder> selectAll();//查全部
	List<myOrder> selectById(int id);	
	//update
	void update(myOrder m);
	//delete
    void delete(int id);
	
}

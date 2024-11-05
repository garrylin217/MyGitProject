package dao;

import java.util.List;


import model.discountlevel;


public interface DiscountlevelDao {
	//create
	void add(discountlevel d);//inject 	
	//read
	List<discountlevel> selectAll();  //查全部
	List<discountlevel> selectById(int id);
	List<discountlevel> selectBylevelname(String levelname);
	//update
	void update(discountlevel m);
	//delete
    void delete(int id);
    
}

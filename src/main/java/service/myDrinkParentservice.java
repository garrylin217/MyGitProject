package service;

import java.util.List;

import model.myDrinkParent;

public interface myDrinkParentservice{
	
	//create
	void add(myDrinkParent m);//inject 	
	//read
	List<myDrinkParent> selectAll();//查全部
	List<myDrinkParent> selectById(int id);

	void update(myDrinkParent m);
	//delete
    void delete(int id);
	List<myDrinkParent> selectByDrinkParenNtame(String DrinkParenNtame);

}

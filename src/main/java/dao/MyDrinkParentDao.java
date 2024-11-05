package dao;

import java.util.List;

import model.myDrinkParent;

public interface MyDrinkParentDao {
	//create
	void add(myDrinkParent m);//inject 	
	//read
	List<myDrinkParent> selectAll();//查全部
	List<myDrinkParent> selectById(int id);
	List<myDrinkParent> selectByDrinkParenNtame(String DrinkParenNtame);
	void update(myDrinkParent m);
	//delete
    void delete(int id);
}

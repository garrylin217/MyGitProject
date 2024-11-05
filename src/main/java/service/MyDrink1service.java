package service;

import java.util.List;

import model.myDrink1;

public interface MyDrink1service {

	//create
	void add(myDrink1 m);   //inject 	
	//read
	List<myDrink1> selectAll();//查全部
	List<myDrink1> selectById(int id);
	//update
	void update(myDrink1 m);
	//delete
    void delete(int id);
	List<myDrink1> selectByParentidAndDrinkName(int id,String drinkname);
	
	
}

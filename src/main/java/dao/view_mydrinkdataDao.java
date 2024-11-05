package dao;

import java.util.List;

import model.view_mydrinkdata;


public interface view_mydrinkdataDao {
	//read
	List<view_mydrinkdata> selectAll();//查全部
	List<view_mydrinkdata> selectByDrinkParenNtame(String DrinkParenNtame);
	List<view_mydrinkdata> selectById(int id);
}

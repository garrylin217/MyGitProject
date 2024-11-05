package model;

import java.util.ArrayList;
import java.util.List;

public class ParentCategory {
    private Integer parentId;           // 父分類 ID
    private String parentName;          // 父分類名稱
    private String parentDescription;   // 父分類描述
    private String parentCategory;      // 父分類種類
    private List<myDrink> drinks;       // 父分類下的飲料列表

    // 帶參數的建構子，初始化父分類和飲料列表
    public ParentCategory(Integer parentId, String parentName, String parentDescription, String parentCategory) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.parentDescription = parentDescription;
        this.parentCategory = parentCategory;
        this.drinks = new ArrayList<>();
    }


    public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getParentDescription() {
		return parentDescription;
	}


	public void setParentDescription(String parentDescription) {
		this.parentDescription = parentDescription;
	}


	public String getParentCategory() {
		return parentCategory;
	}


	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}


	public List<myDrink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<myDrink> drinks) {
        this.drinks = drinks;
    }

    // 添加飲料到該父分類下
    public void addDrink(myDrink drink) {
        this.drinks.add(drink);
    }
}




package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DbConnection;

public class DrinkDAO {
	
	

    // 使用 view_mydrinkdata 查詢所有父類與對應的飲料
    public List<ParentCategory> getAllParentCategoriesWithDrinks() throws SQLException {
    	Connection conn = DbConnection.getDb();
        List<ParentCategory> parentCategories = new ArrayList<>();
        Map<Integer, ParentCategory> parentCategoryMap = new HashMap<>();

        String sql = "SELECT * FROM view_mydrinkdata;";

        try (conn;
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // 取得父類資料
                Integer parentId = rs.getInt("mydrinkparentid");
                ParentCategory parent = parentCategoryMap.get(parentId);

                if (parent == null) {
                    parent = new ParentCategory(
                        parentId,
                        rs.getString("myDrinkParenNtame"),
                        rs.getString("myDrinkParentDescription"),
                        rs.getString("myDrinkParentCategory")
                    );
                    parentCategories.add(parent);
                    parentCategoryMap.put(parentId, parent);
                }

                // 取得飲料資料（若有）
                Integer drinkId = rs.getInt("drinkid");
                if (drinkId != 0) {
                    myDrink drink = new myDrink(
                        drinkId,
                        rs.getString("drinkname"),
                        rs.getInt("drinkprice"),
                        rs.getString("drinkdescription"),
                        rs.getString("drinkcategory")
                    );
                    parent.addDrink(drink);
                }
            }
        }
        return parentCategories;
    }
}

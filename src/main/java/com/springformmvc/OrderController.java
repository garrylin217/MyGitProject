package com.springformmvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.DrinkDAO;
import model.ParentCategory;
import model.discountlevel;
import model.view_mydrinkdata;
import model.myOrder;  // 引入訂單模型
import service.impl.DiscountlevelserviceImpl;
import service.impl.view_mydrinkdataserviceImpl;
import service.impl.myOrderserviceImpl;  // 引入訂單服務實現

@Controller
public class OrderController {

    private view_mydrinkdataserviceImpl myDrinkDataService = new view_mydrinkdataserviceImpl();
    private DiscountlevelserviceImpl discountService = new DiscountlevelserviceImpl();
    private myOrderserviceImpl orderService = new myOrderserviceImpl(); // 添加訂單服務

    @GetMapping("/order")
    public String showOrderPage(Model model) throws SQLException {
        // 獲取所有父分類及其子分類（飲料）
        List<ParentCategory> parentCategories = new DrinkDAO().getAllParentCategoriesWithDrinks();
        model.addAttribute("parentCategories", parentCategories);
        return "order";
    }

    @PostMapping("/submitOrder")

    public String submitOrder(@RequestParam Map<String, String> params,                                                            
                              Model model) {
        double totalPrice = 0;
        double discount = 0;
        Integer memberId  =0;
        List<myOrder> orders = new ArrayList<>();
        System.out.println("Received parameters: " + params);

       
   
     
        for (Map.Entry<String, String> entry : params.entrySet()) {
        	String key = entry.getKey(); // 獲取鍵
            String value = entry.getValue(); // 獲取值
        	if (key.equalsIgnoreCase("userid")) {
        		memberId = Integer.parseInt(value); 
        		continue;
        	}
        	if (key.equalsIgnoreCase("discountCode")) {
        		discount = Double.parseDouble(value); 
        		continue;
        	}
        	if (isNumeric(key) && !key.equalsIgnoreCase("userid") && !key.equalsIgnoreCase("discountCode")){
            String drinkId = entry.getKey();
            int quantity = Integer.parseInt(entry.getValue());
           
            List<view_mydrinkdata> drinks = myDrinkDataService.selectById(Integer.parseInt(drinkId));
            if (!drinks.isEmpty()) {
                view_mydrinkdata drink = drinks.get(0);
                double drinkPrice = drink.getDrinkPrice();
                totalPrice += drinkPrice * quantity;

                myOrder order = new myOrder();
          
                order.setMemberid(memberId); 
                order.setOrderdatetime(new java.sql.Timestamp(System.currentTimeMillis()));
                order.setDrinkid(Integer.parseInt(drinkId));
                order.setDrinkname(drinks.get(0).getDrinkName());
                order.setOrderqty(quantity);
                order.setDrinkprice((int) drinkPrice);
                order.setOrdersum(); // 根據數量和價格計算總價
                orders.add(order);
          
            }
        	}
        }

        // 處理折扣
  
        double finalPrice = Math.round(totalPrice * discount * 1.0) / 1.0;
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("discount", discount);
        model.addAttribute("finalPrice", finalPrice);

        // 儲存訂單
        for (myOrder order : orders) {
            orderService.add(order);
            }
        
        model.addAttribute("orders", orders); // Adding orders to the model
        return "checkout"; // 重定向到結帳頁面
    }
    
 // 檢查字符串是否為數字的方法
    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}


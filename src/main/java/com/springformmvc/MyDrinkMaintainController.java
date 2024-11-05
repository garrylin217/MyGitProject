package com.springformmvc;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.*;

import service.impl.MyDrink1serviceImpl;
import service.impl.myDrinkParentserviceImpl;
import service.impl.view_mydrinkdataserviceImpl;


@Controller
@RequestMapping("/myDrink")
public class MyDrinkMaintainController {

  //  @Autowired
    private myDrinkParentserviceImpl myDrinkParentService = new myDrinkParentserviceImpl();

 //   @Autowired
    private view_mydrinkdataserviceImpl viewMyDrinkDataService = new view_mydrinkdataserviceImpl();

 // 顯示所有父分類
    @GetMapping("/parents")
    public String getAllParents(Model model) {
        List<myDrinkParent> parents = myDrinkParentService.selectAll();
        model.addAttribute("parents", parents);
        return "parents"; // parents.jsp
    }

    @GetMapping("/drinks")
    public String  getDrinksByParent(@RequestParam String parentName, @RequestParam Integer parentid, Model model) {
        List<view_mydrinkdata> drinks = viewMyDrinkDataService.selectByDrinkParenNtame(parentName);
        model.addAttribute("drinks", drinks);  
        model.addAttribute("selectedParentId",  parentid);
        model.addAttribute("selectedParent", parentName);        
        return "drinkss"; // drinks.jsp
    }
    
    

    
    /*
    // 依據父分類名稱查詢對應的子分類，並回傳為 JSON 格式
    @GetMapping("/drinks")
    @ResponseBody
    public List<view_mydrinkdata> getDrinksByParent(@RequestParam String parentName) {
        return viewMyDrinkDataService.selectByDrinkParenNtame(parentName);
    }
    
    */
    // 新增父分類頁面
    @GetMapping("/parent/add")
    public String addParentForm(Model model) {
        model.addAttribute("parent", new myDrinkParent());
        return "addParent"; // addParent.jsp
    }

    // 新增父分類資料
    @PostMapping("/parent/add")
    public String saveParent(@ModelAttribute myDrinkParent parent) {
    	
        new myDrinkParentserviceImpl().add(parent);
        
        
        return "redirect:/myDrink/parents";
    }

    // 刪除父分類
    @GetMapping("/parent/delete/{id}")
    public String deleteParent(@PathVariable int id) {
        myDrinkParentService.delete(id);
        return "redirect:/myDrink/parents";
    }

        // 新增子分類資料
    @PostMapping("/drink/add")
    public String saveDrink(@ModelAttribute myDrink1 drink, Model model) {
        new  MyDrink1serviceImpl().add(drink);
        
        model.addAttribute("drinks", drink);  
        List<myDrinkParent>  mm =
        		new myDrinkParentserviceImpl().selectById(drink.getMydrinkparentid());
     //   return "redirect:/myDrink/parents";
           System.out.println("redirect:/myDrink/drinks?parentName=" +drink.getMydrinkparentid()  +  "&parentid=" + mm.get(0).getMyDrinkParenNtame());
           return "redirect:/myDrink/drinks?parentid=" + drink.getMydrinkparentid() 
           + "&parentName=" + URLEncoder.encode(mm.get(0).getMyDrinkParenNtame(), StandardCharsets.UTF_8);

    }

    // 刪除子分類
    @GetMapping("/drink/delete/{id}")
    public String deleteDrink(@PathVariable int id) {
        new MyDrink1serviceImpl().delete(id);
        return "redirect:/myDrink/parents";
    }
    
 // 顯示編輯子分類頁面
    @GetMapping("/drink/edit/{id}")
    public String editDrinkForm(@PathVariable int id, Model model) {
        // 根據 ID 取得子分類資料
    	
    	List<view_mydrinkdata>  drink = new view_mydrinkdataserviceImpl().selectById(id);
        if (drink == null) {
            throw new RuntimeException("Drink with ID " + id + " not found.");
        }

        // 將父分類列表傳入供選擇
        List<myDrinkParent> parents = new myDrinkParentserviceImpl().selectAll();

        model.addAttribute("drink", drink.get(0)); // 傳入子分類資料
        model.addAttribute("parents", parents); // 傳入父分類列表
        return "editDrink"; // 對應的 JSP 檔案：editDrink.jsp
    }

    // 接收更新後的子分類資料
    @PostMapping("/drink/update")
    public String updateDrink(@ModelAttribute view_mydrinkdata drink) {
        // 更新資料庫中的子分類資料
    	myDrink1 mm1= new myDrink1(drink.getMyDrinkParentid(),
    			                                                 drink.getDrinkName(),
    			                                                 drink.getDrinkPrice(),
    			                                                 drink.getDrinkDescription(),
    			                                                 drink.getDrinkCategory());
    	
		

		
    	mm1.setDrinkid(drink.getDrinkId());
    	new  MyDrink1serviceImpl().update(mm1);

        // 根據更新後的父分類重新導向到對應的子分類頁面
        List<myDrinkParent> mm = 
                new myDrinkParentserviceImpl().selectById(mm1.getMydrinkparentid());

        String encodedParentName = URLEncoder.encode(mm.get(0).getMyDrinkParenNtame(), StandardCharsets.UTF_8);
System.out.println("redirect:/myDrink/drinks?parentid=" + mm1.getMydrinkparentid() 
               + "&parentName=" + encodedParentName);
        return "redirect:/myDrink/drinks?parentid=" + mm1.getMydrinkparentid() 
               + "&parentName=" + encodedParentName;
    }
    
}

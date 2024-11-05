package com.springformmvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.discountlevel;
import service.impl.DiscountlevelserviceImpl;

import java.util.List;

@Controller
@RequestMapping("/discountLevels")
public class DiscountLevelController {

  //  @Autowired
    private DiscountlevelserviceImpl dl = new  DiscountlevelserviceImpl();

 // 顯示所有discount
    @GetMapping("/showall")
    public String getAllParents(Model model) {
        List<discountlevel>alldl = dl.selectAll();
        model.addAttribute("discountLevels", alldl);
        return "discountLevels"; // parents.jsp
    }
    
    @GetMapping
    public String listDiscountLevels(Model model) {
        List<discountlevel> discountLevels = dl.selectAll();
        model.addAttribute("discountLevels", discountLevels);
        return "discountLevels";  // 返回 discountLevels.jsp 视图
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("discountLevel", new discountlevel());
        return "createDiscountLevel";  // 返回 createDiscountLevel.jsp 视图
    }

    @PostMapping
    public String createDiscountLevel(@ModelAttribute discountlevel discountLevel) {
        dl.add(discountLevel);
        return "redirect:/discountLevels";  // 创建后重定向到列表页面
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        List<discountlevel> discountLevels = dl.selectById(id);
        if (!discountLevels.isEmpty()) {
            model.addAttribute("discountLevel", discountLevels.get(0));
            
            return "editDiscountLevel";  // 返回 editDiscountLevel.jsp 视图
        } else {
            return "redirect:/discountLevels";  // 找不到时重定向
        }
    }

    @PostMapping("/update/{id}")
    public String updateDiscountLevel(@PathVariable Integer id, @ModelAttribute  discountlevel discountLevel) {
        discountLevel.setId(id);
        dl.update(discountLevel);
        return "redirect:/discountLevels";  // 更新后重定向到列表页面
    }

    @GetMapping("/delete/{id}")
    public String deleteDiscountLevel(@PathVariable Integer id) {
        dl.delete(id);
        return "redirect:/discountLevels";  // 删除后重定向到列表页面
    }
}

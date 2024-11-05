package com.springformmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import model.*;
import service.impl.*;
import java.util.*;


@Controller
public class ManagePageController {

    @GetMapping("/manage")
    public ModelAndView managePage() {
        ModelAndView mav = new ModelAndView("managePage");
        return mav;
    }

    @GetMapping("/memberManage")
    public ModelAndView memberManage() {
    	List<Member> l = new MemberserviceImpl().findAll();

  //       Member member = l.isEmpty() ? null : members.get(0); // 獲取第一個會員作為示例

         ModelAndView mav = new ModelAndView("memberManage");
         mav.addObject("members", l); // 將會員列表加入模型
     //    mav.addObject("member", l); // 將特定會員物件加入模型
    	
    	
        
        return mav;
    }

    @GetMapping("/productManage")
    public ModelAndView productManage() {
        ModelAndView mav = new ModelAndView("productManage");
        return mav;
    }


}

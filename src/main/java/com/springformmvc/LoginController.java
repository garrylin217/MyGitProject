package com.springformmvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Member;
import service.impl.DiscountlevelserviceImpl;
import service.impl.MemberserviceImpl;

import org.springframework.ui.Model;

@Controller
public class LoginController {
	
    @GetMapping("/login")
    public String login() {
        return "login"; // 返回 login.jsp
    }
   
    @PostMapping("/login")
    public String loginPost( @RequestParam String username, @RequestParam String password,Model model,HttpSession session)
 {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String currentDate = sdf.format(new Date());
        // 簡單的驗證邏輯
        MemberserviceImpl msi = new MemberserviceImpl();
        List<Member> l = msi.selectByUsername(username);

        if (!l.isEmpty()) {
            Member m = l.get(0);
            if (m.getPassword().equals(password)) {
            	DiscountlevelserviceImpl dl = new DiscountlevelserviceImpl();
            	double dd  = dl.selectById(m.getLevelid()).get(0).getDiscount();
            	String dln =  dl.selectById(m.getLevelid()).get(0).getLevelname();
                // 將用戶資訊存入 Session
            	session.setAttribute("userid",m.getMemberid());
                session.setAttribute("user", m.getMembername());
                session.setAttribute("levelId", dln);
                session.setAttribute("discountValue", dd );
                


                // 設定 session 屬性
                session.setAttribute("message",currentDate+ "   歡迎光臨 ! " +m.getMembername() + "   會員等級為: " + dln + "     購買折扣: " + dd );
               

                // 根據 levelId 分別導向不同頁面
                if (m.getLevelid() == 1) {
                    return "managePage"; // 管理頁面
                } else {
                    return "redirect:/order"; // 重導到訂單頁
                }
            } else {
                model.addAttribute("error", "使用者名稱或密碼錯誤");
                return "login"; // 返回登入頁面
            }
        }
        model.addAttribute("error", "使用者名稱或密碼錯誤");
        return "login";
    }
   
    
    }





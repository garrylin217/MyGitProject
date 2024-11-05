package com.springformmvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 清除所有的 Session 資料
        session.invalidate();
        // 重導到登入頁面
        return "redirect:/login";
    }
}
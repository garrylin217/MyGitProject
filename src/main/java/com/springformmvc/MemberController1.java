package com.springformmvc;

import model.Member;
import service.impl.MemberserviceImpl;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController1 {

  //  @Autowired
    private MemberserviceImpl m =  new MemberserviceImpl();

    @GetMapping("/members")
    public String listMembers(Model model) {
        List<Member> members = m.findAll();
        model.addAttribute("members", members);
        return "memberList"; // 對應的 JSP 檔案
    }
}
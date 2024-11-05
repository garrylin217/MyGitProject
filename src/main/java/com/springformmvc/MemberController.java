package com.springformmvc;

import java.util.List;
import model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.impl.MemberserviceImpl;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class MemberController {

    private final MemberserviceImpl memberService = new MemberserviceImpl();

    // 顯示註冊頁面
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    // 處理註冊
    @PostMapping("/register")
    public String registerMember(
            @RequestParam String memberName,
            @RequestParam String username,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {

        if (memberService.findByMember(username)) {
            model.addAttribute("error", "登入名稱重複");
            return "register";
        }
        if (!phone.matches("\\d+")) {
            model.addAttribute("error", "請填入正確電話號碼!");
            return "register";
        }
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "密碼前後不一致");
            return "register";
        }

        Member m1 = new Member();
        m1.setMembername(memberName);
        m1.setUsername(username);
        m1.setPhone(phone);
        m1.setPassword(password);

        memberService.addMember(m1.getMembername(), m1.getUsername(), m1.getPassword(), m1.getPhone());
        return "redirect:/login";
    }

    // 顯示編輯會員頁面
    @GetMapping("/edit/{memberId}")
    public String editMember(@PathVariable("memberId") int memberId, Model model) {
        List<Member> member = memberService.selectById(memberId);
        Member mm = member.get(0);
        model.addAttribute("member", mm);
        return "editMember";
    }
    // 顯示刪除會員頁面
    @GetMapping("/delete/{memberId}")
    public String deleteMember(@PathVariable("memberId") int memberId, Model model) {
        List<Member> member = memberService.selectById(memberId);
        Member mm = member.get(0);
        model.addAttribute("member", mm);
        return "deleteMember";
    }
    

    // 刪除會員
    @RequestMapping(value = "/deleteMember/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMember(@PathVariable("id") int id) {
     new MemberserviceImpl().deleteMember(id); 
     try {
         new MemberserviceImpl().deleteMember(id); 
         return new ResponseEntity<>("會員資料已成功刪除", HttpStatus.OK);
     } catch (Exception e) {
         // 印出錯誤訊息到伺服器的 log
         e.printStackTrace();
         System.out.println("刪除會員資料時發生錯誤：" + e.getMessage());

         // 回應錯誤訊息給客戶端
         return new ResponseEntity<>("刪除會員資料時發生錯誤：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
}
    
    
    
    // 使用 JSON 更新會員資料
	@RequestMapping(value = "/members/update", method = RequestMethod.POST  )
    public ResponseEntity<String> updateMember(@RequestBody Member member) {

        try {      
            memberService.updateMember(member);  // 更新會員資料
            return ResponseEntity.ok("會員資料更新成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失敗");
        }
    }
}

package carrot.control.json;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carrot.domain.Admin;
import carrot.service.AdminService;
import carrot.service.ClientService;



@Controller("json.adminControl") 
@RequestMapping("/json/auth3") 
public class AdminControl {
  @Autowired AdminService adminService;
  @Autowired ClientService clientService;
  
  @RequestMapping(value="/signup", method=RequestMethod.POST)
  public Object add(Admin admin) throws Exception {  
    
	  adminService.add(admin); //insert수행
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    System.out.println(resultMap);
    return resultMap;
  }
  



  @RequestMapping(value="/loginUser", method=RequestMethod.GET)
  public Object loginUser(HttpSession session) throws Exception {
    HashMap<String,Object> resultMap = new HashMap<>();
    
    if (session.getAttribute("loginUser") != null) {
      resultMap.put("status", "success");
      resultMap.put("loginUser", session.getAttribute("loginUser"));
    } else {
      resultMap.put("status", "fail");
    }
    
    return resultMap;
  }
  


  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public Object login(
      String aid, 
      String apwd, 
      boolean save,
      //boolean save, String requestUrl, 
      HttpServletResponse response,
      HttpSession session) throws Exception {

    
	if (save) { // 쿠키로 아이디 저장
      Cookie cookie = new Cookie("aid", aid);
      cookie.setMaxAge(60 * 60 * 24 * 15);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("aid", "");
      cookie.setMaxAge(0); // 무효화시킴
      response.addCookie(cookie);
    }
    System.out.println(aid + "," +  apwd);
    
    Admin admin = adminService.validate(aid, apwd);
    
    
    HashMap<String,Object> resultMap = new HashMap<>();
    
    if (admin != null) {
      resultMap.put("status", "success");
      session.setAttribute("loginUser", admin);
      System.out.print(resultMap);
    } else {
      session.invalidate();
      resultMap.put("status", "fail");
    }
    
    return resultMap;
  }
  
  @RequestMapping("/logout")
  public Object execute(HttpSession session) throws Exception {
    session.invalidate();
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    return resultMap;
  }

}
  


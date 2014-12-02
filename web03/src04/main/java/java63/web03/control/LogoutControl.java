package java63.web03.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component("/auth/logout.do")
public class LogoutControl {
	
	@RequestMapping
  public String execute(HttpServletRequest request) throws Exception {
    request.getSession().invalidate();
    return "redirect:login.do";
  }
}













package java63.web03.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component("/auth/logout.do")
public class LogoutControl {
  public String execute(HttpServletRequest request) throws Exception {
    request.getSession().invalidate();
    return "redirect:login.do";
  }
}













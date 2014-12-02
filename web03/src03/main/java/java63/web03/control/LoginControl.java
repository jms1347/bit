package java63.web03.control;

import java.util.ArrayList;
import java.util.HashMap;
import java63.web03.dao.MemberDao;
import java63.web03.domain.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("/auth/login.do")
public class LoginControl {
	@Autowired MemberDao memberDao;

	public String execute(HttpServletRequest request) throws Exception {
		if (request.getMethod().equals("GET")) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("uid")) {
						request.setAttribute("uid", cookie.getValue());
					}
				}
			}
			return "/auth/LoginForm.jsp";

		} else {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String save = request.getParameter("save");

			ArrayList<Cookie> cookieList = new ArrayList<>();

			if (save != null) { // 쿠키로 아이디 저장
				Cookie cookie = new Cookie("uid", uid);
				cookie.setMaxAge(60 * 60 * 24 * 15);
				cookieList.add(cookie);
			} else {
				Cookie cookie = new Cookie("uid", "");
				cookie.setMaxAge(0); // 무효화시킴
				cookieList.add(cookie);
			}

			request.setAttribute("cookieList", cookieList);

			HashMap<String,String> params = new HashMap<>();
			params.put("userId", uid);
			params.put("password", pwd);
			Member member = memberDao.existUser(params);

			HttpSession session = request.getSession();

			if (member != null) {
				session.setAttribute("loginUser", member);
				if (session.getAttribute("requestUrl") != null) {
					return "redirect:" + 
							(String)session.getAttribute("requestUrl");
				} else {
					return "redirect:../product/list.do";
				}

			} else {
				session.invalidate(); // 세션을 제거하고 새로 만든다.
				return "redirect:login.do"; //로그인 폼으로 보낸다.
			}
		}
	}

}













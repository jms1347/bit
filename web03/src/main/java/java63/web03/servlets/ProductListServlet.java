package java63.web03.servlets;

import java.io.IOException;
import java.util.HashMap;
import java63.web03.dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/product/list.do")
public class ProductListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Override
  public void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    int pageNo = 0;
    int pageSize = 0;
    
    try {
      if (request.getParameter("pageNo") != null) {
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
        pageSize = PAGE_DEFAULT_SIZE;
      }
      
      if (request.getParameter("pageSize") != null) {
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
      }
      
      //스프링의 ContextLoaderListener가 준비한 
      //ApplicationContext 객체 꺼내기
      ApplicationContext appCtx =
          WebApplicationContextUtils.getWebApplicationContext(
              this.getServletContext());
      
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("startIndex", ((pageNo - 1) * pageSize));
      paramMap.put("pageSize", pageSize);
      
      ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
      request.setAttribute("products", 
          productDao.selectList(paramMap));
      
      // include를 수행할 때는 여기에서 콘텐츠 타입을 설정해야 한다.
      response.setContentType("text/html;charset=UTF-8");
      
      // 결과를 출력하기 위해 JSP에게 위임한다.
      RequestDispatcher rd = request.getRequestDispatcher(
          "/product/ProductList.jsp");
      rd.include(request, response);
    } catch (Exception e) {
      RequestDispatcher rd = 
          request.getRequestDispatcher("/common/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
    }
  }
  
}













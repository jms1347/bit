package java63.web03.control;

import java.util.HashMap;
import java63.web03.dao.ProductDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/product/list.do")
public class ProductListControl{
	static final int PAGE_DEFAULT_SIZE = 3;

	@Autowired
	ProductDao productDao;

	public String execute(
			HttpServletRequest request) throws Exception {

		int pageNo = 0;
		int pageSize = 0;

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = PAGE_DEFAULT_SIZE;
		}

		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		request.setAttribute("products", 
				productDao.selectList(paramMap));

		return "/product/ProductList.jsp";
	}
}













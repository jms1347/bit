package java63.web03.control;

import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/product/update.do")
public class ProductUpdateControl {
	@Autowired
	ProductDao productDao;

	public String execute(HttpServletRequest request) throws Exception {
		Product product = new Product();
		product.setNo(Integer.parseInt(request.getParameter("no")));
		product.setName(request.getParameter("name"));
		product.setQuantity(Integer.parseInt(request.getParameter("qty")));
		product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));


		productDao.update(product);

		return "redirect:list.do";
	}

}













package java63.web03.control;

import java63.web03.dao.ProductDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component("/product/delete.do")
public class ProductDeleteControl {

	@Autowired
	ProductDao productDao;

	@RequestMapping
	public String execute(HttpServletRequest request) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		productDao.deletePhoto(no);
		productDao.delete(no);
		
		// 해당 제품의 사진 경로를 알아내서
		// 파일 시스템에서 지운다.
		return "redirect:list.do";
	}  
}













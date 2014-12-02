package java63.web03.control;

import java63.web03.dao.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductDeleteControl {

	@Autowired
	ProductDao productDao;

	@RequestMapping("/product/delete.do")
	public String execute(int no) throws Exception {
		productDao.deletePhoto(no);
		productDao.delete(no);

		return "redirect:list.do";
	}  
}













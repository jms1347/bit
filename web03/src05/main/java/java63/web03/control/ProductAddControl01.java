package java63.web03.control;

import java.util.Map;
import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;
//import java63.web03.util.FileUploadHelper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//방법 1) @Component("/product/add.do")
//방법 2) @Component
//방법 3) @Component
//방법 3) @RequestMapping("/product/add.do")
//방법 4) @Component
//방법 4) @RequestMapping("/product")
//@Component
@RequestMapping("/product/add.do")
public class ProductAddControl01 {
	@Autowired MakerDao makerDao;
	@Autowired ProductDao productDao;

	//방법 1) @RequestMapping
	//방법 2) @RequestMapping("/product/add.do")
	//방법 3) @RequestMapping
	//방법 4) @RequestMapping("/add.do")
	@RequestMapping(method=RequestMethod.GET)
	public String form(HttpServletRequest request) throws Exception {
		request.setAttribute("makers", makerDao.selectNameList());
		return "/product/ProductForm.jsp";
	} 

	@RequestMapping(method=RequestMethod.POST)
	public String add(HttpServletRequest request) throws Exception {  
		//FileUploadHelper 삭제 후 오류 발생문제 때문에 주석으로 막음.
		//Map<String,String> paramMap = FileUploadHelper.parse(request);
		Map<String,String> paramMap = null; // 임시 조치함.

		Product product = new Product();
		product.setName(paramMap.get("name"));
		product.setQuantity(Integer.parseInt(paramMap.get("qty")));
		product.setMakerNo(Integer.parseInt(paramMap.get("mkno")));
		product.setPhoto(paramMap.get("photo"));

		productDao.insert(product);
		productDao.insertPhoto(product);
		return "redirect:list.do";
	}

}













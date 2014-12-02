package java63.web03.control;

import java.util.Map;

import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;
import java63.web03.util.FileUploadHelper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component("/product/add.do")
public class ProductAddControl {
  @Autowired MakerDao makerDao;
  @Autowired ProductDao productDao;

  @RequestMapping
  public String execute(HttpServletRequest request) throws Exception {
    if (request.getMethod().equals("GET")) {
      request.setAttribute("makers", makerDao.selectNameList());
      return "/product/ProductForm.jsp";
      
    } else {
      Map<String,String> paramMap = FileUploadHelper.parse(request);

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

}













package java63.web03.control;

import java.io.File;
import java63.web03.domain.Product;
import java63.web03.service.MakerService;
import java63.web03.service.ProductService;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductControl {
  static Logger log = Logger.getLogger(ProductControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired ProductService     productService;
  @Autowired MakerService       makerService;
  
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("makers", makerService.getList());
    mv.setViewName("product/ProductForm");
    return mv;
  }
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Product product) throws Exception {  
    String fileuploadRealPath = 
        servletContext.getRealPath("/fileupload");
    String filename = System.currentTimeMillis() + "_"; 
    File file = new File(fileuploadRealPath + "/" + filename);
    product.getPhotofile().transferTo(file);
    product.setPhoto(filename);

    productService.add(product);
    
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    productService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      Model model) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = productService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    model.addAttribute("products", 
        productService.getList(pageNo, pageSize));
    
    model.addAttribute("currPageNo", pageNo);
    
    if (pageNo > 1) {
      model.addAttribute("prevPageNo", (pageNo - 1));
    }
    
    if (pageNo < maxPageNo) {
      model.addAttribute("nextPageNo", (pageNo + 1));
    }
    
    return "product/ProductList";
  }
  
  @RequestMapping("/update")
  public String update(Product product) throws Exception {
    productService.update(product);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Product product = productService.get(no);
    model.addAttribute("product", product);
    model.addAttribute("photos", product.getPhotoList());
    model.addAttribute("makers", makerService.getList());
    return "product/ProductView";
  }
}













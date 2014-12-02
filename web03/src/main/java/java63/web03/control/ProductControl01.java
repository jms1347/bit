package java63.web03.control;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java63.web03.dao.MakerDao;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/product")
public class ProductControl01 {
  static Logger log = Logger.getLogger(ProductControl01.class);
  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Autowired MakerDao makerDao;
  @Autowired ProductDao productDao;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("makers", makerDao.selectNameList());
    mv.setViewName("/product/ProductForm.jsp");
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

    productDao.insert(product);
    productDao.insertPhoto(product);
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    productDao.deletePhoto(no);
    productDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="0") int pageNo,
      @RequestParam(defaultValue="0") int pageSize,
      Model model) throws Exception {
    
    if (pageNo > 0) {
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    model.addAttribute("products", productDao.selectList(paramMap));
    
    return "/product/ProductList.jsp";
  }
  
  @RequestMapping("/update")
  public String update(Product product) throws Exception {
    productDao.update(product);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Product product = productDao.selectOne(no);
    model.addAttribute("product", product);
    model.addAttribute("photos", 
        productDao.selectPhoto(product.getNo()));
    
    model.addAttribute("makers", makerDao.selectNameList());
    return "/product/ProductView.jsp";
  }
  
  
  //@InitBinder
  //=> 요청 파라미터 값을 도메인 객체의 프로퍼티 값으로 변환해주는 
  //   변환기 등록
  //=> "이봐~~ 프론트 컨트롤러. 다음 메서드는 요청 파라미터를 
  //   값 객체의 프로퍼티 값으로 바꿔주는 변환기를 등록하는 메서드야.
  //   요청을 처리하기 전에 꼭 호출해줘!!"
  //   "호출 안하면 문자열을 java.util.Date 객체로 바꿀 수가 없어서,
  //    오류가 뜰거야. 꼭 호출해주오T.T."
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    log.debug("initBinder() 호출됨");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    
    // 문자열을 특정 타입으로 바꿀 변환기를 등록
    binder.registerCustomEditor(
        Date.class, /* 어떤 타입으로 바꿀 것인지 지정*/ 
        new CustomDateEditor(dateFormat, true) /* 변환기 */
        );
  }
  
  public static void main(String[] args) throws Exception {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    //기본은 true => 날짜가 초과되면 자동으로 계산한다. 예외 안 띄운다.
    //false로 설정 => 문자열을 엄격히 검사한다. 형식 맞지 않으면 예외 발생!
    //dateFormat.setLenient(false);
    System.out.println(dateFormat.parse("2014-12-40"));
  }
  
}













package carrot.control;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import carrot.domain.Goods;
import carrot.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsControl {
  static Logger log = Logger.getLogger(GoodsControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired GoodsService goodsService;
  @Autowired ServletContext servletContext;

 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Goods goods) throws Exception {  
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    goodsService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      @RequestParam(required=false) Boolean code,
      @RequestParam(required=false) Boolean name,
      @RequestParam(required=false) Boolean category,
      @RequestParam(defaultValue="category") String orderBy,
      Model model) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;

    int maxPageNo = goodsService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    model.addAttribute("goodss", goodsService.getList(pageNo, pageSize, category, code, name, orderBy));
    model.addAttribute("currPageNo", pageNo);
    
    if (pageNo > 1) {
      model.addAttribute("prevPageNo", (pageNo - 1));
    }
    
    if (pageNo < maxPageNo) {
      model.addAttribute("nextPageNo", (pageNo + 1));
    }
    
    return "goods/GoodsList";
  }
  
  @RequestMapping("/update")
  public String update(Goods goods) throws Exception {
  	goodsService.update(goods);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Goods goods = goodsService.get(no);
    model.addAttribute("goods", goods);
    
    return "goods/GoodsView";
  }
}












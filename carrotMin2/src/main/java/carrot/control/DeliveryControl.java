package carrot.control;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import carrot.domain.Delivery;
import carrot.service.DeliveryService;

@Controller
@RequestMapping("/delivery")
public class DeliveryControl {
  static Logger log = Logger.getLogger(DeliveryControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired DeliveryService deliveryService;
  @Autowired ServletContext servletContext;

 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Delivery delivery) throws Exception {  
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
	  deliveryService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,

      Model model) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;

    int maxPageNo = deliveryService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    model.addAttribute("deliverys", deliveryService.getList(pageNo, pageSize));
    model.addAttribute("currPageNo", pageNo);
    
    if (pageNo > 1) {
      model.addAttribute("prevPageNo", (pageNo - 1));
    }
    
    if (pageNo < maxPageNo) {
      model.addAttribute("nextPageNo", (pageNo + 1));
    }
    
    return "delivery/DeliveryList";
  }
  
  @RequestMapping("/update")
  public String update(Delivery delivery) throws Exception {
	  deliveryService.update(delivery);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Delivery delivery = deliveryService.get(no);
    model.addAttribute("delivery", delivery);
    
    return "delivery/DeliveryView";
  }
}












package carrot.control.json;

import java.util.HashMap;

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

@Controller("json.deliveryControl")
@RequestMapping("/json/delivery")
public class DeliveryControl {
  static Logger log = Logger.getLogger(DeliveryControl.class);
  static final int PAGE_DEFAULT_SIZE = 10;
  
  @Autowired DeliveryService deliveryService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Delivery delivery) throws Exception {  
  	
	  deliveryService.add(delivery);
  	
  	
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }

  @RequestMapping("/delete")
  public Object delete(int no) throws Exception {
	  deliveryService.delete(no);    
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = deliveryService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
//    resultMap.put("goodss", goodsService.getList(pageNo, pageSize));
    resultMap.put("deliverys", deliveryService.getList(pageNo, pageSize));
  
    return resultMap;
  }
  
  @RequestMapping("/update")
  public Object update(Delivery delivery) throws Exception {
	  deliveryService.update(delivery);
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");

    return resultMap;  
  }
  
  @RequestMapping("/view")
  public Object view(int no, Model model) throws Exception {
	  Delivery delivery = deliveryService.get(no);
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("delivery", delivery);

    return resultMap;  
  }
}













package carrot.control.json;

import java.io.File;
import java.util.HashMap;

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

@Controller("json.goodsControl")
@RequestMapping("/json/goods")
public class GoodsControl {
  static Logger log = Logger.getLogger(GoodsControl.class);
  static final int PAGE_DEFAULT_SIZE = 10;
  
  @Autowired GoodsService goodsService;
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Goods goods) throws Exception {  
    
    if (goods.getPhotofile() != null
        && !goods.getPhotofile().isEmpty()) {

      String fileuploadRealPath = 
        servletContext.getRealPath("/fileupload");
      String filename = System.currentTimeMillis() + "_"; 
      File file = new File(fileuploadRealPath + "/" + filename);
    
      goods.getPhotofile().transferTo(file);
      goods.setUrl(filename);
    }
    
  	
  	goodsService.add(goods);
  	
  	
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }

  @RequestMapping("/delete")
  public Object delete(int no) throws Exception {
    goodsService.delete(no);    
    
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(required=false) Boolean code,
      @RequestParam(required=false) Boolean name,
      @RequestParam(required=false) Boolean category,
      @RequestParam(defaultValue="category") String orderBy) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = goodsService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
//    resultMap.put("goodss", goodsService.getList(pageNo, pageSize));
    resultMap.put("goodss", goodsService.getList(pageNo, pageSize, category, code, name, orderBy));
  
    return resultMap;
  }
  
  @RequestMapping("/update")
  public Object update(Goods goods) throws Exception {
    goodsService.update(goods);
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");

    return resultMap;  
  }
  
  @RequestMapping("/view")
  public Object view(int no, Model model) throws Exception {
    Goods goods = goodsService.get(no);
   
    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("goods", goods);

    return resultMap;  
  }
}













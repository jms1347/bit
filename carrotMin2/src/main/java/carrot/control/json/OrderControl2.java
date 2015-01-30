package carrot.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import carrot.domain.Company;
import carrot.domain.Order;
import carrot.service.OrderService2;

@Controller("json.orderControl2")
@RequestMapping("/json/order2")
public class OrderControl2 {
	static Logger log = Logger.getLogger(OrderControl2.class);
	static final int PAGE_DEFAULT_SIZE = 5;
	String oname;
	String oodate;
	String ograde;
	
	@Autowired OrderService2 orderService2;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="/title", method=RequestMethod.POST)
	  public Object add(Order order) throws Exception {  
	    
	    HashMap<String,Object> resultMap = new HashMap<>();
	    resultMap.put("oname",order.getOname());
	    resultMap.put("oodate", order.getOodate());
	    resultMap.put("ograde",order.getOgrade());
	    System.out.println(resultMap);
	    oname = order.getOname();
	    oodate = order.getOodate();
	    ograde = order.getOgrade();
	    System.out.println("oname : "+oname);
	    System.out.println("oodate : "+oodate);
	    System.out.println("ograde : "+ograde);

	    return resultMap;
	  }


	@RequestMapping("/list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="20") int pageSize,
			HttpSession session) throws Exception {
		
		Company supplier = (Company)session.getAttribute("loginUser");
		int sno = supplier.getSno();
		String sname = supplier.getSname();
		
		supplier.setSno(sno);
		supplier.setSname(sname);
		

		
		if (pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;

		int maxPageNo = orderService2.getMaxPageNo(pageSize);

		if (pageNo <= 0) pageNo = 1;
		if (pageNo > maxPageNo) pageNo = maxPageNo;
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
		resultMap.put("oname", oname);
		resultMap.put("oodate", oodate);
		resultMap.put("orders", orderService2.getList2(pageNo,pageSize,oname, oodate));

		//resultMap.put("deliverys", deliveryService2.getList(pageNo,pageSize));

		return resultMap;
	}
	

}


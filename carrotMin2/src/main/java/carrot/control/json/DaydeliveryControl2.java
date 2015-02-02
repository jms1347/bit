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
import carrot.domain.Daydelivery;
import carrot.service.DaydeliveryService2;

@Controller("json.daydeliveryControl2")
@RequestMapping("/json/daydelivery2")
public class DaydeliveryControl2 {
	static Logger log = Logger.getLogger(DaydeliveryControl2.class);
	static final int PAGE_DEFAULT_SIZE = 5;
	String dname;
	String ddate;
	String dgrade;
	
	@Autowired DaydeliveryService2 daydeliveryService2;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="/title", method=RequestMethod.POST)
	  public Object add(Daydelivery daydelivery) throws Exception {  
	    System.out.println("delivery : "+daydelivery);
	    
	    HashMap<String,Object> resultMap = new HashMap<>();
	    resultMap.put("dname",daydelivery.getDname());
	    resultMap.put("ddate", daydelivery.getDdate());
	    resultMap.put("dgrade",daydelivery.getDgrade());
	    System.out.println(resultMap);
	    dname = daydelivery.getDname();
	    ddate = daydelivery.getDdate();
	    dgrade = daydelivery.getDgrade();
	    System.out.println("dname : "+dname);
	    System.out.println("ddate : "+ddate);
	    System.out.println("dgrade : "+dgrade);
	    
	    
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

		int maxPageNo = daydeliveryService2.getMaxPageNo(pageSize);

		if (pageNo <= 0) pageNo = 1;
		if (pageNo > maxPageNo) pageNo = maxPageNo;
		
		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
		resultMap.put("ccname", dname);
		resultMap.put("oddate", ddate);
		resultMap.put("mlevel", dgrade);
		
		resultMap.put("daydeliverys", daydeliveryService2.getList2(pageNo,pageSize,dname, ddate));

		//resultMap.put("deliverys", deliveryService2.getList(pageNo,pageSize));

		return resultMap;
	}
	

}


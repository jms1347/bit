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

import carrot.domain.Delivery2;
import carrot.service.DeliveryService2;

@Controller("json.deliveryControl2")
@RequestMapping("/json/delivery2")
public class DeliveryControl2 {
	static Logger log = Logger.getLogger(DeliveryControl2.class);
	static final int PAGE_DEFAULT_SIZE = 5;

	@Autowired DeliveryService2 deliveryService2;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Object add(Delivery2 delivery2) throws Exception {  

		deliveryService2.add(delivery2);


		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");

		return resultMap;
	}

	@RequestMapping("/delete")
	public Object delete(int no) throws Exception {
		deliveryService2.delete(no);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		return resultMap;
	}

	@RequestMapping("/list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="5") int pageSize) throws Exception {

		if (pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;

		int maxPageNo = deliveryService2.getMaxPageNo(pageSize);

		if (pageNo <= 0) pageNo = 1;
		if (pageNo > maxPageNo) pageNo = maxPageNo;

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
		resultMap.put("deliverys", deliveryService2.getList(pageNo,pageSize));

		return resultMap;
	}

	@RequestMapping("/update")
	public Object update(Delivery2 delivery) throws Exception {
		deliveryService2.update(delivery);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		return resultMap;
	}

	@RequestMapping("/view")
	public Object view(int no, Model model) throws Exception {
		Delivery2 delivery = deliveryService2.get(no);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("delivery", delivery);
		return resultMap;
	}
}


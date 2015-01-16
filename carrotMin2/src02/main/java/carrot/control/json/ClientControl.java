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

import carrot.domain.Client;
import carrot.service.ClientService;

@Controller("json.clientControl")
@RequestMapping("/json/client")
public class ClientControl {
	static Logger log = Logger.getLogger(ClientControl.class);
	static final int PAGE_DEFAULT_SIZE = 5;

	@Autowired ClientService clientService;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Object add(Client client) throws Exception {  

		clientService.add(client);


		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");

		return resultMap;
	}

	@RequestMapping("/delete")
	public Object delete(int no) throws Exception {
		clientService.delete(no);

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

		int maxPageNo = clientService.getMaxPageNo(pageSize);

		if (pageNo <= 0) pageNo = 1;
		if (pageNo > maxPageNo) pageNo = maxPageNo;

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
		resultMap.put("clients", clientService.getList(pageNo,pageSize));

		return resultMap;
	}

	@RequestMapping("/update")
	public Object update(Client client) throws Exception {
		clientService.update(client);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		return resultMap;
	}

	@RequestMapping("/view")
	public Object view(int no, Model model) throws Exception {
		Client client = clientService.get(no);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("client", client);
		return resultMap;
	}
}


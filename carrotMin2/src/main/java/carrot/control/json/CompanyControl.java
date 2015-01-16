package carrot.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import carrot.domain.Company;
import carrot.service.CompanyService;

@Controller("json.companyControl")
@RequestMapping("/json/company")
public class CompanyControl {
	static Logger log = Logger.getLogger(CompanyControl.class);
	static final int PAGE_DEFAULT_SIZE = 5;

	@Autowired
	CompanyService companyService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(Company company) throws Exception {

		companyService.add(company);

		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");

		return resultMap;
	}

	@RequestMapping("/list")
	public Object list(@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize) throws Exception {

		if (pageSize <= 0)
			pageSize = PAGE_DEFAULT_SIZE;

		int maxPageNo = companyService.getMaxPageNo(pageSize);

		if (pageNo <= 0)
			pageNo = 1;
		if (pageNo > maxPageNo)
			pageNo = maxPageNo;

		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("currPageNo", pageNo);
		resultMap.put("maxPageNo", maxPageNo);
		resultMap.put("companys", companyService.getList(pageNo, pageSize));

		return resultMap;
	}
}

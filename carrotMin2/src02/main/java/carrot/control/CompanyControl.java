package carrot.control;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import carrot.domain.Company;
import carrot.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyControl {

	@Autowired
	CompanyService companyService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView form() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("company/login");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Company company) throws Exception {
        System.out.println("test01");
        companyService.add(company);

		return "redirect:add.do";
	}
}
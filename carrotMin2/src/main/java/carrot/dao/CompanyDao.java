package carrot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carrot.domain.Company;


public interface CompanyDao {
	
	  Company selectOne(int no);
	  void delete(int no);
	  List<?> selectList(Map<String,Object> params);
	  void insert(Company company);
	  int totalSize();
	Company existUser(HashMap<String, String> params);
	Company auto(Company companyName);

}
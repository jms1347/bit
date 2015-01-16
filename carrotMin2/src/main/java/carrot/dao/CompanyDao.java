package carrot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carrot.domain.Company;


public interface CompanyDao {
	
	void insert(Company company);
	Company existUser(Map<String,String> params);
	Company selectOne(int sid);
	List<?> selectList(HashMap<String, Object> paramMap);
	int totalSize();
}
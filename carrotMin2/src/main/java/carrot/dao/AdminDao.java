package carrot.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carrot.domain.Admin;


public interface AdminDao {
	
	void insert(Admin admin);
	Admin existUser(Map<String,String> params);
	Admin selectOne(int aid);
	List<?> selectList(HashMap<String, Object> paramMap);
	int totalSize();
}
package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.AdminDao;
import carrot.dao.ClientDao;
import carrot.domain.Admin;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ClientDao clientDao;

	public List<?> getList(int pageNo, int pageSize) {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		System.out.println("startIndex : " +((pageNo - 1) * pageSize));
		System.out.println("pageSize : " + pageSize);
		return adminDao.selectList(paramMap);
	}

	public int getMaxPageNo(int pageSize) {
		int totalSize = adminDao.totalSize();
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0)
			maxPageNo++;

		return maxPageNo;
	}

	public Admin validate(String aid, String apwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("aid", aid);
		params.put("apwd", apwd);
		return adminDao.existUser(params);
	}

	/*
	 * @Transactional 선언 => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다. => 모든
	 * 작업이 성공했을 때만 서버에 반영한다.
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)


	public Admin selectOne(int aid) {
		System.out.println(aid);
		return adminDao.selectOne(aid);
	}
	public void add(Admin admin) {
		adminDao.insert(admin);
		
	}

}

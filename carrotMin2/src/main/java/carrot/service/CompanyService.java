package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.ClientDao;
import carrot.dao.CompanyDao;
import carrot.domain.Client;
import carrot.domain.Company;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class CompanyService {
	@Autowired
	CompanyDao companyDao;

	@Autowired
	ClientDao clientDao;

	public List<?> getList(int pageNo, int pageSize, Boolean stel,
			Boolean sname, Boolean scname, String orderBy) {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		paramMap.put("stel", stel);
		paramMap.put("sname", sname);
		paramMap.put("scname", scname);
		paramMap.put("orderBy", orderBy);

		return companyDao.selectList(paramMap);
	}

	public int getMaxPageNo(int pageSize) {
		int totalSize = companyDao.totalSize();
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0)
			maxPageNo++;

		return maxPageNo;
	}

	public Company validate(String sid, String spwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("sid", sid);
		params.put("spwd", spwd);
		return companyDao.existUser(params);
	}

	/*
	 * @Transactional 선언 => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다. => 모든
	 * 작업이 성공했을 때만 서버에 반영한다.
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void add(Company company) {
		companyDao.insert(company);

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public Company selectOne(int sid) {
		System.out.println(sid);
		return companyDao.selectOne(sid);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void add(Client client) {
		clientDao.insert(client);

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void delete(int companyNo) {
		companyDao.delete(companyNo);
	}

	public Company get(int companyNo) {
		Company company = companyDao.selectOne(companyNo);
		return company;
	}

	public Company auto(Company companyName) {
		Company company1 = companyDao.auto(companyName);
		System.out.println("company1 =" + company1);
		return company1;
	}

}

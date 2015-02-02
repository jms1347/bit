package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrot.dao.DaydeliveryDao2;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class DaydeliveryService2 {
	@Autowired
	DaydeliveryDao2 daydeliveryDao2;



	public int getMaxPageNo(int pageSize) {
		int totalSize = daydeliveryDao2.totalSize();
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0)
			maxPageNo++;

		return maxPageNo;
	}


	public List<?> getList2(int pageNo, int pageSize, String dname, String ddate) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		paramMap.put("ccname", dname);
		paramMap.put("oddate", ddate);
		
		//System.out.println("paramMap : "+paramMap);
		
		return daydeliveryDao2.selectList2(paramMap);
	}






}

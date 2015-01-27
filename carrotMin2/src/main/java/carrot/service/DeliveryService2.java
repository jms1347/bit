package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.DeliveryDao2;
import carrot.domain.Delivery2;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class DeliveryService2 {
	@Autowired
	DeliveryDao2 deliveryDao2;

	public List<?> getList(int pageNo, int pageSize) {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		return deliveryDao2.selectList2(paramMap);
	}

	public int getMaxPageNo(int pageSize) {
		int totalSize = deliveryDao2.totalSize();
		int maxPageNo = totalSize / pageSize;
		if ((totalSize % pageSize) > 0)
			maxPageNo++;

		return maxPageNo;
	}

	/*
	 * @Transactional 선언 => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다. => 모든
	 * 작업이 성공했을 때만 서버에 반영한다.
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void add(Delivery2 delievery) {
		deliveryDao2.insert(delievery);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void update(Delivery2 delievery) {
		deliveryDao2.update(delievery);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void delete(int delieveryNo) {
		deliveryDao2.delete(delieveryNo);
	}

	public Delivery2 get(int delieveryNo) {
		Delivery2 delievery = deliveryDao2.selectOne(delieveryNo);
		return delievery;
	}





}

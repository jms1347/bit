package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.DeliveryDao;
import carrot.domain.Delivery;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class DeliveryService {
	@Autowired
	DeliveryDao deliveryDao;

	public List<?> getList(int pageNo, int pageSize) {

		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		return deliveryDao.selectList(paramMap);
	}

	public int getMaxPageNo(int pageSize) {
		int totalSize = deliveryDao.totalSize();
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
	public void add(Delivery delievery) {
		deliveryDao.insert(delievery);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void update(Delivery delievery) {
		deliveryDao.update(delievery);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void delete(int delieveryNo) {
		deliveryDao.delete(delieveryNo);
	}

	public Delivery get(int deliveryNo) {
		Delivery delivery = deliveryDao.selectOne(deliveryNo);
		System.out.println("deliveryNo : "+deliveryNo);
		System.out.println("delievery : "+delivery);
		return delivery;
	}
	public List<?> getList2(int pageNo, int pageSize,int deliveryNo) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		paramMap.put("delivery", deliveryDao.selectlist2(deliveryNo));
		
		return deliveryDao.selectList2(paramMap);
	}




}

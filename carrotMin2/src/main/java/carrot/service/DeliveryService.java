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
 => 비즈니스 로직 수행
 => 트랜잭션 관리
*/
@Service
public class DeliveryService {
	@Autowired
	DeliveryDao deliveryDao;
	
	public List<?> getList(int pageNo, int pageSize){

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);
		
    return deliveryDao.selectList(paramMap);
	}
	
  public int getMaxPageNo(int pageSize) {
    int totalSize = deliveryDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
  	return maxPageNo;
  }
  
  /* Transaction
   => 여러 개의 작업을 하나로 묶은 것
   												ㄴ여러 개의 작업 중 하나라도 
   												오류가 발생하면 전체 작업을 취소.= rollback
   												=>모든 작업이 성공하면 결과를 확정 = commit
  
  * @Transactioanl 선언
 => 메서드 안의 입력/변경/삭제(manipulation) 작업을 하나의 작업으로 묶는다.
 => 모든 작업이 성공했을때만 서버에 반영한다.
  */
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void add(Delivery delivery) {
	  deliveryDao.insert(delivery);
  }
  
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void update(Delivery delivery) {
	  deliveryDao.update(delivery);
  }
  
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void delete(int deliveryNo) {
	  deliveryDao.delete(deliveryNo);
  }
  
  public Delivery get(int deliveryNo) {
	  Delivery delivery = deliveryDao.selectOne(deliveryNo);
  	return delivery;
  }
  
}

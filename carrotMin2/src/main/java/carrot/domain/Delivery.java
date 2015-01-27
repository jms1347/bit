/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package carrot.domain;

import java.io.Serializable;

public class Delivery implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int cno;
  protected int sno;
  protected String dname;
  protected String dgrade;
  protected String ddate;
  protected String monthdate;
  protected String monthsum;
  
  
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public int getCno() {
	return cno;
}
public void setCno(int cno) {
	this.cno = cno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getDgrade() {
	return dgrade;
}
public void setDgrade(String dgrade) {
	this.dgrade = dgrade;
}

public String getDdate() {
	return ddate;
}
public void setDdate(String ddate) {
	this.ddate = ddate;
}

public String getMonthdate() {
	return monthdate;
}
public void setMonthdate(String monthdate) {
	this.monthdate = monthdate;
}
public String getMonthsum() {
	return monthsum;
}
public void setMonthsum(String monthsum) {
	this.monthsum = monthsum;
}

@Override
public String toString() {
	return "Delivery [cno=" + cno + ", sno=" + sno + ", dname=" + dname
			+ ", dgrade=" + dgrade + ", ddate=" + ddate + ", monthdate="
			+ monthdate + ", monthsum=" + monthsum + "]";
}


  
  
}
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
	protected String oprice;
	//protected String monthsum;
	protected String del_stat;
	protected String gcode;
	protected String gunit;
	protected String omemo;
	
	protected String sum_oprice;
	protected String ocode;
	protected String gprice_a;
	protected String gprice_b;
	protected String gprice_c;
	
	
	public String getSum_oprice() {
		return sum_oprice;
	}
	public void setSum_oprice(String sum_oprice) {
		this.sum_oprice = sum_oprice;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public String getOprice() {
		return oprice;
	}
	public void setOprice(String oprice) {
		this.oprice = oprice;
	}
	public String getDel_stat() {
		return del_stat;
	}
	public void setDel_stat(String del_stat) {
		this.del_stat = del_stat;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGunit() {
		return gunit;
	}
	public void setGunit(String gunit) {
		this.gunit = gunit;
	}
	public String getOmemo() {
		return omemo;
	}
	public void setOmemo(String omemo) {
		this.omemo = omemo;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getGprice_a() {
		return gprice_a;
	}
	public void setGprice_a(String gprice_a) {
		this.gprice_a = gprice_a;
	}
	public String getGprice_b() {
		return gprice_b;
	}
	public void setGprice_b(String gprice_b) {
		this.gprice_b = gprice_b;
	}
	public String getGprice_c() {
		return gprice_c;
	}
	public void setGprice_c(String gprice_c) {
		this.gprice_c = gprice_c;
	}
	@Override
	public String toString() {
		return "Delivery [cno=" + cno + ", sno=" + sno + ", dname=" + dname
				+ ", dgrade=" + dgrade + ", ddate=" + ddate + ", oprice="
				+ oprice + ", del_stat=" + del_stat + ", gcode=" + gcode
				+ ", gunit=" + gunit + ", omemo=" + omemo + ", sum_oprice="
				+ sum_oprice + ", ocode=" + ocode + ", gprice_a=" + gprice_a
				+ ", gprice_b=" + gprice_b + ", gprice_c=" + gprice_c + "]";
	}
	

	

}
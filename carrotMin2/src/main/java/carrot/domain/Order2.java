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

public class Order2 implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int gno;
	protected int sno;
	protected String oname;
	protected String gname;
	protected String gcat;
	protected String gunit;
	protected String oqty;
	protected String oddate;
	protected String oodate;
	protected String gmemo;
	protected String oprice;
	
	
	public String getOprice() {
		return oprice;
	}

	public void setOprice(String oprice) {
		this.oprice = oprice;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getGmemo() {
		return gmemo;
	}

	public void setGmemo(String gmemo) {
		this.gmemo = gmemo;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGcat() {
		return gcat;
	}

	public void setGcat(String gcat) {
		this.gcat = gcat;
	}

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
	}

	public String getOqty() {
		return oqty;
	}

	public void setOqty(String oqty) {
		this.oqty = oqty;
	}

	public String getOddate() {
		return oddate;
	}

	public void setOddate(String oddate) {
		this.oddate = oddate;
	}

	public String getOodate() {
		return oodate;
	}

	public void setOodate(String oodate) {
		this.oodate = oodate;
	}

	@Override
	public String toString() {
		return "Delivery2 [gno=" + gno + ", sno=" + sno + ", oname=" + oname
				+ ", gname=" + gname + ", gcat=" + gcat + ", gunit=" + gunit
				+ ", oqty=" + oqty + ", oddate=" + oddate + ", oodate="
				+ oodate + ", gmemo=" + gmemo + ", oprice=" + oprice + "]";
	}

	

	

}
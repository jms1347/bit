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

public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int sno;
	protected String sid;
	protected String spwd;
	protected String stel;
	protected String scname;
	protected String sname;
	protected String sbno;
	protected String spostno;
	protected String saddr;
	protected String saddr_det;
	protected String smemo;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSbno() {
		return sbno;
	}
	public void setSbno(String sbno) {
		this.sbno = sbno;
	}
	public String getSpostno() {
		return spostno;
	}
	public void setSpostno(String spostno) {
		this.spostno = spostno;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public String getSaddr_det() {
		return saddr_det;
	}
	public void setSaddr_det(String saddr_det) {
		this.saddr_det = saddr_det;
	}
	public String getSmemo() {
		return smemo;
	}
	public void setSmemo(String smemo) {
		this.smemo = smemo;
	}
	@Override
	public String toString() {
		return "Company [sno=" + sno + ", sid=" + sid + ", spwd=" + spwd
				+ ", stel=" + stel + ", scname=" + scname + ", sname=" + sname
				+ ", sbno=" + sbno + ", spostno=" + spostno + ", saddr="
				+ saddr + ", saddr_det=" + saddr_det + ", smemo=" + smemo + "]";
	}

	
	
}

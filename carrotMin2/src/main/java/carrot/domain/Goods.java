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

import org.springframework.web.multipart.MultipartFile;

public class Goods implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected int no;
  protected int supplierNo;
  protected String code;
  protected String name;
  protected String url;
  protected String unit;
  protected String category;
  protected String note;
  protected int priceA;
  protected int priceB;
  protected int priceC;
  protected MultipartFile   photofile;
  
	@Override
	public String toString() {
		return "Goods [no=" + no + ", supplierNo=" + supplierNo + ", code=" + code
				+ ", name=" + name + ", url=" + url + ", unit=" + unit + ", category="
				+ category + ", note=" + note + ", priceA=" + priceA + ", priceB="
				+ priceB + ", priceC=" + priceC + "]";
	}
	
	public MultipartFile getPhotofile() {
		return photofile;
	}
	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(int supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPriceA() {
		return priceA;
	}
	public void setPriceA(int priceA) {
		this.priceA = priceA;
	}
	public int getPriceB() {
		return priceB;
	}
	public void setPriceB(int priceB) {
		this.priceB = priceB;
	}
	public int getPriceC() {
		return priceC;
	}
	public void setPriceC(int priceC) {
		this.priceC = priceC;
	}

}














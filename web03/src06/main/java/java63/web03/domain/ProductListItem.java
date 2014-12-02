package java63.web03.domain;

import java.io.Serializable;

public class ProductListItem implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int       no;
  protected String    name;
  protected int       quantity;
  protected int       makerNo;
  protected String    maker;
  
  @Override
  public String toString() {
    return "ProductListItem [no=" + no + ", name=" + name + ", quantity="
        + quantity + ", makerNo=" + makerNo + ", maker=" + maker + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getMakerNo() {
    return makerNo;
  }
  public void setMakerNo(int makerNo) {
    this.makerNo = makerNo;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  
  
}

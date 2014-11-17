package java02.test21.spring.exam07;

import java.util.Arrays;

public class Car {
  String model;
  int cc;
  Engine engine;
  Tire[] tires;
  
  public Car() {}
  
  public Car(String model) {
    this.model = model;
  }
  
  public Car(String model, int cc) {
    this.model = model;
    this.cc = cc;
  }
  


  @Override
public String toString() {
	return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine
			+ ", tires=" + Arrays.toString(tires) + "]";
}

public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    this.engine = engine;
  }

public Tire[] getTires() {
	return tires;
}

public void setTires(Tire[] tires) {
	this.tires = tires;
}
  
  
}

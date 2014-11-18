package java02.test21.spring.exam14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  @SuppressWarnings({ "unused", "resource" })
  public static void main(String[] args) {
    //Car c = new Car();
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(
            new String[]{"java02/test21/spring/exam14/application-context.xml"});

    Car c01= (Car)ctx.getBean("car");
    System.out.println(c01);
  }
}



















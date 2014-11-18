package java02.test21.spring.exam03;

/* 스프링 설정
 * => 호출할 생성자 지정하기
 * 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  @SuppressWarnings({ "unused", "resource" })
  public static void main(String[] args) {
    //Car c = new Car();
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(
            new String[]{"java02/test21/spring/exam03/application-context.xml"});
    
    Car c1 = (Car)ctx.getBean("b01");
    System.out.println(c1.getModel());
    
    Car c2 = (Car)ctx.getBean("b02");
    System.out.println(c2.getModel());
    
    Car c3 = (Car)ctx.getBean("b03");
    System.out.println(c3.getModel());
    
    Car c4 = (Car)ctx.getBean("b04");
    System.out.println(c4.getModel());
    
    System.out.println("-------------------------------");
    Car c5 = (Car)ctx.getBean("b05");
    System.out.println(c5.getModel());
    System.out.println(c5.getCc());
    
    System.out.println("-------------------------------");
    Car c6 = (Car)ctx.getBean("b06");
    System.out.println(c6.getModel());
    System.out.println(c6.getCc());
  }
}










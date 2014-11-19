package java02.test21.spring.exam05;

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
            new String[]{"java02/test21/spring/exam05/application-context.xml"});
    
    Car c1 = (Car)ctx.getBean("b01");
    System.out.println(c1);
    
    Car c2 = (Car)ctx.getBean("b02");
    System.out.println(c2);
    
    Car c3 = (Car)ctx.getBean("b03");
    System.out.println(c3);
    Car c4 = (Car)ctx.getBean("b04");
    System.out.println(c4);
    Car c5 = (Car)ctx.getBean("b05");
    System.out.println(c5);
    
    System.out.println(c5==c4);
    	System.out.println(c5!=c4);

  }
}










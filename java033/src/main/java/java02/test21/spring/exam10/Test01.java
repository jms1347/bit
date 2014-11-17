package java02.test21.spring.exam10;

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
            new String[]{"java02/test21/spring/exam10/application-context.xml"});
    
   Engine e01 = (Engine)ctx.getBean("e01");
   System.out.println(e01);
   
   Engine e02 = (Engine)ctx.getBean("e02");
   System.out.println(e02);
   
   Engine e03 = (Engine)ctx.getBean("e03");
   System.out.println(e03);


  }

}










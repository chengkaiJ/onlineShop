package onlineShop;

import onlineShop.ApplicationConfig;
import onlineShop.log.PaymentAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "payment.xml");
//
//        PaymentAction paymentAction = (PaymentAction) context.getBean(PaymentAction.class);
//        paymentAction.pay(new BigDecimal(2));

    }
}

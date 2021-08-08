package onlineShop.log;

import java.math.BigDecimal;

public class PaymentAction {
    private Logger logger;

    public PaymentAction(Logger logger) {
        this.logger = logger;
    }

    public void pay(BigDecimal payValue) {
        logger.log("pay begin, payValue is " + payValue);
        logger.log("pay end");
    }

}

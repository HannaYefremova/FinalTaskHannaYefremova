package framework.helpers;

import java.math.BigDecimal;

public class PriceHelper {

    public static BigDecimal calculateTotalPrice(BigDecimal price, int quantity) {
        return price.multiply(new BigDecimal(quantity)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    public static BigDecimal calculateDiscount(BigDecimal regularPrice, int discount) {
        return regularPrice.multiply(new BigDecimal(100 - discount)).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
}

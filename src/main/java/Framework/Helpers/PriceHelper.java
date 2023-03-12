package Framework.Helpers;

import java.text.DecimalFormat;

public class PriceHelper {

    public static Double calculateTotalPrice(String price, String quantity) {
        return Double.parseDouble(price.substring(1)) * Integer.parseInt(quantity);
    }

    public static Double roundPrice(Double price) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(price));
    }

    public static Double calculateDiscount(String regularPrice, String discount) {
        return Double.parseDouble(regularPrice.substring(1)) * (100 - Integer.parseInt(discount.substring(1, discount.length() - 1))) / 100;
    }

    public static Double getPriceFromString(String value) {
        return roundPrice(Double.parseDouble(value.substring(1)));
    }

}

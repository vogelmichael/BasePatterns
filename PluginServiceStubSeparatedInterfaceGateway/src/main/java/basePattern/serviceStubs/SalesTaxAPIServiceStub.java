package main.java.basePattern.serviceStubs;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * API will normally be a service like a REST-API, but its simplified for not wanting to implement a whole REST-API
 */
public class SalesTaxAPIServiceStub {
    private static final BigDecimal EXEMPT_RATE = new BigDecimal("0.0000");
    private static final String[] EXEMPT_STATE = new String[]{"MON", "IRE"};
    private static final String EXEMPT_CUSTOMER = "company";
    private static final BigDecimal AUSTRIA_PRIVATE_RATE = new BigDecimal("0.2000");
    private static final BigDecimal GERMANY_PRIVATE_RATE = new BigDecimal("0.1900");
    private static final BigDecimal TOBACCO_PRIVATE_RATE = new BigDecimal("0.7000");

    public static BigDecimal getSalesTaxRate(String country, String product, String customer){
        if(customer.equalsIgnoreCase(EXEMPT_CUSTOMER) || Arrays.stream(EXEMPT_STATE).anyMatch(n -> n.equalsIgnoreCase(country))){
            return EXEMPT_RATE;
        }else{
            if(product.equalsIgnoreCase("TOBACCO")){
                return TOBACCO_PRIVATE_RATE;
            }
            if(country.equalsIgnoreCase("AUT")){
                return AUSTRIA_PRIVATE_RATE;
            } else if(country.equalsIgnoreCase("GER")){
                return GERMANY_PRIVATE_RATE;
            }
        }

        return new BigDecimal("-1.0000");
    }
}

package main.java.basePattern.serviceStubs;

import java.math.BigDecimal;

public class SalesTaxMockServiceStub {
    private static final BigDecimal TAX_RATE = new BigDecimal("0.2000");
    private static final String EXEMPT_CUSTOMER = "company";
    private static final BigDecimal COMPANY_TAX_RATE = new BigDecimal("0.0000");

    public static BigDecimal getSalesTaxAmount(String customer){
        if(customer.equalsIgnoreCase(EXEMPT_CUSTOMER)){
            return COMPANY_TAX_RATE;
        }else {
            return TAX_RATE;
        }
    }
}

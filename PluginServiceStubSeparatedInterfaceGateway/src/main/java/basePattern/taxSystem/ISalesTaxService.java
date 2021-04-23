package main.java.basePattern.taxSystem;

import java.math.BigDecimal;

public interface ISalesTaxService {

    public BigDecimal getSalesTaxAmount(Country country, Product product, Customer customer) throws Exception;
}

package main.java.basePattern.gateway;

import main.java.basePattern.serviceStubs.SalesTaxMockServiceStub;
import main.java.basePattern.taxSystem.Country;
import main.java.basePattern.taxSystem.Customer;
import main.java.basePattern.taxSystem.ISalesTaxService;
import main.java.basePattern.taxSystem.Product;

import java.math.BigDecimal;

public class SalesTaxMockGateway implements ISalesTaxService {

    @Override
    public BigDecimal getSalesTaxAmount(Country country, Product product, Customer customer) throws Exception{
        return SalesTaxMockServiceStub.getSalesTaxAmount(customer.get_customer());
    }
}

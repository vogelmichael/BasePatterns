package main.java.basePattern.gateway;

import main.java.basePattern.serviceStubs.SalesTaxAPIServiceStub;
import main.java.basePattern.taxSystem.Country;
import main.java.basePattern.taxSystem.Customer;
import main.java.basePattern.taxSystem.ISalesTaxService;
import main.java.basePattern.taxSystem.Product;

import java.math.BigDecimal;

public class SalesTaxAPIGateway implements ISalesTaxService {

    @Override
    public BigDecimal getSalesTaxAmount(Country country, Product product, Customer customer) throws Exception {
        String countryAbbreviation;

        switch (country.get_countryName().toLowerCase()){
            case "monaco":
                countryAbbreviation = "MON";
                break;
            case "ireland":
                countryAbbreviation = "IRE";
                break;
            case "germany":
                countryAbbreviation = "GER";
                break;
            default:
                countryAbbreviation = "AUT";
                break;
        }

        BigDecimal result = SalesTaxAPIServiceStub.getSalesTaxRate(countryAbbreviation, product.get_product(),
                customer.get_customer());

        if(result.equals(new BigDecimal("-1.0000"))){
            throw new Exception("Some value was wrong!");
        }

        return result;
    }
}

package main.java.basePattern.taxSystem;

import main.java.basePattern.plugin.SalesTaxGatewayFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

public class SalesTaxCalculator {
    private ISalesTaxService _salesTaxService;

    private BufferedReader _reader;

    public SalesTaxCalculator(String currentEnvironment, BufferedReader reader) {
        SalesTaxGatewayFactory salesTaxGatewayFactory = new SalesTaxGatewayFactory();
        try {
            this._salesTaxService = salesTaxGatewayFactory.getSalesTaxService(currentEnvironment);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this._reader = reader;
    }

    public void calculateSalesTaxes() throws IOException {
        System.out.println("Connected to service: " + _salesTaxService.getClass());

        System.out.println("Type exit to exit or calculate sales taxes via addressing the database via {countryname} " +
                "{product} {customer}");

        String input = _reader.readLine();
        String[] inputArray = input.split(" ");
        while (!inputArray[0].equalsIgnoreCase("exit")){
            try{
                BigDecimal result = _salesTaxService.getSalesTaxAmount(new Country(inputArray[0].toLowerCase()),
                        new Product(inputArray[1].toLowerCase()), new Customer(inputArray[2].toLowerCase()));
                System.out.println("Sales tax rate would be: " + result.toString());
            }catch (Exception e){
                System.out.println(e.toString());
            }
            System.out.println("Type exit to exit or calculate sales taxes via addressing the database via {countryname} " +
                    "{product} {customer}");

            input = _reader.readLine();
            inputArray = input.split(" ");
        }
    }
}

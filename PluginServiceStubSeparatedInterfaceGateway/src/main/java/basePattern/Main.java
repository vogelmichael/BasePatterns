package main.java.basePattern;

import main.java.basePattern.taxSystem.SalesTaxCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Please enter current environment: development or production");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String environment = reader.readLine();
        while(!environment.equals("development") && !environment.equals("production")){
            System.out.println("Try again!");
            environment = reader.readLine();
        }

        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(environment, reader);
        salesTaxCalculator.calculateSalesTaxes();
    }
}

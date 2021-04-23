package RegistrySpecialCaseLayerSupertypeRecordSet.UI;

import RegistrySpecialCaseLayerSupertypeRecordSet.persistence.CustomerRegistry;
import RegistrySpecialCaseLayerSupertypeRecordSet.persistence.EmployeeRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {
    private CustomerRegistry customerRegistry;
    private EmployeeRegistry employeeRegistry;

    public CommandLine(CustomerRegistry customerRegistry, EmployeeRegistry employeeRegistry) {
        this.customerRegistry = customerRegistry;
        this.employeeRegistry = employeeRegistry;
    }

    public void start() throws IOException {
        System.out.println("Command line starting... type \"exit\" to close the process.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while(!str.equals("exit")) {
            System.out.println(handleInput(str));
            str = reader.readLine();
        }
    }

    private String handleInput(String str) {
        String[] strings = str.split(" ");
        if(strings.length >= 2) {
            String command = strings[0];
            int id;
            try {
                id = Integer.parseInt(strings[1]);
            } catch (NumberFormatException e) {
                return "Invalid command!";
            }

            switch (command) {
                case "customer":
                    return customerRegistry.getByID(id).toString();

                case "employee":
                    return employeeRegistry.getByID(id).toString();
            }
        }
        return "Invalid command!";
    }
}

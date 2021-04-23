package RegistrySpecialCaseLayerSupertypeRecordSet;

import RegistrySpecialCaseLayerSupertypeRecordSet.UI.CommandLine;
import RegistrySpecialCaseLayerSupertypeRecordSet.domain.Customer;
import RegistrySpecialCaseLayerSupertypeRecordSet.domain.Employee;
import RegistrySpecialCaseLayerSupertypeRecordSet.persistence.CustomerRegistry;
import RegistrySpecialCaseLayerSupertypeRecordSet.persistence.EmployeeRegistry;
import java.io.IOException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) throws IOException {
        CustomerRegistry customerRegistry = new CustomerRegistry();
        EmployeeRegistry employeeRegistry = new EmployeeRegistry();
        setUptestData(customerRegistry, employeeRegistry);
        CommandLine ui = new CommandLine(customerRegistry, employeeRegistry);
        ui.start();
    }

    private static void setUptestData(CustomerRegistry customerRegistry, EmployeeRegistry employeeRegistry) {
        Customer c1 = new Customer();
        Customer c2 = new Customer("Sam", null, LocalDate.of(1983,4,1));
        Customer c3 = new Customer("Luise", "Jones", LocalDate.of(1971, 1, 17));
        customerRegistry.add(c1,c2,c3);

        Employee e1 = new Employee(4511347);
        Employee e2 = new Employee();
        employeeRegistry.add(e1, e2);
    }
}

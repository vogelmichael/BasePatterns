package RegistrySpecialCaseLayerSupertypeRecordSet.persistence;

import RegistrySpecialCaseLayerSupertypeRecordSet.domain.Customer;
import RegistrySpecialCaseLayerSupertypeRecordSet.domain.MissingCustomer;
import RegistrySpecialCaseLayerSupertypeRecordSet.domain.UnknownCustomer;

public class CustomerRegistry extends RegistrySupertype<Customer> {

    public CustomerRegistry() {
        super();
    }

    @Override
    public Customer getByID(int ID) {
        Customer customer = super.getByID(ID);
        if(customer == null) {
            return new MissingCustomer();
        }
        if(customer.getId() < 0 || customer.getForename() == null || customer.getSurname() == null || customer.getBirthDate() == null) {
            return new UnknownCustomer(customer.getId(), customer.getSurname(), customer.getForename(), customer.getBirthDate());
        }
        return customer;
    }
}

package RegistrySpecialCaseLayerSupertypeRecordSet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends DomainSupertype{
    private int identificationNumber;

    public Employee(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Employee() {}

    @Column()
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identificationNumber=" + identificationNumber +
                '}';
    }
}

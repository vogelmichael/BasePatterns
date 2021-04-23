package RegistrySpecialCaseLayerSupertypeRecordSet.domain;

import java.time.LocalDate;

public class MissingCustomer extends Customer {

    public MissingCustomer() {
        super.setId(-111111);
    }

    @Override
    public int getId() {
        int id = super.getId();
        if(id <= 0) {
            return -111111;
        }
        return id;
    }

    @Override
    public String getForename() {
        String forename = super.getForename();
        if(forename == null) {
            return "No customer in DB";
        }
        return forename;
    }

    @Override
    public String getSurname() {
        String surname = super.getSurname();
        if(surname == null) {
            return "No customer in DB";
        }
        return surname;
    }

    @Override
    public LocalDate getBirthDate() {
        LocalDate birthDate = super.getBirthDate();
        if(birthDate == null) {
            return LocalDate.of(11,11,11);
        }
        return birthDate;
    }

    @Override
    public String toString() {
        return "MissingCustomer{" +
                "id=" + super.getId() +
                ", forename='" + getForename() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}

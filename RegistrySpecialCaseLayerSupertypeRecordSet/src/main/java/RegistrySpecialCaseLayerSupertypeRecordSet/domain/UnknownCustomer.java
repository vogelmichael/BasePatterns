package RegistrySpecialCaseLayerSupertypeRecordSet.domain;

import java.time.LocalDate;

public class UnknownCustomer extends Customer {
    private String forename;
    private String surname;
    private LocalDate birthDate;

    public UnknownCustomer(int ID, String forename, String surname, LocalDate birthDate) {
        super.setId(ID);
        this.forename = forename;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public UnknownCustomer() {}

    @Override
    public int getId() {
        int id = super.getId();
        if(id <= 0) {
            return -1;
        }
        return id;
    }

    @Override
    public String getForename() {
        if(forename == null) {
            return "No forename specified";
        }
        return forename;
    }

    @Override
    public String getSurname() {
        if(surname == null) {
            return "No surname specified";
        }
        return surname;
    }

    @Override
    public LocalDate getBirthDate() {
        if(birthDate == null) {
            return LocalDate.of(1,1,1);
        }
        return birthDate;
    }

    @Override
    public String toString() {
        return "UnknownCustomer{" +
                "id=" + getId() +
                ", forename='" + getForename() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}

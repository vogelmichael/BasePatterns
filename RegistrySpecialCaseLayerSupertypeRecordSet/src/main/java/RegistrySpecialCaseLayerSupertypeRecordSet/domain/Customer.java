package RegistrySpecialCaseLayerSupertypeRecordSet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends DomainSupertype {
    private String forename;
    private String surname;
    private LocalDate birthDate;

    public Customer(String forename, String surname, LocalDate birthDate) {
        this.forename = forename;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Customer() {}

    @Column()
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Column()
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column()
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

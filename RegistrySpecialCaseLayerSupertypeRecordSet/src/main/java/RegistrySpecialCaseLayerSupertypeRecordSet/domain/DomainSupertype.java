package RegistrySpecialCaseLayerSupertypeRecordSet.domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class DomainSupertype {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

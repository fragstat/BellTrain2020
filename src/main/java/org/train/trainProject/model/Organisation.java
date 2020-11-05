package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor
@Entity(name = "Organisation")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "org_name", length = 50, nullable = false)
    private String orgName;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;

    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    @Column(name = "address", length = 75, nullable = false)
    private String address;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public Organisation(String orgName, String fullName, String inn, String kpp, String address, String phone,
                        Boolean isActive) {
        this.orgName = orgName;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organisation(Long id, String orgName, String fullName, String inn, String kpp, String address, String phone,
                        Boolean isActive) {
        this.id = id;
        this.orgName = orgName;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}

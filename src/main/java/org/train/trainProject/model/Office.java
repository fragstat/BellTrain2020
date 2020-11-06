package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@NoArgsConstructor
@Data
@Entity(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "office_name", length = 25)
    private String name;

    @Column(name = "address", length = 75)
    private String address;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @JoinColumn(name = "org_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organisation orgId;

    public Office(String name, String address, String phone, Boolean isActive, Organisation orgId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.orgId = orgId;
    }

    public Office(Organisation orgId, String name, String address, String phone, Boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Office(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}

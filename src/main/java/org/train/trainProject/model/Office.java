package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Офис
 */
@NoArgsConstructor
@Data
@Entity(name = "Office")
public class Office {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Название офиса
     */
    @Column(name = "office_name", length = 25)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", length = 75)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Активна ли
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Идентификатор организаии, которой принадлежит офис
     */
    @JoinColumn(name = "org_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Organisation organisation;

    public Office(String name, String address, String phone, Boolean isActive, Organisation organisation) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.organisation = organisation;
    }

    public Office(Organisation organisation, String name, String address, String phone, Boolean isActive) {
        this.organisation = organisation;
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

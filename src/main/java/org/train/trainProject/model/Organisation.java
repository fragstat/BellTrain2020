package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Организация
 */
@Data
@NoArgsConstructor
@Entity(name = "Organisation")
public class Organisation {

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
     * Название организации
     */
    @Column(name = "org_name", length = 50, nullable = false)
    private String orgName;

    /**
     * Полное название организации
     */
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 75, nullable = false)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Активна ли
     */
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

    public Organisation(Long id, String orgName, String fullName, String inn, String kpp, String address) {
        this.id = id;
        this.orgName = orgName;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
    }
}

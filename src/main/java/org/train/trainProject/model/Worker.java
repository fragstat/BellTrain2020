package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Пользователь
 */
@Data
@Entity(name = "Worker")
@NoArgsConstructor
public class Worker {

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
     * Имя
     */
    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 25)
    private String secondName;

    /**
     * Отчество/среднее имя
     */
    @Column(name = "middle_name", length = 25)
    private String middleName;

    /**
     * Должность
     */
    @Column(name = "position_value", length = 50, nullable = false)
    private String position;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 11)
    private String phone;

    /**
     * Идентифицирован ли
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Документ
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private UserDocument document;

    /**
     * Код гражданства
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_code")
    private Country citizenshipCode;

    /**
     * Уникальный идентификатор офиса
     */
    @JoinColumn(name = "office_id", nullable = false)
    @ManyToOne
    private Office officeId;


    public Worker(String firstName, String secondName, String middleName, String position, String phone,
                  Boolean isIdentified, Office office) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.officeId = office;
    }

}

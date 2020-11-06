package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "Worker")
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 25)
    private String secondName;

    @Column(name = "middle_name", length = 25)
    private String middleName;

    @Column(name = "position_value", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "document")
    private UserDocument document;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_code")
    private Country citizenshipCode;

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

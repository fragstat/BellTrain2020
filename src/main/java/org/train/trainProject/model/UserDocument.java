package org.train.trainProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "User_Document")
public class UserDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "doc_number", length = 20)
    private String docNumber;

    @Basic
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Calendar docDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Worker user;

    @ManyToOne
    @JoinColumn(name = "doc_code")
    private DocumentType docCode;
}

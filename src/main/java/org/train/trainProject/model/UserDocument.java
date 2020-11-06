package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "User_Document")
@NoArgsConstructor
public class UserDocument {

    @Id
    @Column(name = "worker_id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "doc_number", length = 20)
    private String docNumber;

    @Basic
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Worker user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code")
    private DocumentType docCode;

    public UserDocument(Long id, String docNumber, Date docDate, Worker user, DocumentType docCode) {
        this.id = id;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.user = user;
        this.docCode = docCode;
    }
}

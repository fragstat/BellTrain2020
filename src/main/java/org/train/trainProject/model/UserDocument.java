package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Документ
 */
@Data
@Entity
@Table(name = "User_Document")
@NoArgsConstructor
public class UserDocument {

    /**
     * Уникальный идентификатор
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", length = 20)
    private String docNumber;

    /**
     * Дата документа
     */
    @Basic
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    /**
     * Пользователь, которому принадлежит документ
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Worker user;

    /**
     * Код документа
     */
    @ManyToOne
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

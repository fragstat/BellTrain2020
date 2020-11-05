package org.train.trainProject.model;

import lombok.Data;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@Entity(name = "Document_Type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doc_name", length = 100, nullable = false)
    private String docName;

    @Column(name = "code", nullable = false)
    private Integer code;
}

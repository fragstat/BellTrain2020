package org.train.trainProject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor
@Entity(name = "Document_Type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doc_name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "code", nullable = false)
    private Integer code;

    public DocumentType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
}

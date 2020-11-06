package org.train.trainProject.dao.documenttype;

import org.train.trainProject.model.DocumentType;

import java.util.List;

public interface DocumentTypeDao {

    DocumentType getById(Long id);

    DocumentType getByCode(Integer code);

    DocumentType getByName(String name);

    void save(DocumentType documentType);

    List<DocumentType> getAll();
}

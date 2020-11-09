package org.train.trainProject.dao.documenttype;

import org.train.trainProject.model.DocumentType;
import java.util.List;

/**
 * DAO для работы с {@link DocumentType}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface DocumentTypeDao {

    /**
     * Получить DocumentType по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link DocumentType}
     */
    DocumentType getById(Long id);

    /**
     * Получить DocumentType по коду
     *
     * @param code код документа
     * @return {@link DocumentType}
     */
    DocumentType getByCode(Integer code);

    /**
     * Получить DocumentType по названию
     *
     * @param name название
     * @return {@link DocumentType}
     */
    DocumentType getByName(String name);

    /**
     * Сохранить DocumentType
     *
     * @param documentType
     */
    void save(DocumentType documentType);

    /**
     * Получить все DocumentType
     *
     * @return {@link DocumentType}
     */
    List<DocumentType> getAll();
}

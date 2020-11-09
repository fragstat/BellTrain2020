package org.train.trainProject.dao.userdocument;

import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.UserDocument;

/**
 * DAO для работы с {@link UserDocument}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface UserDocumentDao {

    /**
     * Сохранить UserDocument
     *
     * @param userDocument
     */
    void save(UserDocument userDocument);

    /**
     * Обновить UserDocument
     *
     * @param userDocument
     */
    void update(UserDocument userDocument);

    /**
     * Получить UserDocument по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link UserDocument}
     */
    UserDocument getById(Long id);
}

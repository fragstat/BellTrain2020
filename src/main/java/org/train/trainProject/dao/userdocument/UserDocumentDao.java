package org.train.trainProject.dao.userdocument;

import org.train.trainProject.model.UserDocument;

public interface UserDocumentDao {

    void save(UserDocument userDocument);

    void update(UserDocument userDocument);

    UserDocument getById(Long id);
}

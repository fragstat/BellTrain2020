package org.train.trainProject.dao.userdocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.UserDocument;

import javax.persistence.EntityManager;

@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {
    private final EntityManager em;

    @Autowired
    public UserDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(UserDocument userDocument) {
        em.persist(userDocument);
    }

    @Override
    public void update(UserDocument userDocument) {
        em.persist(userDocument);
    }

    @Override
    public UserDocument getById(Long id) {
        return em.find(UserDocument.class, id);
    }
}

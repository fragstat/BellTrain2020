package org.train.trainProject.dao.userdocument;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.UserDocument;

import javax.persistence.EntityManager;

/**
 * {@link UserDocumentDao}
 */
@Repository
public class UserDocumentDaoImpl implements UserDocumentDao {
    private final EntityManager em;

    @Autowired
    public UserDocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@link UserDocumentDao#save}
     */
    @Override
    public void save(UserDocument userDocument) {
        em.persist(userDocument);
    }

    /**
     * {@link UserDocumentDao#update}
     */
    @Override
    public void update(UserDocument userDocument) {
        Session session = em.unwrap(Session.class);
        session.update(userDocument);
    }

    /**
     * {@link UserDocumentDao#getById}
     */
    @Override
    public UserDocument getById(Long id) {
        return em.find(UserDocument.class, id);
    }
}

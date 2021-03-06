package org.train.trainProject.dao.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getById(Long id) {
        return em.find(DocumentType.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getByCode(Integer code) {
        String queryString = "SELECT dt FROM Document_Type dt WHERE dt.code = :code";
        TypedQuery<DocumentType> query = em.createQuery(queryString, DocumentType.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentType getByName(String name) {
        String queryString = "SELECT dt FROM Document_Type dt WHERE dt.name = :name";
        TypedQuery<DocumentType> query = em.createQuery(queryString, DocumentType.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(DocumentType documentType) {
        em.persist(documentType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentType> getAll() {
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM Document_Type d", DocumentType.class);
        return query.getResultList();
    }

    private CriteriaQuery<DocumentType> buildCodeCriteria(Integer code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);

        Root<DocumentType> documentTypeRoot = criteria.from(DocumentType.class);
        criteria.where(builder.equal(documentTypeRoot.get("code"), code));

        return criteria;
    }

    private CriteriaQuery<DocumentType> buildNameCriteria(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);

        Root<DocumentType> documentTypeRoot = criteria.from(DocumentType.class);
        criteria.where(builder.equal(documentTypeRoot.get("name"), code));

        return criteria;
    }
}

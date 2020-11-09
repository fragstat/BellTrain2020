package org.train.trainProject.dao.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@link DocumentTypeDao}
 */
@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@link DocumentTypeDao#getById}
     */
    @Override
    public DocumentType getById(Long id) {
        return em.find(DocumentType.class, id);
    }

    /**
     * {@link DocumentTypeDao#getByCode}
     */
    @Override
    public DocumentType getByCode(Integer code) {
        CriteriaQuery<DocumentType> criteria = buildCodeCriteria(code);
        TypedQuery<DocumentType> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    /**
     * {@link DocumentTypeDao#getByName}
     */
    @Override
    public DocumentType getByName(String name) {
        CriteriaQuery<DocumentType> criteria = buildNameCriteria(name);
        TypedQuery<DocumentType> query = em.createQuery(criteria);
        return query.getSingleResult();
    }

    /**
     * {@link DocumentTypeDao#save}
     */
    @Override
    public void save(DocumentType documentType) {
        em.persist(documentType);
    }

    /**
     * {@link DocumentTypeDao#getAll}
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

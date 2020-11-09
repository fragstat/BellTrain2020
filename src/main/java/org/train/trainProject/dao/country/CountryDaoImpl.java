package org.train.trainProject.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.Country;
import org.train.trainProject.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@link CountryDao}
 */
@Repository
public class CountryDaoImpl implements CountryDao {
    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@link CountryDao#getById}
     */
    @Override
    public Country getById(Long id) {
        return em.find(Country.class, id);
    }

    /**
     * {@link CountryDao#getByCode}
     */
    @Override
    public Country getByCode(Integer code) {
        String queryString = "SELECT c FROM Country c WHERE c.code = :code";
        TypedQuery<Country> query = em.createQuery(queryString, Country.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    /**
     * {@link CountryDao#save}
     */
    @Override
    public void save(Country country) {
        em.persist(country);
    }

    /**
     * {@link CountryDao#getAll}
     */
    @Override
    public List<Country> getAll() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }

    private CriteriaQuery<Country> buildCriteria(Integer code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

        Root<Country> countryRoot = criteria.from(Country.class);
        criteria.where(builder.equal(countryRoot.get("code"), code));

        return criteria;
    }
}

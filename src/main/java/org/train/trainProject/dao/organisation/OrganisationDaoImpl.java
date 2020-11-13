package org.train.trainProject.dao.organisation;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.organisation.OrganisationListInView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link OrganisationDao}
 */
@Repository
public class OrganisationDaoImpl implements OrganisationDao {

    private final EntityManager em;

    @Autowired
    public OrganisationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@link OrganisationDao#list}
     */
    @Override
    public List<Organisation> list(OrganisationListInView inView) {
        CriteriaQuery<Organisation> criteria = builder(inView.name, inView.inn, inView.isActive);
        TypedQuery<Organisation> query = em.createQuery(criteria);
        return query.getResultList();
    }

    /**
     * {@link OrganisationDao#loadById}
     */
    @Override
    public Organisation loadById(Long id) {
        return em.find(Organisation.class, id);
    }

    /**
     * {@link OrganisationDao#update}
     */
    @Override
    @Transactional
    public void update(Organisation organisation) {
        try (Session session = em.unwrap(Session.class)) {
            session.update(organisation);
            session.flush();
        }
    }

    /**
     * {@link OrganisationDao#save}
     */
    @Override
    public void save(Organisation organisation) {
        em.persist(organisation);
    }

    private CriteriaQuery<Organisation> builder(String name, String inn, Boolean isActive) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Organisation> cq = qb.createQuery(Organisation.class);
        Root<Organisation> organisation = cq.from(Organisation.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(qb.equal(organisation.get("orgName"), name));
        if (inn != null) {
            predicates.add(
                    qb.equal(organisation.get("inn"), inn));
        }
        if (isActive != null) {
            predicates.add(
                    qb.equal(organisation.get("isActive"), isActive));
        }
        cq.select(organisation)
                .where(predicates.toArray(new Predicate[]{}));
        return cq;
    }
}

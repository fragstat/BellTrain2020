package org.train.trainProject.dao.office;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.model.Office;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.office.OfficeListInView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Office> list(OfficeListInView inView) {
        CriteriaQuery<Office> criteria = builder(inView.orgId, inView.name, inView.phone, inView.isActive);
        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    @Transactional
    public void update(Office office) {
        Session session = em.unwrap(Session.class);
        session.update(office);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    private CriteriaQuery<Office> builder(Long id, String name, String phone, Boolean isActive) {
        Organisation organisation = em.find(Organisation.class, id);
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Office> cq = qb.createQuery(Office.class);
        Root<Office> office = cq.from(Office.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(qb.equal(office.get("organisation"), organisation));
        if (name != null) {
            predicates.add(
                    qb.equal(office.get("name"), name));
        }
        if (phone != null) {
            predicates.add(
                    qb.equal(office.get("phone"), phone));
        }
        if (isActive != null) {
            predicates.add(
                    qb.equal(office.get("isActive"), isActive));
        }
        cq.select(office)
                .where(predicates.toArray(new Predicate[]{}));
        return cq;
    }
}

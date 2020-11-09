package org.train.trainProject.dao.worker;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.train.trainProject.model.Worker;
import org.train.trainProject.view.worker.WorkerListView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link WorkerDao}
 */
@Repository
public class WorkerDaoImpl implements WorkerDao {
    private final EntityManager em;

    @Autowired
    public WorkerDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@link WorkerDao#save}
     */
    @Override
    public void save(Worker worker) {
        em.persist(worker);
    }

    /**
     *  {@link WorkerDao#update}
     */
    @Override
    public void update(Worker worker) {
        Session session = em.unwrap(Session.class);
        session.update(worker);
    }

    /**
     *  {@link WorkerDao#getById}
     */
    @Override
    public Worker getById(Long id) {
        return em.find(Worker.class, id);
    }

    /**
     *  {@link WorkerDao#list}
     */
    @Override
    public List<Worker> list(WorkerListView workerListView) {
        CriteriaQuery<Worker> criteria = builder(workerListView.officeId, workerListView.firstName,
                workerListView.lastName, workerListView.middleName, workerListView.position, workerListView.docCode,
                workerListView.citizenshipCode);
        TypedQuery<Worker> query = em.createQuery(criteria);
        return query.getResultList();
    }

    private CriteriaQuery<Worker> builder(Long officeId, String firstName, String lastName, String middleName,
                                          String position, Integer docCode, Integer citizenshipCode) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Worker> cq = qb.createQuery(Worker.class);
        Root<Worker> worker = cq.from(Worker.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(qb.equal(worker.get("officeId"), officeId));
        if (firstName != null) {
            predicates.add(
                    qb.equal(worker.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(
                    qb.equal(worker.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicates.add(
                    qb.equal(worker.get("middleName"), middleName));
        }
        if (position != null) {
            predicates.add(
                    qb.equal(worker.get("position"), position));
        }
        if (docCode != null) {
            predicates.add(
                    qb.equal(worker.get("docCode"), docCode));
        }
        if (citizenshipCode != null) {
            predicates.add(
                    qb.equal(worker.get("citizenshipCode"), citizenshipCode));
        }
        cq.select(worker)
                .where(predicates.toArray(new Predicate[]{}));
        return cq;
    }
}

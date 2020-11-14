package org.train.trainProject.service.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.organisation.OrganisationDao;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.service.office.OfficeService;
import org.train.trainProject.view.organisation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganisationServiceImpl implements OrganisationService {
    private final OrganisationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganisationServiceImpl(OrganisationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(@Valid OrganisationSaveView saveView) {
        Organisation organisation = new Organisation(saveView.name, saveView.fullName, saveView.inn, saveView.kpp,
                saveView.address, saveView.phone, saveView.isActive);
        dao.save(organisation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(@Valid OrganisationUpdateView updateView) {
        Organisation org = dao.loadById(updateView.id);
        if (org == null) {
            throw new NoResultException("attempt to update organisation, which doesnt exist");
        }
        org.setOrgName(updateView.name);
        org.setFullName(updateView.fullName);
        org.setInn(updateView.inn);
        org.setKpp(updateView.kpp);
        org.setAddress(updateView.address);
        org.setPhone(updateView.phone);
        org.setIsActive(updateView.isActive);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganisationListOutView> list(@Valid OrganisationListInView organizationView) {
        try {
            List<Organisation> filter = dao.list(organizationView);
            return mapperFacade.mapAsList(filter, OrganisationListOutView.class);
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OrganisationGetView getById(Long id) {
        Organisation organisation = dao.loadById(id);
        if (organisation == null) {
            throw new NoResultException("no such organisation");
        }
        return mapperFacade.map(organisation, OrganisationGetView.class);
    }
}

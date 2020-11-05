package org.train.trainProject.service.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.organisation.OrganisationDao;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.organisation.*;

import javax.validation.Valid;
import java.util.List;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private final OrganisationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganisationServiceImpl(OrganisationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }


    @Override
    @Transactional
    public void save(@Valid OrganisationSaveView saveView) {
        Organisation organisation = new Organisation(saveView.name, saveView.fullName, saveView.inn, saveView.kpp,
                saveView.address, saveView.phone, saveView.isActive);
        dao.save(organisation);
    }

    @Override
    @Transactional
    public void update(@Valid OrganisationUpdateView updateView) {
        Organisation organisation = new Organisation(updateView.id, updateView.name, updateView.fullName,
                updateView.inn, updateView.kpp, updateView.address, updateView.phone, updateView.isActive);
        dao.update(organisation);
    }

    @Override
    public List<OrganisationListOutView> list(@Valid OrganisationListInView organizationView) {
        List<Organisation> filter = dao.list(organizationView);
        return mapperFacade.mapAsList(filter, OrganisationListOutView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OrganisationGetView getById(Long id) {
        Organisation organisation = dao.loadById(id);
        return mapperFacade.map(organisation, OrganisationGetView.class);
    }
}

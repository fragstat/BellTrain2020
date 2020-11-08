package org.train.trainProject.service.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.organisation.OrganisationDao;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.service.office.OfficeService;
import org.train.trainProject.view.organisation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * {@link OrganisationService}
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
     * {@link OrganisationService#save}
     */
    @Override
    @Transactional
    public void save(@Valid OrganisationSaveView saveView) {
        Organisation organisation = new Organisation(saveView.name, saveView.fullName, saveView.inn, saveView.kpp,
                saveView.address, saveView.phone, saveView.isActive);
        dao.save(organisation);
    }

    /**
     * {@link OrganisationService#update}
     */
    @Override
    @Transactional
    public void update(@Valid OrganisationUpdateView updateView) {
        Organisation organisation = new Organisation(updateView.id, updateView.name, updateView.fullName,
                updateView.inn, updateView.kpp, updateView.address);
        if (updateView.phone != null) {
            organisation.setPhone(updateView.phone);
        }
        if (updateView.isActive != null) {
            organisation.setIsActive(updateView.isActive);
        }
        dao.update(organisation);
    }

    /**
     * {@link OrganisationService#list}
     */
    @Override
    @Transactional
    public List<OrganisationListOutView> list(@Valid OrganisationListInView organizationView) {
        List<Organisation> filter = dao.list(organizationView);
        return mapperFacade.mapAsList(filter, OrganisationListOutView.class);
    }

    /**
     * {@link OrganisationService#getById}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganisationGetView getById(Long id) {
        Organisation organisation = dao.loadById(id);
        return mapperFacade.map(organisation, OrganisationGetView.class);
    }
}

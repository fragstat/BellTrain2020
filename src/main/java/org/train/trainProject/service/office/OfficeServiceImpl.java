package org.train.trainProject.service.office;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.office.OfficeDao;
import org.train.trainProject.dao.organisation.OrganisationDao;
import org.train.trainProject.model.Office;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.office.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeDao officeDao;
    private final OrganisationDao organisationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganisationDao organisationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organisationDao = organisationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(@Valid OfficeSaveView saveView) {
        Organisation org = organisationDao.loadById(saveView.orgId);
        if (org == null) {
            throw new NoResultException("no such organisation");
        }
        Office office = new Office(org, saveView.name, saveView.address,
                saveView.phone, saveView.isActive);
        officeDao.save(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(@Valid OfficeUpdateView updateView) {
        Office office = officeDao.loadById(updateView.id);
        if (office == null) {
            throw new NoResultException("attempt to update office, which doesnt exist");
        }
        office.setName(updateView.name);
        office.setAddress(updateView.address);
        office.setPhone(updateView.phone);
        office.setIsActive(updateView.isActive);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeListOutView> list(@Valid OfficeListInView officeListInView) {
            List<Office> all = officeDao.list(officeListInView);
            return mapperFacade.mapAsList(all, OfficeListOutView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeGetView getById(Long id) {
        Office office = officeDao.loadById(id);
        if (office == null) {
            throw new NoResultException("no such office");
        }
        return mapperFacade.map(office, OfficeGetView.class);
    }
}

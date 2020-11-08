package org.train.trainProject.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.office.OfficeDao;
import org.train.trainProject.dao.organisation.OrganisationDao;
import org.train.trainProject.model.Office;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.office.*;

import javax.validation.Valid;
import java.util.List;

/**
 * {@link OfficeService}
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
     * {@link OfficeService#save}
     */
    @Override
    @Transactional
    public void save(@Valid OfficeSaveView saveView) {
        Office office = new Office(organisationDao.loadById(saveView.orgId), saveView.name, saveView.address,
                saveView.phone, saveView.isActive);
        officeDao.save(office);
    }

    /**
     * {@link OfficeService#update}
     */
    @Override
    @Transactional
    public void update(@Valid OfficeUpdateView updateView) {
        Office office = new Office(updateView.id, updateView.name, updateView.address);
        if (updateView.phone != null) {
            office.setPhone(updateView.phone);
        }
        if (updateView.isActive != null) {
            office.setIsActive(updateView.isActive);
        }
        officeDao.update(office);
    }

    /**
     * {@link OfficeService#list}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeListOutView> list(@Valid OfficeListInView organizationView) {
        List<Office> all = officeDao.list(organizationView);
        return mapperFacade.mapAsList(all, OfficeListOutView.class);
    }

    /**
     * {@link OfficeService#getById}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeGetView getById(Long id) {
        Office office = officeDao.loadById(id);
        return mapperFacade.map(office, OfficeGetView.class);
    }
}

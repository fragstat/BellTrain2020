package org.train.trainProject.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.country.CountryDao;
import org.train.trainProject.model.Country;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.country.CountryView;

import javax.validation.Valid;
import java.util.List;

/**
 * {@link CountryService}
 */
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao, MapperFacade mapperFacade) {
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@link CountryService#save}
     */
    @Transactional
    @Override
    public void save(@Valid CountryView countryView) {
        Country country = new Country(countryView.code, countryView.name);
        countryDao.save(country);
    }

    /**
     * {@link CountryService#getById}
     */
    @Transactional
    @Override
    public CountryView getById(Long id) {
        Country country = countryDao.getById(id);
        return mapperFacade.map(country, CountryView.class);
    }

    /**
     * {@link CountryService#getByCode}
     */
    @Transactional
    @Override
    public CountryView getByCode(Integer code) {
        Country country = countryDao.getByCode(code);
        return mapperFacade.map(country, CountryView.class);
    }

    /**
     * {@link CountryService#getAll}
     */
    @Transactional
    @Override
    public List<CountryView> getAll() {
        List<Country> all = countryDao.getAll();
        return mapperFacade.mapAsList(all, CountryView.class);
    }
}

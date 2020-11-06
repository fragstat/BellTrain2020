package org.train.trainProject.dao.country;

import org.train.trainProject.model.Country;

import java.util.List;

public interface CountryDao {

    Country getById(Long id);

    Country getByCode(Integer code);

    void save(Country country);

    List<Country> getAll();
}

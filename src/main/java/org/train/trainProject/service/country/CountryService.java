package org.train.trainProject.service.country;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.view.country.CountryView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CountryService {

    void save(@Valid CountryView countryView);

    CountryView getById(Long id);

    CountryView getByCode(Integer code);

    List<CountryView> getAll();
}

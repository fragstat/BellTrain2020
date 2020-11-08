package org.train.trainProject.service.country;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.model.Country;
import org.train.trainProject.view.country.CountryView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для {@link Country}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
@Validated
public interface CountryService {

    /**
     * Сохраненить новую страну в БД
     *
     * @param countryView валидируемое DTO из контроллера
     */
    void save(@Valid CountryView countryView);

    /**
     * Получить страну по id
     *
     * @param id уникальный идентификатор страны
     * @return {@link CountryView}
     */
    CountryView getById(Long id);

    /**
     * Получить страну по коду
     *
     * @param code код страны
     * @return {@link CountryView}
     */
    CountryView getByCode(Integer code);

    /**
     * Получить все страны
     *
     * @return {@link CountryView}
     */
    List<CountryView> getAll();
}

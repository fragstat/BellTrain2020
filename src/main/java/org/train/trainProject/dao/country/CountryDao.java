package org.train.trainProject.dao.country;

import org.train.trainProject.model.Country;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.model.Office;

import java.util.List;

/**
 * DAO для работы с {@link Country}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface CountryDao {

    /**
     * Получить Country по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link Country}
     */
    Country getById(Long id);

    /**
     * Получить Country по коду
     *
     * @param code код документа
     * @return {@link Country}
     */
    Country getByCode(Integer code);

    /**
     * Сохранить Country
     *
     * @param country
     */
    void save(Country country);

    /**
     * Получить все Country
     *
     * @return {@link Country}
     */
    List<Country> getAll();
}

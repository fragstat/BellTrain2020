package org.train.trainProject.dao.office;

import org.train.trainProject.model.Office;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.office.OfficeListInView;

import java.util.List;

/**
 * DAO для работы с {@link Office}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface OfficeDao {

    /**
     * Фильтр по параметрам для Office
     *
     * @param inView DTO из контроллера
     * @return {@link Office}
     */
    List<Office> list(OfficeListInView inView);

    /**
     * Получить Office по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link Office}
     */
    Office loadById(Long id);

    /**
     * Обновить Office
     *
     * @param office
     */
    void update(Office office);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(Office office);
}

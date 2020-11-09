package org.train.trainProject.dao.organisation;

import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.organisation.OrganisationListInView;

import java.util.List;

/**
 * DAO Для работы с {@link Organisation}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface OrganisationDao {

    /**
     * Фильтр по параметрам для Organisation
     *
     * @param inView DTO из контроллера
     * @return {@link Organisation}
     */
    List<Organisation> list(OrganisationListInView inView);

    /**
     * Получить Organisation по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link Organisation}
     */
    Organisation loadById(Long id);

    /**
     * Обновить Organisation
     *
     * @param organisation
     */
    void update(Organisation organisation);

    /**
     * Сохранить Organisation
     *
     * @param organisation
     */
    void save(Organisation organisation);
}

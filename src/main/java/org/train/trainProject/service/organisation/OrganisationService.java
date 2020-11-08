package org.train.trainProject.service.organisation;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.model.Office;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.office.OfficeGetView;
import org.train.trainProject.view.office.OfficeListOutView;
import org.train.trainProject.view.organisation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для {@link Organisation}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
@Validated
public interface OrganisationService {

    /**
     * Сохраненить новую организацию в БД
     *
     * @param saveView валидируемое DTO из контроллера
     */
    void save(@Valid OrganisationSaveView saveView);

    /**
     * Обновить информацию об организации в БД
     *
     * @param updateView валидируемое DTO из контроллера
     */
    void update(@Valid OrganisationUpdateView updateView);

    /**
     * Фильтр организаций по параметрам
     *
     * @param organizationView валидируемое DTO из контроллера
     * @return {@link OrganisationListOutView} DTO после фильрации
     */
    List<OrganisationListOutView> list(@Valid OrganisationListInView organizationView);

    /**
     * Получить организацию по id
     *
     * @param id уникальный идентификатор организации
     * @return {@link OfficeGetView}
     */
    OrganisationGetView getById(Long id);

}

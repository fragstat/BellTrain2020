package org.train.trainProject.service.office;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.model.Office;
import org.train.trainProject.view.office.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для {@link Office}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
@Validated
public interface OfficeService {

    /**
     * Сохраненить новый офис в БД
     *
     * @param saveView валидируемое DTO из контроллера
     */
    void save(@Valid OfficeSaveView saveView);

    /**
     * Обновить информацию об офисе в БД
     *
     * @param updateView валидируемое DTO из контроллера
     */
    void update(@Valid OfficeUpdateView updateView);

    /**
     * Фильтр офисов по параметрам
     *
     * @param officeView валидируемое DTO из контроллера
     * @return {@link OfficeListOutView} DTO после фильрации
     */
    List<OfficeListOutView> list(@Valid OfficeListInView officeView);

    /**
     * Получить офис по id
     *
     * @param id уникальный идентификатор офиса
     * @return {@link OfficeGetView}
     */
    OfficeGetView getById(Long id);

}

package org.train.trainProject.service.worker;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.model.Office;
import org.train.trainProject.model.Worker;
import org.train.trainProject.view.office.OfficeGetView;
import org.train.trainProject.view.office.OfficeListOutView;
import org.train.trainProject.view.worker.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

/**
 * Сервис для {@link Worker}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
@Validated
public interface WorkerService {

    /**
     * Сохраненить нового пользователя в БД
     *
     * @param workerSaveView валидируемое DTO из контроллера
     */
    void save(@Valid WorkerSaveView workerSaveView) throws ParseException;

    /**
     * Получить пользователя по id
     *
     * @param id уникальный идентификатор пользователя
     * @return {@link WorkerGetView}
     */
    WorkerGetView getById(Long id);

    /**
     * Обновить информацию о пользователе в БД
     *
     * @param workerUpdateView валидируемое DTO из контроллера
     */
    void update(@Valid WorkerUpdateView workerUpdateView);

    /**
     * Фильтр пользователей по параметрам
     *
     * @param listView валидируемое DTO из контроллера
     * @return {@link WorkerListOutView} DTO после фильрации
     */
    List<WorkerListOutView> list(@Valid WorkerListView listView);
}

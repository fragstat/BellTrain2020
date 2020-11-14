package org.train.trainProject.dao.worker;

import org.train.trainProject.model.Country;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.model.Organisation;
import org.train.trainProject.model.Worker;
import org.train.trainProject.view.worker.WorkerListView;

import java.util.List;

/**
 * DAO для работы с {@link Worker}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
public interface WorkerDao {

    /**
     * Сохранить Worker
     *
     * @param worker
     */
    void save(Worker worker);

    /**
     * Обновить Organisation
     *
     * @param worker
     */
    void update(Worker worker);

    /**
     * Получить Worker по идентификатору
     *
     * @param id уникальный идентификатор
     * @return {@link Worker}
     */
    Worker getById(Long id);

    /**
     * Фильтр попараметрам для Worker
     *
     * @param workerListView DTO из контроллера
     * @return {@link Worker}
     */
    List<Worker> list(WorkerListView workerListView, Integer country, Integer docCode);
}

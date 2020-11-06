package org.train.trainProject.dao.worker;

import org.train.trainProject.model.Worker;
import org.train.trainProject.view.worker.WorkerListView;

import java.util.List;

public interface WorkerDao {

    void save(Worker worker);

    void update(Worker worker);

    Worker getById(Long id);

    List<Worker> list(WorkerListView workerListView);
}

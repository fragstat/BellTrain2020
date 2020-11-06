package org.train.trainProject.service.worker;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.view.worker.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface WorkerService {

    void save(@Valid WorkerSaveView workerSaveView);

    WorkerGetView getById(Long id);

    void update(@Valid WorkerUpdateView workerUpdateView);

    List<WorkerListOutView> list(@Valid WorkerListView listView);
}

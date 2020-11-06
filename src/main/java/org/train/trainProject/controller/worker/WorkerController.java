package org.train.trainProject.controller.worker;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.worker.WorkerService;
import org.train.trainProject.view.worker.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "WorkerController")
@RestController
@RequestMapping(value = "/api/user",produces = APPLICATION_JSON_VALUE)
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/save")
    private void saveWorker(@RequestBody WorkerSaveView saveView) {
        workerService.save(saveView);
    }

    @PostMapping("/update")
    private void updateWorker(@RequestBody WorkerUpdateView updateView) {
        workerService.update(updateView);
    }

    @PostMapping("/list")
    private List<WorkerListOutView> filter(@RequestBody WorkerListView listView) {
        return workerService.list(listView);
    }

    @GetMapping("/{id}")
    private WorkerGetView getView(@PathVariable Long id) {
        return workerService.getById(id);
    }
}

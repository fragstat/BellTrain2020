package org.train.trainProject.controller.worker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.worker.WorkerService;
import org.train.trainProject.view.worker.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "WorkerController", description = "Управление информацией о пользователях")
@RestController
@RequestMapping(value = "/api/user",produces = APPLICATION_JSON_VALUE)
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @ApiOperation(value = "Сохранить нового пользователя", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    private void saveWorker(@RequestBody WorkerSaveView saveView) {
        workerService.save(saveView);
    }

    @ApiOperation(value = "Обновить пользователя", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    private void updateWorker(@RequestBody WorkerUpdateView updateView) {
        workerService.update(updateView);
    }

    @ApiOperation(value = "Фильтровать пользователей", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    private List<WorkerListOutView> filter(@RequestBody WorkerListView listView) {
        return workerService.list(listView);
    }

    @ApiOperation(value = "Найти пользователя по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    private WorkerGetView getView(@PathVariable Long id) {
        return workerService.getById(id);
    }
}

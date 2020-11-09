package org.train.trainProject.controller.worker;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.worker.WorkerService;
import org.train.trainProject.view.worker.*;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

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
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    private ResponseEntity<Void> saveWorker(@RequestBody WorkerSaveView saveView) {
        try {
            workerService.save(saveView);
        } catch (ParseException e) {
            return ResponseEntity.status(500).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).build();
    }

    @ApiOperation(value = "Обновить пользователя", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    private ResponseEntity<?> updateWorker(@RequestBody WorkerUpdateView updateView) {
        try {
            workerService.update(updateView);
        } catch (NoResultException e) {
            return ResponseEntity.status(404).build();
        }
        catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.status(200).build();
    }

    @ApiOperation(value = "Фильтровать пользователей", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    private ResponseEntity<?> filter(@RequestBody WorkerListView listView) {
        try {
            return ResponseEntity.ok(workerService.list(listView));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Найти пользователя по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    private ResponseEntity<?> getView(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(workerService.getById(id));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

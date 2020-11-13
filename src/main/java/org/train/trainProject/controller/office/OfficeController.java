package org.train.trainProject.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.office.OfficeService;
import org.train.trainProject.view.aspect.SuccessView;
import org.train.trainProject.view.office.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/api/office",produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Сохранить новый офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity<SuccessView> officeSave(@RequestBody OfficeSaveView officeSaveView) {
        officeService.save(officeSaveView);
        return ResponseEntity.status(200).body(new SuccessView());
    }

    @ApiOperation(value = "Обновить офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public ResponseEntity<SuccessView> officeUpdate(@RequestBody OfficeUpdateView officeUpdateView) {
        officeService.update(officeUpdateView);
        return ResponseEntity.status(200).body(new SuccessView());
    }

    @ApiOperation(value = "Фильтровать офисы", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public @ResponseBody
    ResponseEntity<List<OfficeListOutView>> officeList(@RequestBody OfficeListInView officeListInView) {
        return ResponseEntity.ok(officeService.list(officeListInView));
    }

    @ApiOperation(value = "Найти офис по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    public ResponseEntity<OfficeGetView> officeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(officeService.getById(id));
    }

}

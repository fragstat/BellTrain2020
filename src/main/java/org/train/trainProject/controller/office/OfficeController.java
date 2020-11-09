package org.train.trainProject.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.office.OfficeService;
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
    public void officeSave(@RequestBody OfficeSaveView officeSaveView) {
        officeService.save(officeSaveView);
    }

    @ApiOperation(value = "Обновить офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void officeUpdate(@RequestBody OfficeUpdateView officeUpdateView) {
        officeService.update(officeUpdateView);
    }

    @ApiOperation(value = "Фильтровать офисы", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public @ResponseBody
    List<OfficeListOutView> officeList(@RequestBody OfficeListInView officeListInView) {
        return officeService.list(officeListInView);
    }

    @ApiOperation(value = "Найти офис по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    public OfficeGetView officeById(@PathVariable("id") Long id) {
        return officeService.getById(id);
    }

}

package org.train.trainProject.controller.organisation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.organisation.OrganisationService;
import org.train.trainProject.view.aspect.SuccessView;
import org.train.trainProject.view.organisation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganisationController", description = "Управление информацией об организации")
@RestController
@RequestMapping(value = "/api/organization",produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private final OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @ApiOperation(value = "Сохранить новую организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity<SuccessView> organizationSave(@RequestBody OrganisationSaveView organisationSaveView) {
        organisationService.save(organisationSaveView);
        return ResponseEntity.status(200).body(new SuccessView());
    }

    @ApiOperation(value = "Обновить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public ResponseEntity<SuccessView> organizationUpdate(@RequestBody OrganisationUpdateView organisationUpdateView) {
        organisationService.update(organisationUpdateView);
        return ResponseEntity.status(200).body(new SuccessView());
    }

    @ApiOperation(value = "Фильтровать организации", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public @ResponseBody
    List<OrganisationListOutView> organisationList(@RequestBody OrganisationListInView organisationListInView) {
        return organisationService.list(organisationListInView);
    }

    @ApiOperation(value = "Найти офис по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    public OrganisationGetView organisationById(@PathVariable("id") Long id) {
        return organisationService.getById(id);
    }
}

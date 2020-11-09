package org.train.trainProject.controller.organisation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.organisation.OrganisationService;
import org.train.trainProject.view.organisation.*;

import javax.validation.ConstraintViolationException;
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
    public ResponseEntity<String> organizationSave(@RequestBody OrganisationSaveView organisationSaveView) {
        try {
            organisationService.save(organisationSaveView);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.status(200).build();
    }

    @ApiOperation(value = "Обновить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public ResponseEntity<String> organizationUpdate(@RequestBody OrganisationUpdateView organisationUpdateView) {
        try {
            organisationService.update(organisationUpdateView);
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
        return ResponseEntity.status(200).build();
    }

    @ApiOperation(value = "Фильтровать организации", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public @ResponseBody
    ResponseEntity<?> organisationList(@RequestBody OrganisationListInView organisationListInView) {
        try {
            return ResponseEntity.ok(organisationService.list(organisationListInView));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @ApiOperation(value = "Найти офис по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/{id}")
    public ResponseEntity<?> organisationById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(organisationService.getById(id));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

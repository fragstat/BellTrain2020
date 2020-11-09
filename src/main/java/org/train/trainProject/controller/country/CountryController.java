package org.train.trainProject.controller.country;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.country.CountryService;
import org.train.trainProject.view.country.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(value = "CountryController", description = "Управление информацией о странах")
@RequestMapping(value = "/api/country",produces = APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @ApiOperation(value = "Сохранить новую страну", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveCountry(@RequestBody CountryView view) {
        countryService.save(view);
    }


    @ApiOperation(value = "Получить список всех стран", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/")
    public List<CountryView> getCountries() {
        return countryService.getAll();
    }

    @ApiOperation(value = "Получить страну по id", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/id/{id}")
    public CountryView getCountryById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @ApiOperation(value = "Получить страну по code", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/code/{code}")
    public CountryView getCountryByCode(@PathVariable Integer code) {
        return countryService.getByCode(code);
    }
}

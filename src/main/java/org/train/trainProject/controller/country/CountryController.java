package org.train.trainProject.controller.country;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.country.CountryService;
import org.train.trainProject.view.country.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(value = "CountryController")
@RequestMapping(value = "/api/country",produces = APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/save")
    public void saveCountry(@RequestBody CountryView view) {
        countryService.save(view);
    }

    @GetMapping("/")
    public List<CountryView> getCountries() {
        return countryService.getAll();
    }

    @GetMapping("/id/{id}")
    public CountryView getCountryById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @GetMapping("/code/{code}")
    public CountryView getCountryByCode(@PathVariable Integer code) {
        return countryService.getByCode(code);
    }
}

package org.train.trainProject.controller.organisation;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.organisation.OrganisationService;
import org.train.trainProject.view.organisation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganisationController")
@RestController
@RequestMapping(value = "/api/organisation",produces = APPLICATION_JSON_VALUE)
public class OrganisationController {

    private final OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping("/save")
    public void organizationSave(@RequestBody OrganisationSaveView organisationSaveView) {
        organisationService.save(organisationSaveView);
    }

    @PostMapping("/update")
    public void organizationUpdate(@RequestBody OrganisationUpdateView organisationUpdateView) {
        organisationService.update(organisationUpdateView);
    }

    @PostMapping("/list")
    public @ResponseBody
    List<OrganisationListOutView> organisationList(@RequestBody OrganisationListInView organisationListInView) {
        return organisationService.list(organisationListInView);
    }

    @GetMapping("/{id}")
    public OrganisationGetView organisationById(@PathVariable("id") Long id) {
        return organisationService.getById(id);
    }
}

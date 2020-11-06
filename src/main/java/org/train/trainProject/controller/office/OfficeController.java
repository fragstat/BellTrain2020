package org.train.trainProject.controller.office;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.office.OfficeService;
import org.train.trainProject.view.office.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController")
@RestController
@RequestMapping(value = "/api/office",produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/save")
    public void officeSave(@RequestBody OfficeSaveView officeSaveView) {
        officeService.save(officeSaveView);
    }

    @PostMapping("/update")
    public void officeUpdate(@RequestBody OfficeUpdateView officeUpdateView) {
        officeService.update(officeUpdateView);
    }

    @PostMapping("/list")
    public @ResponseBody
    List<OfficeListOutView> officeList(@RequestBody OfficeListInView officeListInView) {
        return officeService.list(officeListInView);
    }

    @GetMapping("/{id}")
    public OfficeGetView officeById(@PathVariable("id") Long id) {
        return officeService.getById(id);
    }

}

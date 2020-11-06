package org.train.trainProject.controller.documenttype;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.documenttype.DocumentTypeService;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(value = "DocumentTypeController")
@RequestMapping(value = "/api/docs",produces = APPLICATION_JSON_VALUE)
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @PostMapping("/save")
    public void saveDocumentType(@RequestBody DocumentTypeView view) {
        documentTypeService.save(view);
    }

    @GetMapping("/")
    public List<DocumentTypeView> getDocumentTypes() {
        return documentTypeService.getAll();
    }

    @GetMapping("/id/{id}")
    public DocumentTypeView getDocumentTypeById(@PathVariable Long id) {
        return documentTypeService.getById(id);
    }

    @GetMapping("/code/{code}")
    public DocumentTypeView getDocumentTypeByCode(@PathVariable Integer code) {
        return documentTypeService.getByCode(code);
    }
}

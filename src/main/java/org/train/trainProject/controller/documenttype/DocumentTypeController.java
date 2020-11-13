package org.train.trainProject.controller.documenttype;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.train.trainProject.service.documenttype.DocumentTypeService;
import org.train.trainProject.view.aspect.SuccessView;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Api(value = "DocumentTypeController", description = "Управление информацией о типах документов")
@RequestMapping(value = "/api/docs",produces = APPLICATION_JSON_VALUE)
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @ApiOperation(value = "Сохранить новую страну", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseEntity<SuccessView> saveDocumentType(@RequestBody DocumentTypeView view) {
        documentTypeService.save(view);
        return ResponseEntity.status(200).body(new SuccessView());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/")
    public ResponseEntity<List<DocumentTypeView>> getDocumentTypes() {
        return ResponseEntity.ok(documentTypeService.getAll());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/id/{id}")
    public ResponseEntity<DocumentTypeView> getDocumentTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(documentTypeService.getById(id));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/code/{code}")
    public ResponseEntity<DocumentTypeView> getDocumentTypeByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(documentTypeService.getByCode(code));
    }
}

package org.train.trainProject.service.documenttype;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface DocumentTypeService {

    void save(@Valid DocumentTypeView documentTypeView);

    DocumentTypeView getById(Long id);

    DocumentTypeView getByCode(Integer code);

    List<DocumentTypeView> getAll();

}

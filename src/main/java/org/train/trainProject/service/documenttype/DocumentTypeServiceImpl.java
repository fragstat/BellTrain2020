package org.train.trainProject.service.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.documenttype.DocumentTypeDao;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import javax.validation.Valid;
import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final MapperFacade mapperFacade;
    private final DocumentTypeDao dao;

    @Autowired
    public DocumentTypeServiceImpl(MapperFacade mapperFacade, DocumentTypeDao dao) {
        this.mapperFacade = mapperFacade;
        this.dao = dao;
    }

    @Transactional
    @Override
    public void save(@Valid DocumentTypeView documentTypeView) {
        DocumentType documentType = new DocumentType(documentTypeView.name, documentTypeView.code);
        dao.save(documentType);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentTypeView getById(Long id) {
        DocumentType documentType = dao.getById(id);
        return mapperFacade.map(documentType, DocumentTypeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentTypeView getByCode(Integer code) {
        DocumentType documentType = dao.getByCode(code);
        return mapperFacade.map(documentType, DocumentTypeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeView> getAll() {
        List<DocumentType> allDoc = dao.getAll();
        return mapperFacade.mapAsList(allDoc, DocumentTypeView.class);
    }
}

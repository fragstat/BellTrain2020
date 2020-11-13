package org.train.trainProject.service.documenttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.documenttype.DocumentTypeDao;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.List;

/**
 * {@link DocumentTypeService}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final MapperFacade mapperFacade;
    private final DocumentTypeDao dao;

    @Autowired
    public DocumentTypeServiceImpl(MapperFacade mapperFacade, DocumentTypeDao dao) {
        this.mapperFacade = mapperFacade;
        this.dao = dao;
    }

    /**
     * {@link DocumentTypeService#save}
     */
    @Transactional
    @Override
    public void save(@Valid DocumentTypeView documentTypeView) {
        DocumentType documentType = new DocumentType(documentTypeView.name, documentTypeView.code);
        dao.save(documentType);
    }

    /**
     * {@link DocumentTypeService#getById}
     */
    @Override
    @Transactional(readOnly = true)
    public DocumentTypeView getById(Long id) {
        DocumentType documentType = dao.getById(id);
        if (documentType == null) {
            throw new NoResultException("no such documentType");
        }
        return mapperFacade.map(documentType, DocumentTypeView.class);
    }

    /**
     * {@link DocumentTypeService#getByCode}
     */
    @Override
    @Transactional(readOnly = true)
    public DocumentTypeView getByCode(Integer code) {
        try {
            DocumentType documentType = dao.getByCode(code);
            return mapperFacade.map(documentType, DocumentTypeView.class);
        } catch (NoResultException e) {
            throw new NoResultException("no such documentType");
        }
    }

    /**
     * {@link DocumentTypeService#getAll
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeView> getAll() {
        List<DocumentType> allDoc = dao.getAll();
        return mapperFacade.mapAsList(allDoc, DocumentTypeView.class);
    }
}

package org.train.trainProject.service.worker;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.country.CountryDao;
import org.train.trainProject.dao.documenttype.DocumentTypeDao;
import org.train.trainProject.dao.office.OfficeDao;
import org.train.trainProject.dao.userdocument.UserDocumentDao;
import org.train.trainProject.dao.worker.WorkerDao;
import org.train.trainProject.model.*;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.aspect.SuccessView;
import org.train.trainProject.view.worker.*;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * {@inheritDoc}
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final UserDocumentDao userDocumentDao;
    private final WorkerDao workerDao;
    private final MapperFacade mapperFacade;
    private final DocumentTypeDao documentTypeDao;
    private final OfficeDao officeDao;
    private final CountryDao countryDao;

    @Autowired
    public WorkerServiceImpl(UserDocumentDao userDocumentDao, WorkerDao workerDao, MapperFacade mapperFacade, DocumentTypeDao documentTypeDao, OfficeDao officeDao, CountryDao countryDao) {
        this.userDocumentDao = userDocumentDao;
        this.workerDao = workerDao;
        this.mapperFacade = mapperFacade;
        this.documentTypeDao = documentTypeDao;
        this.officeDao = officeDao;
        this.countryDao = countryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void save(WorkerSaveView workerSaveView) throws NoResultException,
            ParseException {

        Office office = officeDao.loadById(workerSaveView.officeId);
        if (office == null) {
            throw new NoResultException("attempt to use office, which doesnt exist");
        }

        DocumentType documentType;
        try {
            documentType = documentTypeDao.getByCode(workerSaveView.docCode);
        } catch (EmptyResultDataAccessException e) {
            throw new NoResultException("attempt to use documentType, which doesnt exist");
        }

        Country country;
        try {
            country = countryDao.getByCode(workerSaveView.citizenshipCode);
        } catch (EmptyResultDataAccessException e) {
            throw new NoResultException("attempt to use citizenshipCode, which doesnt exist");
        }

        Worker worker = new Worker(workerSaveView.firstName, workerSaveView.secondName, workerSaveView.middleName,
                workerSaveView.position, workerSaveView.phone, workerSaveView.isIdentified, office, country);
        workerDao.save(worker);

        UserDocument userDocument = new UserDocument(worker.getId(), workerSaveView.docNumber,
                dateFormat.parse(workerSaveView.docDate), worker, documentType);
        userDocumentDao.save(userDocument);
        worker.setDocument(userDocument);

        workerDao.update(worker);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public WorkerGetView getById(Long id) {
        Worker worker = workerDao.getById(id);
        if (worker == null) {
            throw new NoResultException("no such worker");
        }
        UserDocument document = worker.getDocument();
        DocumentType documentType = document.getDocCode();
        Country country = worker.getCitizenshipCode();
        return new WorkerGetView(worker.getId(), worker.getFirstName(), worker.getSecondName(),
                worker.getMiddleName(),
                worker.getPosition(),
                worker.getPhone(),
                documentType.getName(),
                document.getDocNumber(),
                dateFormat.format(document.getDocDate()),
                country.getCountryName(),
                country.getCode(),
                worker.getIsIdentified());
    }

    /**
     * {@inheritDoc}
     */
    @SneakyThrows
    @Transactional
    @Override
    public void update(WorkerUpdateView workerUpdateView) {
        Worker worker = workerDao.getById(workerUpdateView.id);
        if (worker == null) {
            throw new NoResultException("attempt to update user, which doesnt exist");
        }

        UserDocument doc = worker.getDocument();

        DocumentType docType = null;
        try {
            docType = documentTypeDao.getByName(workerUpdateView.docName);
        } catch (EmptyResultDataAccessException e) {
            throw new NoResultException("no such document type");
        }
        doc.setDocCode(docType);
        doc.setDocNumber(workerUpdateView.docNumber);
        doc.setDocDate(dateFormat.parse(workerUpdateView.docDate));
        userDocumentDao.save(doc);

        Office office = officeDao.loadById(workerUpdateView.officeId);
        if (office == null) {
            throw new NoResultException("attempt to use office, which doesnt exist");
        }

        worker.setOfficeId(office);
        worker.setFirstName(workerUpdateView.firstName);
        worker.setSecondName(workerUpdateView.secondName);
        worker.setMiddleName(workerUpdateView.middleName);
        worker.setPosition(workerUpdateView.position);
        worker.setPhone(workerUpdateView.phone);
        worker.setIsIdentified(workerUpdateView.isIdentified);

        try {
            Country country = countryDao.getByCode(workerUpdateView.citizenshipCode);
            worker.setCitizenshipCode(country);
        } catch (EmptyResultDataAccessException e) {
            throw new NoResultException("attempt to use citizenshipCode, which doesnt exist");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<WorkerListOutView> list(WorkerListView listView) {
        try {
            try {
                countryDao.getByCode(listView.citizenshipCode);
            } catch (EmptyResultDataAccessException e) {
                throw new NoResultException("no such citizenshipCode");
            }
            try {
                documentTypeDao.getByCode(listView.docCode);
            } catch (EmptyResultDataAccessException e) {
                throw new NoResultException("no such docCode");
            }
            List<Worker> all = workerDao.list(listView, listView.citizenshipCode, listView.docCode);
            return mapperFacade.mapAsList(all, WorkerListOutView.class);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }


}

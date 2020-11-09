package org.train.trainProject.service.worker;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.train.trainProject.dao.country.CountryDao;
import org.train.trainProject.dao.documenttype.DocumentTypeDao;
import org.train.trainProject.dao.office.OfficeDao;
import org.train.trainProject.dao.userdocument.UserDocumentDao;
import org.train.trainProject.dao.worker.WorkerDao;
import org.train.trainProject.model.Country;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.model.UserDocument;
import org.train.trainProject.model.Worker;
import org.train.trainProject.model.mapper.MapperFacade;
import org.train.trainProject.view.worker.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * {@link WorkerService}
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
     * {@link WorkerService#save}
     */
    @Transactional
    @SneakyThrows
    @Override
    public void save(WorkerSaveView workerSaveView) {
        Worker worker = new Worker(workerSaveView.firstName, workerSaveView.secondName, workerSaveView.middleName,
                workerSaveView.position, workerSaveView.phone, workerSaveView.isIdentified,
                officeDao.loadById(workerSaveView.officeId));
        workerDao.save(worker);

        DocumentType documentType = new DocumentType(workerSaveView.docName, workerSaveView.docCode);
        documentTypeDao.save(documentType);

        UserDocument userDocument = new UserDocument(worker.getId(), workerSaveView.docNumber,
                dateFormat.parse(workerSaveView.docDate), worker, documentType);
        userDocumentDao.save(userDocument);
        worker.setDocument(userDocument);

        Country country = countryDao.getByCode(workerSaveView.citizenshipCode);
        worker.setCitizenshipCode(country);

        workerDao.save(worker);
    }

    /**
     * {@link WorkerService#getById}
     */
    @Transactional
    @Override
    public WorkerGetView getById(Long id) {
        Worker worker = workerDao.getById(id);
        UserDocument document = worker.getDocument();
        DocumentType documentType = document.getDocCode();
        Country country = worker.getCitizenshipCode();
        return new WorkerGetView(worker.getId(), worker.getFirstName(), worker.getSecondName(),
                worker.getMiddleName(), worker.getPosition(), worker.getPhone(), documentType.getName(),
                document.getDocNumber(), document.getDocDate(), country.getCountryName(), country.getCode(),
                worker.getIsIdentified());
    }

    /**
     * {@link WorkerService#update}
     */
    @SneakyThrows
    @Transactional
    @Override
    public void update(WorkerUpdateView workerUpdateView) {
        Worker worker = workerDao.getById(workerUpdateView.id);

        UserDocument doc = worker.getDocument();

        DocumentType docType = documentTypeDao.getByName(workerUpdateView.docName);
        doc.setDocCode(docType);
        doc.setDocNumber(workerUpdateView.docNumber);
        doc.setDocDate(dateFormat.parse(workerUpdateView.docDate));
        userDocumentDao.save(doc);

        worker.setOfficeId(officeDao.loadById(workerUpdateView.officeId));
        worker.setFirstName(workerUpdateView.firstName);
        worker.setSecondName(workerUpdateView.secondName);
        worker.setMiddleName(workerUpdateView.middleName);
        worker.setPosition(workerUpdateView.position);
        worker.setPhone(workerUpdateView.phone);
        worker.setIsIdentified(workerUpdateView.isIdentified);

        Country country = countryDao.getByCode(workerUpdateView.citizenshipCode);
        worker.setCitizenshipCode(country);

        workerDao.save(worker);

    }

    /**
     * {@link WorkerService#list}
     */
    @Transactional
    @Override
    public List<WorkerListOutView> list(WorkerListView listView) {
        List<Worker> all = workerDao.list(listView);
        return mapperFacade.mapAsList(all, WorkerListOutView.class);
    }


}

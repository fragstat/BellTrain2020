package org.train.trainProject.service.documenttype;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.model.DocumentType;
import org.train.trainProject.view.country.CountryView;
import org.train.trainProject.view.documenttype.DocumentTypeView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис для {@link DocumentType}
 *
 * @author Sergey Valavin
 * @version 1.0
 */
@Validated
public interface DocumentTypeService {

    /**
     * Сохраненить новый тип документа в БД
     *
     * @param documentTypeView валидируемое DTO из контроллера
     */
    void save(@Valid DocumentTypeView documentTypeView);

    /**
     * Получить тип документа по id
     *
     * @param id уникальный идентификатор типа документа
     * @return {@link DocumentTypeView}
     */
    DocumentTypeView getById(Long id);

    /**
     * Получить тип документа по коду
     *
     * @param code код типа документа
     * @return {@link DocumentTypeView}
     */
    DocumentTypeView getByCode(Integer code);

    /**
     * Получить все типы документов
     *
     * @return {@link DocumentTypeView}
     */
    List<DocumentTypeView> getAll();

}

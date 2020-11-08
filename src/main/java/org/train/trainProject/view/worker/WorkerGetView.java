package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Пользователь (get)")
public class WorkerGetView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "Имя", example = "Сергей")
    public String firstName;

    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @ApiModelProperty(value = "Должность", example = "Java - разработчик")
    public String position;

    @ApiModelProperty(value = "Номер телефона", example = "79684543193")
    public String phone;

    @ApiModelProperty(value = "Название документа", example = "Паспорт гражданина РФ")
    public String docName;

    @ApiModelProperty(value = "Номер документа", example = "1234567890")
    public String docNumber;

    @ApiModelProperty(value = "Дата документа", example = "2016-01-01")
    public Date docDate;

    @ApiModelProperty(value = "Название страны гражданства", example = "Российская Федерация")
    public String citizenshipName;

    @ApiModelProperty(value = "Код страны гражданства", example = "643")
    public Integer citizenshipCode;

    @ApiModelProperty(value = "Пройдена ли идентификация", example = "true")
    public Boolean isIdentified;

    public WorkerGetView(Long id, String firstName, String secondName, String middleName, String position, String phone,
                         String docName, String docNumber, Date docDate, String citizenshipName,
                         Integer citizenshipCode, Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }
}

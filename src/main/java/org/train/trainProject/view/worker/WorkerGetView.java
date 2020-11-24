package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
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
    public String docDate;

    @ApiModelProperty(value = "Название страны гражданства", example = "Российская Федерация")
    public String citizenshipName;

    @ApiModelProperty(value = "Код страны гражданства", example = "643")
    public Integer citizenshipCode;

    @ApiModelProperty(value = "Пройдена ли идентификация", example = "true")
    public Boolean isIdentified;

    public WorkerGetView(Long id, String firstName, String secondName, String middleName, String position, String phone,
                         String docName, String docNumber, String docDate, String citizenshipName,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerGetView)) return false;
        WorkerGetView that = (WorkerGetView) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(position, that.position) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(docName, that.docName) &&
                Objects.equals(docNumber, that.docNumber) &&
                Objects.equals(docDate, that.docDate) &&
                Objects.equals(citizenshipName, that.citizenshipName) &&
                Objects.equals(citizenshipCode, that.citizenshipCode) &&
                Objects.equals(isIdentified, that.isIdentified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, middleName, position, phone, docName, docNumber, docDate, citizenshipName, citizenshipCode, isIdentified);
    }
}

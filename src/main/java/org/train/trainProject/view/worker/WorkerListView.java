package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Пользователь (список/запрос)")
public class WorkerListView {

    @ApiModelProperty(value = "Уникальный идентификатор офиса", example = "1")
    @NotNull(message = "officeId cannot be null")
    public Long officeId;

    @ApiModelProperty(value = "Имя", example = "Сергей")
    public String firstName;

    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String lastName;

    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @ApiModelProperty(value = "Должность", example = "Java - разработчик")
    public String position;

    @ApiModelProperty(value = "Код документа", example = "21")
    public Integer docCode;

    @ApiModelProperty(value = "Код страны гражданства", example = "643")
    public Integer citizenshipCode;

    public WorkerListView(long officeId, String firstName, String position, int docCode, int citizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
    }
}

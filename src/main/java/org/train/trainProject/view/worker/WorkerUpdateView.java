package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.train.trainProject.model.Office;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Пользователь (обновление)")
public class WorkerUpdateView {

    @NotNull(message = "id cannot be null")
    @Min(0)
    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @Min(1)
    @ApiModelProperty(value = "Уникальный идентификатор офиса", example = "1")
    public Long officeId;

    @NotEmpty(message = "firstName cannot be null")
    @Size(max = 25)
    @ApiModelProperty(value = "Имя", example = "Сергей")
    public String firstName;

    @Size(max = 25)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 25)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 50)
    @ApiModelProperty(value = "Должность", example = "Java - разработчик")
    public String position;

    @Size(max = 11, min = 11)
    @ApiModelProperty(value = "Номер телефона", example = "79684543193")
    public String phone;

    @Size(max = 100)
    @ApiModelProperty(value = "Название документа", example = "Паспорт гражданина РФ")
    public String docName;

    @Size(max = 20)
    @ApiModelProperty(value = "Номер документа", example = "1234567890")
    public String docNumber;

    @Size(min = 10, max = 10)
    @ApiModelProperty(value = "Дата документа", example = "2016-01-01")
    public String docDate;

    @Min(1)
    @ApiModelProperty(value = "Код страны гражданства", example = "643")
    public Integer citizenshipCode;

    @ApiModelProperty(value = "Пройдена ли идентификация", example = "true")
    public Boolean isIdentified;
}

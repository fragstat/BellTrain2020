package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Пользователь (список/ответ)")
public class WorkerListOutView {

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
}

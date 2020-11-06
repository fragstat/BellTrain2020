package org.train.trainProject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Офис (список/ответ)")
public class OfficeListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "Название", example = "Офис Москва")
    public String name;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;
}

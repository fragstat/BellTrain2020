package org.train.trainProject.view.organisation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "")
public class OrganisationListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "ИНН", example = "125848466586")
    public String inn;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;
}

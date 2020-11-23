package org.train.trainProject.view.organisation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "")
public class OrganisationListInView {

    @Size(max = 150)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Сбербанк")
    public String name;

    @Digits(integer = 12, fraction = 0)
    @Size(min = 10, max = 12)
    @ApiModelProperty(value = "ИНН", example = "125848466586")
    public String inn;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;

}

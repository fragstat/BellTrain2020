package org.train.trainProject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Офис (get)")
public class OfficeGetView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "Название", example = "Офис Москва")
    public String name;

    @ApiModelProperty(value = "Адрес", example = "Театральная площадь, 1, Москва, Россия, 125009")
    public String address;

    @ApiModelProperty(value = "Номер телефона", example = "78005575525")
    public String phone;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;

}

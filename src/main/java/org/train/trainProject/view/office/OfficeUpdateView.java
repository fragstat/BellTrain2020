package org.train.trainProject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис (обновление)")
public class OfficeUpdateView {

    @Min(value = 0)
    @NotNull(message = "orgId cannot be null")
    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Офис Москва")
    public String name;

    @Size(max = 150)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Театральная площадь, 1, Москва, Россия, 125009")
    public String address;

    @Size(min = 11, max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "78005575525")
    public String phone;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;
}

package org.train.trainProject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Офис (сохранение)")
public class OfficeSaveView {

    @Min(value = 0)
    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор организации", example = "1")
    public Long orgId;

    @Size(max = 50)
    @ApiModelProperty(value = "Название", example = "Офис Москва")
    public String name;

    @Size(max = 150)
    @ApiModelProperty(value = "Адрес", example = "Театральная площадь, 1, Москва, Россия, 125009")
    public String address;

    @Size(min = 11, max = 11)
    @ApiModelProperty(value = "Номер телефона", example = "78005575525")
    public String phone;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;
}

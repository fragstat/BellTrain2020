package org.train.trainProject.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Офис (список/запрос)")
public class OfficeListInView {

    @ApiModelProperty(value = "Уникальный идентификатор организации", example = "1")
    @NotNull(message = "orgId cannot be null")
    @Min(value = 0)
    public Long orgId;

    @Size(max = 150)
    @ApiModelProperty(value = "Название", example = "Сбербанк")
    public String name;

    @Size(max =11, min = 11)
    @ApiModelProperty(value = "Номер телефона", example = "78005575525")
    public String phone;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;
}

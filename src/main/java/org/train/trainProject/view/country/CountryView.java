package org.train.trainProject.view.country;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
public class CountryView {

    @Size(max = 100)
    @ApiModelProperty(value = "Название страны", example = "Россия")
    public String name;

    @ApiModelProperty(value = "Код страны", example = "631")
    public Integer code;
}

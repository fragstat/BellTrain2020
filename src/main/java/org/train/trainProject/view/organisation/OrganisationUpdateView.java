package org.train.trainProject.view.organisation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Организация (обновление)")
public class OrganisationUpdateView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    @Min(0)
    public Long id;

    @Size(max = 50)
    @NotEmpty(message = "orgName cannot be null")
    @ApiModelProperty(value = "Название", example = "Сбербанк")
    public String name;

    @Size(max = 150)
    @NotEmpty(message = "fullName cannot be null")
    @ApiModelProperty(value = "Полное название", example = "ПАО Сбербанк")
    public String fullName;

    @Digits(integer = 12, fraction = 0)
    @Size(min = 10, max = 12)
    @NotEmpty(message = "inn cannot be null")
    @ApiModelProperty(value = "ИНН", example = "125848466586")
    public String inn;

    @Pattern(regexp="\\d{9}")
    @NotEmpty(message = "kpp cannot be null")
    @ApiModelProperty(value = "КПП", example = "655156848")
    public String kpp;

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

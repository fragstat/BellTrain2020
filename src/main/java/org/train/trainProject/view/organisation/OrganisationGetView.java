package org.train.trainProject.view.organisation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;


@ApiModel(description = "Организация (по id)")
public class OrganisationGetView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "Название", example = "Сбербанк")
    public String orgName;

    @ApiModelProperty(value = "Полное название", example = "ПАО Сбербанк")
    public String fullName;

    @ApiModelProperty(value = "ИНН", example = "125848466586")
    public String inn;

    @ApiModelProperty(value = "КПП", example = "655156848")
    public String kpp;

    @ApiModelProperty(value = "Адрес", example = "Театральная площадь, 1, Москва, Россия, 125009")
    public String address;

    @ApiModelProperty(value = "Номер телефона", example = "78005575525")
    public String phone;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;

    public OrganisationGetView() {
    }

}

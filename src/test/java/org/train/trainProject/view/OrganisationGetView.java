package org.train.trainProject.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


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

    public OrganisationGetView(Long id, String orgName, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.orgName = orgName;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationGetView)) return false;

        OrganisationGetView that = (OrganisationGetView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!orgName.equals(that.orgName)) return false;
        if (!fullName.equals(that.fullName)) return false;
        if (!inn.equals(that.inn)) return false;
        if (!kpp.equals(that.kpp)) return false;
        if (!address.equals(that.address)) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return isActive != null ? isActive.equals(that.isActive) : that.isActive == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + orgName.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + inn.hashCode();
        result = 31 * result + kpp.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\"data\":{" +
                "\"id:\"" + id +
                ", \"orgName\":\"" + orgName + '\"' +
                ", \"fullName\":\"" + fullName + '\"' +
                ", \"inn\":\"" + inn + '\"' +
                ", \"kpp\":\"" + kpp + '\"' +
                ", \"address\":\"" + address + '\"' +
                ", \"phone\":\"" + phone + '\"' +
                ", \"isActive\":" + isActive +
                "}}";
    }
}

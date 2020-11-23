package org.train.trainProject.view.organisation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "")
public class OrganisationListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "ИНН", example = "125848466586")
    public String inn;

    @ApiModelProperty(value = "Действующая", example = "true")
    public Boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganisationListOutView)) return false;

        OrganisationListOutView that = (OrganisationListOutView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inn != null ? !inn.equals(that.inn) : that.inn != null) return false;
        return isActive.equals(that.isActive);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + isActive.hashCode();
        return result;
    }
}

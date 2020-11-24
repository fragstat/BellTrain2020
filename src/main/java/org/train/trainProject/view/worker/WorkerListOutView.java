package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Пользователь (список/ответ)")
public class WorkerListOutView {

    @ApiModelProperty(value = "Уникальный идентификатор", example = "1")
    public Long id;

    @ApiModelProperty(value = "Имя", example = "Сергей")
    public String firstName;

    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @ApiModelProperty(value = "Должность", example = "Java - разработчик")
    public String position;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerListOutView)) return false;

        WorkerListOutView that = (WorkerListOutView) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(secondName, that.secondName)) return false;
        if (!Objects.equals(middleName, that.middleName)) return false;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}

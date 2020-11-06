package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Пользователь (список/запрос)")
public class WorkerListView {

    @NotNull
    public Long officeId;

    public String firstName;

    public String lastName;

    public String middleName;

    public String position;

    public Integer docCode;

    public Integer citizenshipCode;
}

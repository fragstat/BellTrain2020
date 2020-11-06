package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Пользователь (сохранение)")
public class WorkerSaveView {

    @NotNull
    @Min(1)
    public Long officeId;

    @NotEmpty
    @Size(max = 25)
    public String firstName;

    @Size(max = 25)
    public String secondName;

    @Size(max = 25)
    public String middleName;

    @NotEmpty
    @Size(max = 50)
    public String position;

    @Size(max = 11, min = 11)
    public String phone;

    @Min(1)
    public Integer docCode;

    @Size(max = 100)
    public String docName;

    @Size(max = 20)
    public String docNumber;

    @Size(min = 10, max = 10)
    public String docDate;

    @Min(1)
    public Integer citizenshipCode;

    public Boolean isIdentified;
}

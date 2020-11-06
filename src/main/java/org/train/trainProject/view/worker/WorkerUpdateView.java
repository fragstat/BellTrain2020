package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;
import org.train.trainProject.model.Office;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Пользователь (обновление)")
public class WorkerUpdateView {

    @NotNull
    @Min(1)
    public Long id;

    @Min(1)
    public Long officeId;

    @NotEmpty
    @Size(max = 25)
    public String firstName;

    @Size(max = 25)
    public String secondName;

    @Size(max = 25)
    public String middleName;

    @Size(max = 50)
    public String position;

    @Size(max = 11, min = 11)
    public String phone;

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

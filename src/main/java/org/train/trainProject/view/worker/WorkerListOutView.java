package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Пользователь (список/ответ)")
public class WorkerListOutView {

    public Long id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;
}

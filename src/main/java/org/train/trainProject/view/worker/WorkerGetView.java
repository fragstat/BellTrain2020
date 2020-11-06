package org.train.trainProject.view.worker;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel(description = "Пользователь (get)")
public class WorkerGetView {

    public Long id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public Date docDate;

    public String citizenshipName;

    public Integer citizenshipCode;

    public Boolean isIdentified;

    public WorkerGetView(Long id, String firstName, String secondName, String middleName, String position, String phone,
                         String docName, String docNumber, Date docDate, String citizenshipName,
                         Integer citizenshipCode, Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }
}

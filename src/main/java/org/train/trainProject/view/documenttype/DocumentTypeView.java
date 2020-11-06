package org.train.trainProject.view.documenttype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Тип документа")
public class DocumentTypeView {

    @Size(max = 100)
    @ApiModelProperty(value = "Название документа", example = "Паспорт гражданина РФ")
    public String name;

    @ApiModelProperty(value = "Код документа", example = "21")
    public Integer code;
}

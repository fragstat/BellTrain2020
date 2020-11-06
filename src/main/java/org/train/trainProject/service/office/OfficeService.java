package org.train.trainProject.service.office;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.view.office.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OfficeService {

    void save(@Valid OfficeSaveView saveView);

    void update(@Valid OfficeUpdateView updateView);

    List<OfficeListOutView> list(@Valid OfficeListInView organizationView);

    OfficeGetView getById(Long id);

}

package org.train.trainProject.service.organisation;

import org.springframework.validation.annotation.Validated;
import org.train.trainProject.view.organisation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OrganisationService {

    void save(@Valid OrganisationSaveView saveView);

    void update(@Valid OrganisationUpdateView updateView);

    List<OrganisationListOutView> list(@Valid OrganisationListInView organizationView);

    OrganisationGetView getById(Long id);

}

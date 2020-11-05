package org.train.trainProject.dao.organisation;

import org.train.trainProject.model.Organisation;
import org.train.trainProject.view.organisation.OrganisationListInView;

import java.util.List;

public interface OrganisationDao {

    List<Organisation> list(OrganisationListInView inView);

    Organisation loadById(Long id);

    void update(Organisation organisation);

    void save(Organisation organisation);
}

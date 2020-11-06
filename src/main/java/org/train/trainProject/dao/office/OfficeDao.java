package org.train.trainProject.dao.office;

import org.train.trainProject.model.Office;
import org.train.trainProject.view.office.OfficeListInView;

import java.util.List;

public interface OfficeDao {

    List<Office> list(OfficeListInView inView);

    Office loadById(Long id);

    void update(Office organisation);

    void save(Office organisation);
}

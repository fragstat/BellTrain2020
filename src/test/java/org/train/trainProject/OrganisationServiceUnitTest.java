package org.train.trainProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.train.trainProject.view.OrganisationGetView;
import org.train.trainProject.view.OrganisationSavePostView;
import org.train.trainProject.view.aspect.SuccessView;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrganisationServiceUnitTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void organisationSaveTest() throws Exception {
        OrganisationSavePostView organisation = new OrganisationSavePostView("Назавание", "Полное название", "1234567898", "123456789",
                "Москва", "79684543193", true);
        ResponseEntity<SuccessView> entity = restTemplate.postForEntity("/api/organization" +
                "/save", organisation, SuccessView.class);
        SuccessView sv = entity.getBody();
        assert (sv != null && sv.result.equals("success"));
    }

    @Test
    public void organisationGetTest() throws Exception {
        OrganisationGetView organisation = new OrganisationGetView(1L , "Назавание", "Полное название", "1234567898",
                "123456789", "Москва", "79684543193", true);
        ResponseEntity<String> entity = restTemplate.getForEntity(
                "http://localhost:8885/api/organization/1", String.class);
        String org = entity.getBody();
        assert (organisation.toString().equals(org));
    }
}


package org.train.trainProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.train.trainProject.view.organisation.OrganisationListInView;
import org.train.trainProject.view.organisation.OrganisationListOutView;
import org.train.trainProject.view.organisation.OrganisationUpdateView;
import org.train.trainProject.view.organisationtest.*;
import org.train.trainProject.view.aspect.SuccessView;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganisationServiceUnitTest {

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void organisationServiceTest() throws Exception {

        save();
        get();
        update();
        list();
    }

    private void save() throws Exception {
        OrganisationSavePostView organisation = new OrganisationSavePostView("Назавание", "Полное название", "1234567898", "123456789",
                "Москва", "79684543193", true);
        ResponseEntity<SuccessView> entity = restTemplate.postForEntity("/api/organization" +
                "/save", organisation, SuccessView.class);
        SuccessView sv = entity.getBody();
        assert (sv != null && sv.result.equals("success"));
    }

    private void get() throws Exception {
        OrganisationGetView organisationGet = new OrganisationGetView(1L , "Назавание", "Полное название",
                "1234567898",
                "123456789", "Москва", "79684543193", true);
        ResponseEntity<String> entityGet = restTemplate.getForEntity(
                "/api/organization/1", String.class);
        String json = entityGet.getBody();
        OrganisationGetResponseView responseGet = objectMapper.readValue(json, OrganisationGetResponseView.class);
        OrganisationGetView orgGet = responseGet.data;
        assert (organisationGet.equals(orgGet));
    }

    private void update() throws Exception {
        OrganisationUpdateView organisationUpdate = new OrganisationUpdateView(1L, "Новое название",
                "Новое полное название", "12345654321", "987654321","Новая Москва",
                "79684549331", false);
        ResponseEntity<SuccessView> entityUpdateResult = restTemplate.postForEntity("/api/organization/update",
                organisationUpdate, SuccessView.class);
        SuccessView svUpdate = entityUpdateResult.getBody();
        assert (svUpdate != null && svUpdate.result.equals("success"));
    }

    public void list() throws Exception {
        OrganisationListInView organisationListPost = new OrganisationListInView("Новое название", "12345654321",
                false);
        ResponseEntity<String> entityList = restTemplate.postForEntity("/api/organization/list", organisationListPost,
                String.class);
        String jsonFromList = entityList.getBody();
        OrganisationListResponseView responseList = objectMapper.readValue(jsonFromList,
                OrganisationListResponseView.class);
        List<OrganisationListOutView> orgList = responseList.data;
        OrganisationListOutView orgListOutView = orgList.get(0);
        OrganisationListOutView organisationListView = new OrganisationListOutView(1L, "12345654321", false);
        assert organisationListView.equals(orgListOutView);
    }
}


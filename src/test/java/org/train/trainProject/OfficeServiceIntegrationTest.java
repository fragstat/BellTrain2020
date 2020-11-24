package org.train.trainProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.train.trainProject.view.aspect.SuccessView;
import org.train.trainProject.view.office.*;
import org.train.trainProject.view.officetest.OfficeGetResponseView;
import org.train.trainProject.view.officetest.OfficeListResponseView;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfficeServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void save() throws Exception {
        OfficeSaveView office = new OfficeSaveView(3L, "Офис","Москва", "79684543193", true);
        ResponseEntity<SuccessView> entity = restTemplate.postForEntity("/api/office/save", office, SuccessView.class);
        SuccessView sv = entity.getBody();
        assert (sv != null && sv.result.equals("success"));
    }

    @Test
    public void get() throws Exception {
        OfficeGetView officeGet = new OfficeGetView(1L , "Долгопрудный",
                "г. Долгопрудный, Лихачевский проспект, д.18, стр.1", "74995037363", true);
        ResponseEntity<String> entityGet = restTemplate.getForEntity(
                "/api/office/1", String.class);
        String json = entityGet.getBody();
        OfficeGetResponseView responseGet = objectMapper.readValue(json, OfficeGetResponseView.class);
        OfficeGetView officeGetView = responseGet.data;
        assert (officeGet.equals(officeGetView));
    }

    @Test
    public void update() throws Exception {
        OfficeUpdateView officeUpdate = new OfficeUpdateView(2L, "Новое название", "Новая Москва",
                "79684549331", false);
        ResponseEntity<SuccessView> entityUpdateResult = restTemplate.postForEntity("/api/office/update",
                officeUpdate, SuccessView.class);
        SuccessView svUpdate = entityUpdateResult.getBody();
        assert (svUpdate != null && svUpdate.result.equals("success"));
    }

    @Test
    public void list() throws Exception {
        OfficeListInView officeListPost = new OfficeListInView(1L , "Долгопрудный", "74995037363",
                true);
        ResponseEntity<String> entityList = restTemplate.postForEntity("/api/office/list", officeListPost,
                String.class);
        String jsonFromList = entityList.getBody();
        OfficeListResponseView responseList = objectMapper.readValue(jsonFromList,
                OfficeListResponseView.class);
        List<OfficeListOutView> officeList = responseList.data;
        OfficeListOutView officeListOutView = officeList.get(0);
        OfficeListOutView officeListView = new OfficeListOutView(1L, "Долгопрудный", true);
        assert officeListView.equals(officeListOutView);
    }
}

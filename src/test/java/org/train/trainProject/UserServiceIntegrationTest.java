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
import org.train.trainProject.view.usertest.UserGetResponseView;
import org.train.trainProject.view.usertest.UserListResponseView;
import org.train.trainProject.view.worker.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void save() throws Exception {
        WorkerSaveView user = new WorkerSaveView(3L, "Сергей","Сергеевич", "Сергеев" , "Java-разработчик",
                "79684543193", 21, "Паспорт гражданина РФ", "123412347", "2016-01-01", 643, true);
        ResponseEntity<SuccessView> entity = restTemplate.postForEntity("/api/user/save", user, SuccessView.class);
        SuccessView sv = entity.getBody();
        assert (sv != null && sv.result.equals("success"));
    }

    @Test
    public void get() throws Exception {
        WorkerGetView userGet = new WorkerGetView(1L , "Сергей", null, null,
                "Java разработчик", null, "Удостоверение беженца", "123456789101", "2020-11-24", "Российская " +
                "Федерация", 643, true);
        ResponseEntity<String> entityGet = restTemplate.getForEntity(
                "/api/user/1", String.class);
        String json = entityGet.getBody();
        UserGetResponseView responseGet = objectMapper.readValue(json, UserGetResponseView.class);
        WorkerGetView userGetView = responseGet.data;
        assert (userGet.equals(userGetView));
    }

    @Test
    public void update() throws Exception {
        WorkerUpdateView userUpdate = new WorkerUpdateView(2L, 2L, "Новое имя", "Новая фамилия", "Новое отчество",
                "new position", "79684543333", "Удостоверение беженца", "1234554321", "2020-01-01", 112, false);
        ResponseEntity<SuccessView> entityUpdateResult = restTemplate.postForEntity("/api/user/update",
                userUpdate, SuccessView.class);
        SuccessView svUpdate = entityUpdateResult.getBody();
        assert (svUpdate != null && svUpdate.result.equals("success"));
    }

    @Test
    public void list() throws Exception {
        WorkerListView workerListPost = new WorkerListView(1L , "Сергей", "Java разработчик", 13, 643);
        ResponseEntity<String> entityList = restTemplate.postForEntity("/api/user/list", workerListPost,
                String.class);
        String jsonFromList = entityList.getBody();
        UserListResponseView responseList = objectMapper.readValue(jsonFromList,
                UserListResponseView.class);
        List<WorkerListOutView> userList = responseList.data;
        WorkerListOutView userListOutView = userList.get(0);
        WorkerListOutView userListView = new WorkerListOutView(1L, "Сергей", null, null,"Java разработчик");
        assert userListOutView.equals(userListView);
    }
}


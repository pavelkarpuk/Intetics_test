package api.users;

import api.models.UserModel;
import api.services.users.UserService;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest {

    private Response response;

    @BeforeClass
    public void createUser() {
        UserModel userModel = UserModel.generate();
        response = UserService.createUser(userModel);
    }

    @Test
    public void checkStatusCodeUserCreationTest() {
        assertThat(
                "Response status code POST /user is not 200 OK",
                response.statusCode(),
                Matchers.equalTo(200)
        );
    }
}

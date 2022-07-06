package api.users;

import api.services.users.UserService;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserLogoutTest {

    @Test
    public void checkStatusCodeUserLogoutTest() {
        Response response = UserService.logout();
        assertThat(
                "Response status code GET /user/logout is not 200 OK",
                response.statusCode(),
                Matchers.equalTo(200)
        );
    }
}

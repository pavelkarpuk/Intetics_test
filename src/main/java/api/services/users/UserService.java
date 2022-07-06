package api.services.users;

import api.AppClient;
import api.models.UserModel;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GsonUtils;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final AppClient client = new AppClient();

    private static final String PATH = "user";

    public static Response createUser(UserModel model) {
        RequestSpecification requestSpecification = given()
                .basePath(PATH)
                .body(GsonUtils.toJson(model));
        return client.response(Method.POST, requestSpecification);
    }

    public static Response logout() {
        RequestSpecification requestSpecification = given()
                .basePath(PATH + "/" + "logout");
        return client.response(Method.GET, requestSpecification);
    }
}

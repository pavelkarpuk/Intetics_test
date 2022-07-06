package api;

import utils.EnvironmentConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppClient {

    public Response response(Method method, RequestSpecification requestSpec) {
        requestSpec.baseUri(EnvironmentConfig.appUrl)
                .contentType(ContentType.JSON)
                .filter(new LoggingFilter());
        return requestSpec.request(method);
    }
}

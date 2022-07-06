package api;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Headers;
import io.restassured.internal.support.Prettifier;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.log4j.Logger;

public class LoggingFilter implements Filter {

    private static final Logger log = Logger.getLogger(LoggingFilter.class);
    private static final Prettifier prettifier = new Prettifier();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        printRequestDetails(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec);
        printHeader(response);
        printBody(response);
        return response;
    }

    public void printRequestDetails(FilterableRequestSpecification requestSpec) {
        Object body = prettifier.prettify(requestSpec.getBody(), Parser.JSON);
        String message = String.format("\nRequest method:\t%s\n" +
                        "Request URI:\t%s\n" +
                        "Request params:\t\t%s\n" +
                        "Query params:\t\t%s\n" +
                        "Form params:\t\t%s\n" +
                        "Path params:\t\t%s\n" +
                        "Headers:\t\t\t%s\n" +
                        "Cookies:\t\t\t%s\n" +
                        "Multiparts:\t\t\t%s\n" +
                        "Body:\n" +
                        "%s", requestSpec.getMethod(),
                requestSpec.getBaseUri() + requestSpec.getBasePath(),
                requestSpec.getRequestParams(),
                requestSpec.getQueryParams(),
                requestSpec.getFormParams(),
                requestSpec.getPathParams(),
                requestSpec.getHeaders(),
                requestSpec.getCookies(),
                requestSpec.getMultiPartParams(),
                body);
        log.info(message);
    }

    public void printHeader(Response response) {
        String line = response.getStatusLine();
        Headers headers = response.getHeaders();
        String message = String.format("\nStatus Line:%s  \nHeaders:%s ", line, headers.toString());
        log.info(message);
    }

    public void printBody(Response response) {
        byte[] byteArray = response.asByteArray();
        if (byteArray.length < 10000) {
            log.info(String.format("\nResponse body :\n %s", prettify(response)));
        } else
            log.info("Body is huge");
    }

    private String prettify(Response response) {
        return prettifier.getPrettifiedBodyIfPossible(response, response);
    }
}

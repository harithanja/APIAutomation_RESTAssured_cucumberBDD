package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class requestspecbuilder {
    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {


        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
            ConfigReader c=new ConfigReader();

            req = new RequestSpecBuilder().setBaseUri(c.getBaseURI()).setRelaxedHTTPSValidation().addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;

        }
        return req;
    }
}

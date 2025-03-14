package Steps;

import Utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import pojo.AddPlace;
import pojo.delete;
import pojo.update;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;

public class StepDefinitions extends requestspecbuilder {
    RequestSpecification requestSpecification;
    Response response;
    ConfigReader config = new ConfigReader();

   List<String> a=new ArrayList<>();
    ExcelReader reader = new ExcelReader();
    RequestPayload r = new RequestPayload();
    ObjectMapper objectMapper = new ObjectMapper();



    @Given("Create a request payload with {string} and {int}")
    public void createARequestPayloadWithAndRow(String s1, int row) throws IOException {
        AddPlace add;
        Sheet s = reader.readExcel(config.getTestDataFilePath(), config.getTestDataFileName1(), config.getTestDataSheetName1());
        add = r.payload(s, row);
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(add);
        requestSpecification = given().log().all().spec(requestSpecification()).relaxedHTTPSValidation().body(reqBody);

    }
    @Then("Validate the Status code")
    public void validateTheStatusCode() {
        String status=response.jsonPath().getString("status");
        Assert.assertEquals(status,config.getSuccessStatus());
        System.out.println(status);
       System.out.println(a);
    }

    @Then("validate the Response Time")
    public void validateTheResponseTime() {
        long time= config.getResponseTime();
        long timein=response.getTimeIn(TimeUnit.MILLISECONDS);
        Assert.assertTrue(timein<time);
    }
    @When("user calls  resource with http {string} request")
    public void userCallsResourceWithHttpRequest(String method) {
        if (method.equalsIgnoreCase("POST")) {
            response = requestSpecification.when().post(config.getPostResource());
            response.prettyPrint();
            String placeid=response.jsonPath().getString("place_id");
            Utils.reader.addData(placeid);

        }
        else if(method.equalsIgnoreCase("PUT"))
        {
        response = requestSpecification.when().log().all().put(config.getGetResource());
        response.prettyPrint();
        }
        else if(method.equalsIgnoreCase("GET"))
        {
        response = requestSpecification.when().get(config.getGET());
        response.prettyPrint();
        }
        else if(method.equalsIgnoreCase("DELETE"))
        {
        response = requestSpecification.when().delete(config.getDeleteCall());
        response.prettyPrint();

        }

    }

    @Given("Create request payload with {string} and {int}")
    public void create_request_payload_with_and(String string, Integer row)  throws IOException {
        update u;
        Sheet s= reader.readExcel(config.getTestDataFilePath(),config.getTestDataFileName1(),config.getTestDataSheetName1());
        u=r.requestpayload(s,row);
        ObjectMapper objectMapper = new ObjectMapper();
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
        requestSpecification=given().log().all().spec(requestSpecification() ).relaxedHTTPSValidation().body(reqBody);
    }
    @Given("Create request payload with {string} and {int} to delete")
    public void create_request_payload_with_and_to_delete(String string, Integer num) throws IOException {
        delete d;
        Sheet s= reader.readExcel(config.getTestDataFilePath(),config.getFile2(),config.getSheet2());
        d=r.deleteRequest(s,num);
        ObjectMapper objectMapper = new ObjectMapper();
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(d);
        requestSpecification=given().log().all().spec(requestSpecification() ).relaxedHTTPSValidation().body(reqBody);
    }

    @Given("Create  request payload with {string} and <row>")
    public void createRequestPayloadWithAndRow(String arg0,int num) throws IOException {
        delete d;
        Sheet s= reader.readExcel(config.getTestDataFilePath(),config.getFile2(),config.getSheet2());
        d=r.deleteRequest(s,num);
        ObjectMapper objectMapper = new ObjectMapper();
        String reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(d);
        requestSpecification=given().log().all().spec(requestSpecification() ).relaxedHTTPSValidation().body(reqBody);
    }
    @After
    public void runMethod(){
        System.out.println("The test is passed successfully");
    }
    @Given("Create  request payload with {string} and {int} for GET")
    public void create_request_payload_with_and_for_GET(String string, Integer num) throws IOException {
        Sheet s= reader.readExcel(config.getTestDataFilePath(),config.getFile2(),config.getSheet2());
        DataFormatter formatter = new DataFormatter();
        Row row = s.getRow(num);
        requestSpecification = given().log().all().spec(requestSpecification() ).queryParam("place_id",formatter.formatCellValue(row.getCell(0))).relaxedHTTPSValidation();
    }
    @Before
    public void beforeAll(){
        System.out.println("the test is ready to run");
    }
    @Before("@remove")
    public void delete(){
        System.out.println("now the data deletion started");
    }


}




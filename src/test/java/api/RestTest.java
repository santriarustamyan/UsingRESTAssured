package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import com.github.javafaker.Faker;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {


    Faker faker = new Faker();

    public String name = faker.name().firstName();
//    private String gender = faker.;
    private String email = faker.internet().emailAddress();
    private final static String URL = "https://gorest.co.in/";
    private final static String PATH = "/public-api/users";
    private final static String PATH1 = "/public-api/users?page=2";

    List<UserData> users = ((List<UserData>) getResponse("data"));
    int code = (int) getResponse("code");
    int cod = (int) getResponseS();


    private static String requestBody = "{\n" +
            "  \"name\": \"Dsxacsx Adfsd\",\n" +
            "  \"gender\": \"female\",\n" +
            "  \"email\": \"teshnascsytfv@ss15cev.com\",\n"+
            "  \"status\": \"active\" \n}";

//            female
//            male

//{
//    "name": "Tenali Ramakrishna",
//    "gender": "male",
//    "email": "tenali.rcamakrishnav@15cev.com",
//    "status": "active"
//}


    List<UserData> aaa = (List<UserData>) cx();


    public Object cx() {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .when().get(PATH1).jsonPath().get("data");
    }

    public Object cxsToken() {
        return given().auth()
                .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .when().post().jsonPath().get();
    }

    public Object getResponse(String daaa) {
        return given()
                .baseUri(URL)
                .basePath(PATH1)
                .contentType(ContentType.JSON)
                .when().get().jsonPath().get(daaa);
    }

    public Object getResponseS() {
        return given()
                .baseUri(URL)
                .basePath(PATH)
                .contentType(ContentType.JSON)
                .when().get().jsonPath().get("code");
    }

    @Test
    public void getTest() {

        System.out.println("Response Body is: " + aaa);
        //200
        System.out.println("Response Body is: " + cod);
        System.out.println("Response Body is: " + users);
        System.out.println("Response Body is: " + code);
    }

    @Test
    public void test1() {

        for (int i = 1; i < (int) getResponseS(); i++) {
            System.out.println("Response Body is: " +
                    given()
                            .contentType(ContentType.JSON)
                            .when()
                            .get("https://gorest.co.in/public-api/users?page=" + i)
                            .jsonPath()
                            .get("data.name"));
        }

    }

    @Test
    public void test2() {

        System.out.println("Response Body is: " +
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .post("https://gorest.co.in/public-api/users/")
                        .jsonPath()
                        .get());


    }
    //201
    //422
    @Test
    public void postRequest() {
        System.out.println( given().auth()
                .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                .baseUri("https://gorest.co.in/public-api/users")
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post().jsonPath().get("code").toString());

//        Assert.assertEquals(201, response.statusCode());
    }

    //204
    @Test
    public void deleteRequest() {
        System.out.println( given().auth()
                .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                .baseUri("https://gorest.co.in/public-api/users/2224")
                .delete().jsonPath().get("code").toString());

//        Assert.assertEquals(201, response.statusCode());
    }


}

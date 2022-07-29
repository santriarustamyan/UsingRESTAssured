package api;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestTest {
    private final static String URL = "https://gorest.co.in/";
    private final static String PATH = "/public-api/users";
    private final static String PATH1 = "/public-api/users?page=2";

    List<UserData> users = ((List<UserData>) getResponse("data"));
    int code = (int) getResponse("code");
    int cod = (int) getResponseS();


    List<UserData> aaa = (List<UserData>) cx();


    public Object cx() {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .when().get(PATH1).jsonPath().get("data");
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
                .when().get().jsonPath().get("meta.pagination.pages");
    }

    @Test
    public void getTest() {

        System.out.println("Response Body is: " + aaa);
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
                            .get("data.id"));
        }

    }

    @Test
    public void test2() {

        System.out.println("Response Body is: " +
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("https://gorest.co.in/public-api/users/3232")
                        .jsonPath()
                        .get());


    }
}

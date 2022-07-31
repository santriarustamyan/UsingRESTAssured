package api;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;

public class Requests {

    Faker faker = new Faker();

    public String name = faker.name().fullName();
    private String email = faker.internet().emailAddress();
    private final static String URL = "https://gorest.co.in/";
    private final static String PATH = "/public-api/users";

    private final static String PATH2 = "/public-api/users/";

    private static String requestBody = "{\n" + "  \"name\": \"Dsxacsx Adfsd\",\n" + "  \"gender\": \"female\",\n" + "  \"email\": \"teshnikiv@ss15cev.com\",\n" + "  \"status\": \"active\" \n}";


    //200

    public String getResponseS() {
        return
                given()
                        .baseUri(URL)
                        .basePath(PATH)
                        .contentType(ContentType.JSON)
                        .when()
                        .get().jsonPath()
                        .get("code").toString();
    }

    //201

    public String postRequest() {
        return
                given()
                        .auth()
                        .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                        .baseUri("https://gorest.co.in/public-api/users")
                        .header("Content-type", "application/json")
                        .and().body(requestBody).when()
                        .post().jsonPath()
                        .get("code").toString();

    }

    //204
    public String deleteRequest() {
        return
                given()
                        .auth()
                        .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                        .baseUri("https://gorest.co.in/public-api/users/2224")
                        .delete().jsonPath()
                        .get("code").toString();
    }

    //401
    public String beadRequest() {
        return
                given()
                        .baseUri("https://gorest.co.in/public-api/users/2712")
                        .delete().jsonPath()
                        .get("code").toString();
    }

    //404
    public String postBRequest() {
        return
                given()
                        .baseUri(URL)
                        .basePath(PATH2)
                        .contentType(ContentType.JSON).when()
                        .get().jsonPath()
                        .get("code").toString();
    }

    //422

    public String postRequests() {
        return
                given()
                        .auth()
                        .oauth2("00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61")
                        .baseUri("https://gorest.co.in/public-api/users")
                        .header("Content-type", "application/json")
                        .and().body(requestBody).when()
                        .post().jsonPath()
                        .get("code").toString();
    }
//200 201 204 401 404 422 429
}

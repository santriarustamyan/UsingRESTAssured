package api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Requests {

    public String body(UserData userData) {
        return new Gson().toJson(userData);
    }

    public String getRequest(String baseUrl, String basePath, String id, String code) {
        return
                given()
                        .baseUri(baseUrl)
                        .basePath(basePath + id)
                        .contentType(ContentType.JSON)
                        .when()
                        .get().jsonPath()
                        .get(code).toString();
    }

    public String getLastUserId() {
        List<UserData> value = given()
                .baseUri(Constants.URL)
                .basePath(Constants.PATH)
                .contentType(ContentType.JSON)
                .when()
                .get().jsonPath().getList("data", UserData.class);

        return Integer.toString(value.get(0).getId());


    }

    public String postRequest(String token, String baseUrl, String basePath, String body) {
        return
                given()
                        .auth()
                        .oauth2(token)
                        .baseUri(baseUrl)
                        .basePath(basePath)
                        .header("Content-type", "application/json")
                        .and().body(body).when()
                        .post().jsonPath()
                        .get("code").toString();
    }

    public String deleteRequest(String token, String baseUrl, String basePath, String id) {
        return
                given()
                        .auth()
                        .oauth2(token)
                        .baseUri(baseUrl)
                        .basePath(basePath + id)
                        .delete().jsonPath()
                        .get("code").toString();
    }
}

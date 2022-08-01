package api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import java.util.List;
import static io.restassured.RestAssured.given;

public class Requests {
    UserData userData = new UserData();
    UserData badUserData = new UserData("");
    private String TOKEN = "00a22c9cdb577d74f1353d655062853bcd27072ec7dc0c473b88675d55ce4d61";
    private String wrongToken = "00a22c9cdb577d74f1353d655062853bcd270";
    private final static String URL = "https://gorest.co.in/";
    private final static String PATH = "/public-api/users/";

    private String body(UserData userData) {
        return new Gson().toJson(userData);
    }


    public String getRequest(String id) {
        return
                given()
                        .baseUri(URL)
                        .basePath(PATH + id)
                        .contentType(ContentType.JSON)
                        .when()
                        .get().jsonPath()
                        .get("code").toString();
    }

    public String getLastUserId() {
        List<UserData> value = given()
                .baseUri(URL)
                .basePath(PATH)
                .contentType(ContentType.JSON)
                .when()
                .get().jsonPath().getList("data", UserData.class);

        return Integer.toString(value.get(0).id);
    }


    public String postRequest(String token, String body) {

        return
                given()
                        .auth()
                        .oauth2(token)
                        .baseUri(URL)
                        .basePath(PATH)
                        .header("Content-type", "application/json")
                        .and().body(body).when()
                        .post().jsonPath()
                        .get("code").toString();

    }

    public String deleteRequest(String id) {
        return
                given()
                        .auth()
                        .oauth2(TOKEN)
                        .baseUri(URL)
                        .basePath(PATH + id)
                        .delete().jsonPath()
                        .get("code").toString();
    }

    public String rec200() {

        return getRequest(getLastUserId());
    }

    public String rec201() {
        return postRequest(TOKEN, body(userData));
    }

    public String rec204() {
        return deleteRequest(getLastUserId());
    }

    public String rec401() {
        return postRequest(wrongToken, body(userData));
    }

    public String rec404() {

        return getRequest("BadRequest");
    }

    public String rec422() {
        return postRequest(TOKEN, body(badUserData));
    }


}

package api;

import com.google.gson.Gson;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Requests {
    UserData userData = new UserData();


    public static String body(UserData userData) {
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

//        getRequest(URL,PATH,"".;
    }
//    getRequest(URL,PATH,"", "code").toString();

    public String postRequest(String token, String body) {

        return
                given()
                        .auth()
                        .oauth2(token)
                        .baseUri(Constants.URL)
                        .basePath(Constants.PATH)
                        .header("Content-type", "application/json")
                        .and().body(body).when()
                        .post().jsonPath()
                        .get("code").toString();

    }

    public String deleteRequest(String id) {
        return
                given()
                        .auth()
                        .oauth2(Constants.TOKEN)
                        .baseUri(Constants.URL)
                        .basePath(Constants.PATH + id)
                        .delete().jsonPath()
                        .get("code").toString();
    }

    public String rec200() {

        return getRequest(Constants.URL, Constants.PATH + getLastUserId(), "", "code");
    }



    public String rec204() {
        return deleteRequest(getLastUserId());
    }

    public String rec401() {
        return postRequest(Constants.wrongToken, body(userData));
    }



    public String rec422() {
        userData.setEmail("");
        return postRequest(Constants.TOKEN, body(userData));
    }


}

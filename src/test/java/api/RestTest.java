package api;

import org.junit.Assert;
import org.junit.Test;

public class RestTest {
    Requests request = new Requests();

    @Test

    public void testAPI() {
        UserData userData = new UserData();

        Assert.assertEquals(request.getRequest(Constants.URL, Constants.PATH + request.getLastUserId(), "", "code"), "200");

        Assert.assertEquals(request.postRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.body(new UserData())), "201");

        Assert.assertEquals(request.deleteRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.getLastUserId()), "204");

        Assert.assertEquals(request.postRequest(Constants.wrongToken, Constants.URL, Constants.PATH, request.body(userData)), "401");

        Assert.assertEquals(request.getRequest(Constants.URL, Constants.PATH, "BadId", "code"), "404");

        userData.setEmail("");
        Assert.assertEquals(request.postRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.body(userData)), "422");

    }
}

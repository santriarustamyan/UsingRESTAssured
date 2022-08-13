package api;

import org.junit.Assert;
import org.junit.Test;

public class RestTest {
    Requests request = new Requests();

    @Test
    public void testAPI200() {
        Assert.assertEquals(request.getRequest(Constants.URL, Constants.PATH + request.getLastUserId(), "", "code"), "200");
    }

    @Test
    public void testAPI201() {
        UserData userData = new UserData();
        Assert.assertEquals(request.postRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.body(userData)), "201");
    }

    @Test
    public void testAPI204() {
        Assert.assertEquals(request.deleteRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.getLastUserId()), "204");
    }

    @Test
    public void testAPI401() {
        UserData userData = new UserData();
        Assert.assertEquals(request.postRequest(Constants.wrongToken, Constants.URL, Constants.PATH, request.body(userData)), "401");
    }

    @Test
    public void testAPI404() {
        Assert.assertEquals(request.getRequest(Constants.URL, Constants.PATH, "BadId", "code"), "404");
    }

    @Test
    public void testAPI422() {
        UserData userData = new UserData();
        userData.setEmail("");
        Assert.assertEquals(request.postRequest(Constants.TOKEN, Constants.URL, Constants.PATH, request.body(userData)), "422");
    }
}

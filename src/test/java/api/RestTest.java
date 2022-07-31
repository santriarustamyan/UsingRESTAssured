package api;

import org.junit.Test;

public class RestTest {

    Requests requests = new Requests();

    @Test

        public void getTest() {
        System.out.println("Response Body is: " + requests.getResponseS());
        System.out.println("Response Body is: " + requests.postRequest());
        System.out.println("Response Body is: " + requests.deleteRequest());
        System.out.println("Response Body is: " + requests.beadRequest());
        System.out.println("Response Body is: " + requests.postBRequest());
        System.out.println("Response Body is: " + requests.postRequests());

}}

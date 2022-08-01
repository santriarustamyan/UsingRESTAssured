package api;

import org.junit.Assert;
import org.junit.Test;

public class RestTest {
    Requests request = new Requests();

    @Test

        public void testAPI() {

//        System.out.println("Response code is: " + request.rec200());
        Assert.assertEquals(request.rec200(),"200");

//        System.out.println("Response code is: " + request.rec201());
        Assert.assertEquals(request.rec201(),"201");

//        System.out.println("Response code is: " + request.rec204());
        Assert.assertEquals(request.rec204(),"204");

//        System.out.println("Response code is: " + request.rec401());
        Assert.assertEquals(request.rec401(),"401");

//        System.out.println("Response code is: " + request.rec404());
        Assert.assertEquals(request.rec404(),"404");

//        System.out.println("Response code is: " + request.rec422());
        Assert.assertEquals(request.rec422(),"422");

}}

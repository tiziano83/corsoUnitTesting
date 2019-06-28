package com.example.unittesting.unittesting;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResposnse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\": 100}";
        JSONAssert.assertEquals(expectedResposnse,actualResponse,true);

    }
    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResposnse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResposnse,actualResponse,false);

    }
    @Test
    public void jsonAssert_withoutEscape() throws JSONException {
        String expectedResposnse = "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedResposnse,actualResponse,false);

    }
}

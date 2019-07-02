package com.example.unittesting.unittesting;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService = "[" +

                "  {" +
                "    \"id\": 1000,\"name\": \"pencil\",\"quantity\": 5" +
                "  }," +
                "  {" +
                "    \"id\": 1001,\"name\": \"pen\",\"quantity\": 15" +
                "  }," +
                "  {" +
                "    \"id\": 1002,\"name\": \"eraser\",\"quantity\": 10" +
                "  }" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> idList = context.read("$..id");
        assertThat(idList).containsExactly(1000,1001,1002);
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(context.read("$.[?(@.quantity==5)]").toString());

    }
}

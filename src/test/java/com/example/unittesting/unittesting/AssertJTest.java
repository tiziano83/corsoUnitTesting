package com.example.unittesting.unittesting;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);
        assertThat(numbers).hasSize(3)
                           .contains(12,15)
                           .allMatch(x ->  x > 10);
        assertThat("").isEmpty();
        assertThat("ABCD").startsWith("A")
                                 .contains("BCD")
                                 .endsWith("DE");

    }
}

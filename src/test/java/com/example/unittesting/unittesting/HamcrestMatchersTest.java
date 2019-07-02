package com.example.unittesting.unittesting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);
        assertThat(numbers,hasSize(3));
        assertThat(numbers,hasItems(12,45));
        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat(numbers,everyItem(lessThan(100)));

        assertThat("",isEmptyString());
        assertThat("ABCDE",containsString("BCD"));
        assertThat("ABCDE",startsWith("ABC"));
        assertThat("ABCDE",endsWith("DE"));
    }
}

package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessImpl {
    private SomeDataService someDataService;


    public SomeDataService getSomeDataService() {
        return someDataService;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);


    }

    public int calculateSumUsingService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();

        for (int datum : data) {
            sum += datum;
        }

        return sum;
    }
}

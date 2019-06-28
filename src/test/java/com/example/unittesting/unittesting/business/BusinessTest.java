package com.example.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessTest {



    @Test
    public void calculateSum_basic(){
        BusinessImpl business = new BusinessImpl();
        int ret = business.calculateSum(new int []{1,2,3});
        int expectedRes = 6;
        assertEquals(expectedRes,ret);
    }
    @Test
    public void calculateSum_empty(){
        BusinessImpl business = new BusinessImpl();
        int ret = business.calculateSum(new int []{});
        int expectedRes = 0;
        assertEquals(expectedRes,ret);
    }
    @Test
    public void calculateSum_oneValue(){
        BusinessImpl business = new BusinessImpl();
        int ret = business.calculateSum(new int []{5});
        int expectedRes = 5;
        assertEquals(expectedRes,ret);
    }
}

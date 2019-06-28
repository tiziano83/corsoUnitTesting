package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessStubTest {

   class SomeDataServiceStub implements SomeDataService{

       @Override
       public int[] retrieveAllData() {
           return new int[]{1,2,3};
       }
   }

    class SomeDataServiceEmptyStub implements SomeDataService{

        @Override
        public int[] retrieveAllData() {
            return new int[]{};
        }
    }
        class SomeDataServiceOneValueStub implements SomeDataService{

        @Override
        public int[] retrieveAllData() {
            return new int[]{5};
        }
    }


    @Test
    public void calculateSumUsingDataService_basic(){
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int ret = business.calculateSumUsingService();
        int expectedRes = 6;
        assertEquals(expectedRes,ret);
    }
    @Test
    public void calculateSumUsingDataService_empty(){
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int ret = business.calculateSumUsingService();
        int expectedRes = 0;
        assertEquals(expectedRes,ret);
    }
    @Test
    public void calculateSumUsingDataService_oneValue(){
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneValueStub());
        int ret = business.calculateSumUsingService();
        int expectedRes = 5;
        assertEquals(expectedRes,ret);
    }
}

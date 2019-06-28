package com.example.unittesting.unittesting.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.*;

public class ListMockTest {

    private List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void returnDifferentValues(){
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals(null,mock.get(1));
    }
    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals("in28Minutes",mock.get(1));
    }

    @Test
    public void verificationBasics(){
        //SUT
        String value = mock.get(0);
        String value2 = mock.get(1);
        //verify
        verify(mock).get(0);
        //verify(mock).get(anyInt());
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(anyInt());
    }
}

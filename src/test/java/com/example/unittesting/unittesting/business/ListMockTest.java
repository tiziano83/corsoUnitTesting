package com.example.unittesting.unittesting.business;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
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

    @Test
    public void argumentCapturing(){
        mock.add("SomeString");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeString",captor.getValue());
    }
    @Test
    public void multipleArgumentCapturing(){
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock,times(2)).add(captor.capture());

        List<String> allVAlues = captor.getAllValues();

        assertEquals("SomeString1",allVAlues.get(0));
        assertEquals("SomeString2",allVAlues.get(1));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

    }
    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test0");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("test");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(5);
        verify(arrayListSpy).add("test");
        System.out.println(arrayListSpy.size());

    }
}

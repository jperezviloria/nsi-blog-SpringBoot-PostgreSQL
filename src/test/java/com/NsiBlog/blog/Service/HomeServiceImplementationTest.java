package com.NsiBlog.blog.Service;

import com.NsiBlog.blog.service.implementation.HomeServiceImplementation;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


import java.util.concurrent.ExecutorService;


@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class HomeServiceImplementationTest {

    @Mock
    private ExecutorService executor;

    private HomeServiceImplementation homeServiceImplementation;

    @BeforeClass
    public void setup(){
        homeServiceImplementation = new HomeServiceImplementation(executor);
    }

    @Test
    void testHelloReturnString_HappyCase(){
        String string = homeServiceImplementation.hello(ImmutableList.of("2","4","7"));
        Assert.assertNotNull(string);
    }

    @Test(expected = NullPointerException.class)
    void testHelloFailsBecauseOfExecutorNullPointerException(){
        Mockito.when(executor.submit(() -> {})).thenThrow(new NullPointerException());
        homeServiceImplementation.hello(ImmutableList.of());
    }

    @Test(expected = NumberFormatException.class)
    void testInputWordsWithoutNumbers(){
        Mockito.when(executor.submit(() -> {})).thenThrow(new NullPointerException());
        homeServiceImplementation.hello(ImmutableList.of("Hola","2","4", "que","7","tal"));
    }


}

package com.NsiBlog.blog.service.implementation;


import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class HomeServiceImplementation {

    private ExecutorService executorService;

    @Autowired
    public HomeServiceImplementation( ExecutorService executorService){
        this.executorService = executorService;
    }

    public String hello(List<String> words){

        StringBuffer stringBuffer = new StringBuffer();
        //List<String> words = ImmutableList.of("Hola","2","4", "que","7","tal");
        CompletableFuture<String> futureString = produceFutureString("asdas");

        words.stream()
                .parallel()
                .filter(this::isValidNumber)
                //.map(this::convertToNumber) // -> Description down bellow
                .map(Integer::valueOf)
                .forEach(stringBuffer::append);

        return stringBuffer.toString();
    }

    private CompletableFuture<String> produceFutureString(String value){
        return CompletableFuture.supplyAsync(
                () -> String.format("%s - %s\n", value, "hello"),
                executorService);
    }

    private Boolean isValidNumber(String particularString){
        try{
            Integer value = Integer.valueOf(particularString);
            return true;
        }catch (NumberFormatException error){
            return false;
        }
    }

    //We can use a particular method but if Java have same functionality try to use it
    private Integer convertToNumber(String value){
        try{
            return Integer.valueOf(value);
        }catch (NumberFormatException error){
            return -1;
        }
    }


}

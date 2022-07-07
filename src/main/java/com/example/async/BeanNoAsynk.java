package com.example.async;

import org.springframework.stereotype.Component;

@Component(BeanFinder.BEAN_WITHOUT_ASYNC_METHOD)
public class BeanNoAsynk {

    public void method(){
    }
}

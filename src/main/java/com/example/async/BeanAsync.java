package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component(BeanFinder.BEAN_WITH_ASYNC_METHOD)
public class BeanAsync {

    @Async(BeanFinder.METHOD_WITH_ASYNC)
    @Annotation1
    public void method1() {
    }

    @Annotation1
    public void method2() {
    }

    public void method3() {
    }
}

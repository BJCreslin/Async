package com.example.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class BeanFinder {
    private final ApplicationContext applicationContext;

    public static final String BEAN_WITH_ASYNC_METHOD = "beanAsync";

    public static final String METHOD_WITH_ASYNC = "methodAsync";

    public static final String BEAN_WITHOUT_ASYNC_METHOD = "beanNoAsync";


    public BeanFinder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void findBean() {
        log.info("find async");

        Arrays.stream(applicationContext.getBeanDefinitionNames()).filter(x -> x.equalsIgnoreCase(BEAN_WITH_ASYNC_METHOD)).
            forEach(x -> Arrays.stream(applicationContext.getBean(x).getClass().getDeclaredMethods())
                .filter(y -> y.isAnnotationPresent(Annotation1.class)).forEach(y -> log.error(y.getName())));
    }

}

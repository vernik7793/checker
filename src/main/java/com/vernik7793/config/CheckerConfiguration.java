package com.vernik7793.config;

import com.vernik7793.PrototypeSubscriber;
import com.vernik7793.SingletonSubscriber;
import com.vernik7793.subscriber.IEventSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.util.function.Function;

@Configuration
@Import(PublisherConfiguration.class)
public class CheckerConfiguration {
    @Bean
    public IEventSubscriber singletonSubscriber() {
        return new SingletonSubscriber();
    }

    @Bean
    @Scope(value = "prototype")
    public IEventSubscriber prototypeSubscriber() {
        return new PrototypeSubscriber();
    }

    @Bean
    public Function<String, IEventSubscriber> prototypeFactory() {
        return beanName -> prototypeSubscriber();
    }

}
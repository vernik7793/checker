package com.vernik7793;

import com.vernik7793.config.CheckerConfiguration;
import com.vernik7793.publisher.Publisher;
import com.vernik7793.subscriber.IEventSubscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Function;

import static com.vernik7793.Utils.*;
import static org.junit.Assert.assertNotSame;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CheckerConfiguration.class})
public class PublisherTest {
    @Autowired
    private Publisher publisher;
    @Autowired
    private Function<String, IEventSubscriber> prototypeFactory;

    @Test
    public void test() {
        String stringContent = "";
        Double doubleContent = 0D;
        Long longContent = 0L;

        PrototypeSubscriber prototype1 = (PrototypeSubscriber)prototypeFactory.apply("prototypeSubscriber");
        PrototypeSubscriber prototype2 = (PrototypeSubscriber)prototypeFactory.apply("prototypeSubscriber");
        assertNotSame(prototype1, prototype2);
        publisher.send(HELLO_BEAN, stringContent);
        publisher.send(HELLO_SINGLETON, longContent);
        publisher.send(HELLO_PROTOTYPE, doubleContent);

    }
}
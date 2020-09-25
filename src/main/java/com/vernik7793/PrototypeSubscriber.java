package com.vernik7793;

import com.vernik7793.subscriber.IEventSubscriber;
import com.vernik7793.subscriber.Subscriber;

import static com.vernik7793.Utils.*;

@Subscriber(eventTypes = {HELLO_PROTOTYPE, HELLO_BEAN})
public class PrototypeSubscriber implements IEventSubscriber {
    @Override
    public void onEvent(String s, Object o) {
        System.out.println(prepareMessage(this, s, o));
    }
}
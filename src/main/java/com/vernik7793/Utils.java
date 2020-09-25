package com.vernik7793;

import com.vernik7793.subscriber.IEventSubscriber;

import static java.lang.String.format;

public class Utils {
    private Utils() {}

    public static final String HELLO_BEAN = "Привет, бин!";
    public static final String HELLO_PROTOTYPE = "Привет, прототип!";
    public static final String HELLO_SINGLETON = "Привет, синглтон!";

    public static String prepareMessage(IEventSubscriber subscriber, String eventType, Object content) {
        String pattern = "Бин типа %s получил сообщение \"%s\" с содержимым типа %s";
        return format(pattern, subscriber.getClass().getName(), eventType, content.getClass().getName());
    }
}
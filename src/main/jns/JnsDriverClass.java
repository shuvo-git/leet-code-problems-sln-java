package main.jns;

import main.jns.exceptions.TopicNotFoundException;
import main.jns.services.JNSService;
import main.jns.services.JNSServiceImpl;

public class JnsDriverClass {
    public static void main(String[] args) throws TopicNotFoundException {
        JNSService service = new JNSServiceImpl();
        service.createTopic("test-topic");
        service.publish("test-topic", "test message");
        service.subscribe("test-topic", "test message");
    }
}

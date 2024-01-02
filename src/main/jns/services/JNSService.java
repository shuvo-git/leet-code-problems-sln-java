package main.jns.services;

import main.jns.exceptions.TopicNotFoundException;

public interface JNSService {
    void createTopic(String topicName);
    void deleteTopic(String topicName) throws TopicNotFoundException;
    void publish(String topicName, String message) throws TopicNotFoundException;
    String subscribe(String topicName, String endPoint) throws TopicNotFoundException;
    void unSubscribe(String topicName, String subscriberId) throws TopicNotFoundException;
}

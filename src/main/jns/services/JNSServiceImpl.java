package main.jns.services;

import main.jns.exceptions.TopicNotFoundException;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class JNSServiceImpl implements JNSService {
    @Override
    public void createTopic(String topicName) {
        new JNSTopic(topicName);
    }

    @Override
    public void deleteTopic(String topicName) throws TopicNotFoundException {
        JNSTopic.deleteTopic(topicName);
    }

    @Override
    public void publish(String topicName, String message) throws TopicNotFoundException {
        JNSTopic topic = JNSTopic.findTopic(topicName);
        topic.getMessageQueue().add(message);
    }

    @Override
    public String subscribe(String topicName, String endPoint) throws TopicNotFoundException {
        JNSTopic topic = JNSTopic.findTopic(topicName);
        Set<String> subscriberIds = topic.getSubscriberIds();

        String uuid = UUID.randomUUID().toString();
        subscriberIds.add(uuid);

        topic.getEndPoints().put(uuid,endPoint);

        return uuid;
    }

    @Override
    public void unSubscribe(String topicName, String subscriberId) throws TopicNotFoundException {
        JNSTopic topic = JNSTopic.findTopic(topicName);
        Set<String> subscriberIds = topic.getSubscriberIds();

        topic.getEndPoints().remove(subscriberId);
        subscriberIds.remove(subscriberId);
    }
}

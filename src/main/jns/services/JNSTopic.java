package main.jns.services;

import main.jns.exceptions.TopicNotFoundException;

import java.util.*;

public class JNSTopic {
    private static Map<String, JNSTopic> topics = new Hashtable<>();

    private final String topicName;
    private Set<String> subscriberIds;
    private Map<String, String> endPoints;
    private Queue<String> messageQueue;
    public JNSTopic(String topicName) {
        this.topicName = topicName;
        this.messageQueue = new LinkedList<>();
        subscriberIds = new HashSet<>();
        endPoints = new Hashtable<>();
        topics.put(topicName, this);
    }

    public static void deleteTopic(String topicName) throws TopicNotFoundException {
        if (topics.containsKey(topicName)) {
            topics.remove(topicName);
        } else throw new TopicNotFoundException("Topic Not Found");
    }

    public static JNSTopic findTopic(String topicName) throws TopicNotFoundException {
        if (topics.containsKey(topicName)) {
            return topics.get(topicName);
        } else throw new TopicNotFoundException("Topic Not Found");
    }

    public Map<String, String> getEndPoints() {
        return endPoints;
    }

    public Set<String> getSubscriberIds() {
        return subscriberIds;
    }

    public Queue<String> getMessageQueue() {
        return messageQueue;
    }
}

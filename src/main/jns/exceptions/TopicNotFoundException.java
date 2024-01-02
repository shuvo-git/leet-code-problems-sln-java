package main.jns.exceptions;

public class TopicNotFoundException extends Exception{
    private final String message;

    public TopicNotFoundException(String message){
        super();
        this.message = message;
    }
}

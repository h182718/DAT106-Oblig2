package no.hvl.dat110.messages;

public class PublishMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method

    private String message;
    private String topicName;

    public PublishMsg(String user,String topicName, String message) {
        super(MessageType.PUBLISH, user);
        this.message = message;
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PublishMsg " + message + " to " + topicName;
    }
}

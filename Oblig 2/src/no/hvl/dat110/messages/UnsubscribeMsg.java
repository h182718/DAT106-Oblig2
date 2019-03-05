package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
	private String topicName;

    public UnsubscribeMsg(String user, String topicName) {
        super(MessageType.UNSUBSCRIBE, user);
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String toString() {
        return "UnsubscribeMsg to " + topicName;
    }
}

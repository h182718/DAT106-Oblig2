package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {
	
	// TODO: 
	// Implement objectvariables, constructor, get/set-methods, and toString method
    private String topicName;

    public DeleteTopicMsg(String user,String topicName ) {
        super(MessageType.DELETETOPIC, user);
        this.topicName = topicName;;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
   }

    @Override
    public String toString() {
        return "Deleted Message " + topicName;
    }
}
package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {

    private String topicName;

    public CreateTopicMsg(String user, String topicName) {
        super(MessageType.CREATETOPIC, user);
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
        return "Topic Message " + topicName;
    }
}

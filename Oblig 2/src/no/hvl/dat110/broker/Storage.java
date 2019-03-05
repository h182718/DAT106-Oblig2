package no.hvl.dat110.broker;

import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {

	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	protected ConcurrentHashMap<String, ClientSession> clients;
	protected ConcurrentHashMap<String, ArrayDeque<Message>> messages;

	public Storage() {
		subscriptions = new ConcurrentHashMap<>();
		clients = new ConcurrentHashMap<>();
		messages = new ConcurrentHashMap<>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}
	public ArrayDeque<Message> getMessageQueue(String user) {

		return messages.getOrDefault(user, new ArrayDeque<>());

	}

	public void queueMessage(String user, Message message) {
		messages.putIfAbsent(user, new ArrayDeque<>());
		messages.get(user).add(message);
	}

	public void clearMessageQueue(String user) {
		messages.remove(user);
	}


	public ClientSession hasSession(String user) {
		return clients.get(user);
	}


	public void addClientSession(String user, Connection connection) {

		ClientSession session = new ClientSession(user, connection);
		clients.put(user, session);
		
	}

	public void removeClientSession(String user) {

		clients.get(user).disconnect();
		clients.remove(user);
		
	}

	public void createTopic(String topic) {
		subscriptions.putIfAbsent(topic, new HashSet<>());
	
	}

	public void deleteTopic(String topic) {
		subscriptions.remove(topic);
		
	}

	public void addSubscriber(String user, String topic) {
		createTopic(topic);
		subscriptions.get(topic).add(user);
	}

	public void removeSubscriber(String user, String topic) {
		if(subscriptions.containsKey(topic)) {
			subscriptions.get(topic).remove(user);
		}

	}
}

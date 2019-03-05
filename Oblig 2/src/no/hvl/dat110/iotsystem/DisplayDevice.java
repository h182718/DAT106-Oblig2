package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START

		Client client = new Client("DisplayDevice", Common.BROKERHOST, Common.BROKERPORT);

		client.connect();
		client.subscribe(Common.TEMPTOPIC);

		for(int x = 0; x < COUNT; x++) {
			Message motatt = client.receive();
			System.out.println("DisplayDevice har motatt: " + motatt);
		}
		client.unsubscribe(Common.TEMPTOPIC);
		client.disconnect();

		// TODO - END
		
		System.out.println("Display stopping ... ");

	}
}

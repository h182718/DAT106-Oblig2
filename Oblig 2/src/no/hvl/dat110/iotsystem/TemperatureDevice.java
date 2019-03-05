package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {
	
	private static final int COUNT = 10;
	
	public static void main(String[] args) {
		
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		Client client = new Client("TempDevice", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();

		for(int x = 0; x < COUNT; x++) {
		    try {
		        Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.publish(Common.TEMPTOPIC, Integer.toString(sn.read()));
        }

        client.disconnect();
		// TODO - end
		
		System.out.println("Temperature device stopping ... ");

		
	}
}

package motfriday;

import org.bukkit.util.config.Configuration;

public class MOTD implements Runnable{
	String message;
	boolean isRunning;
	MOTFriday plugin;
	Thread motdThread;
	
	public MOTD(MOTFriday pl){
		Configuration config = pl.getConfiguration();
		message = config.getString("MOTD");
		plugin = pl;
		motdThread = new Thread(this);
	}
	
	public void startMOTD(){
		motdThread.start();
	}
	
	public void stopMOTD(){
		isRunning = false;
		//Stop the thread somehow
	}
	
	public void run(){
		isRunning = true;
		while(isRunning){
			plugin.getServer().broadcastMessage(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

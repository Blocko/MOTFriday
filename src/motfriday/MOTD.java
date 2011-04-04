package motfriday;

import org.bukkit.util.config.Configuration;

public class MOTD implements Runnable{
	String message;
	boolean stopped;
	MOTFriday plugin;
	Thread motdThread;
	
	public MOTD(MOTFriday pl){
		Configuration config = pl.getConfiguration();
		message = config.getString("MOTD");
		plugin = pl;
		stopped = false;
	}
	public void stopMOTD(){
		stopped = true;
		//Stop the thread somehow
	}
	
	public void run(){
		while(!stopped){
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

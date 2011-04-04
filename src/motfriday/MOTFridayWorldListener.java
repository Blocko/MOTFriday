package motfriday;

import org.bukkit.event.world.WorldListener;
import org.bukkit.event.world.WorldLoadEvent;

public class MOTFridayWorldListener extends WorldListener{
	MOTFriday plugin;
	MOTD controlMOTD = new MOTD(plugin);
	
	public MOTFridayWorldListener(MOTFriday friday){
		plugin = friday;
	}
	
	@Override
	public void onWorldLoad(WorldLoadEvent event){
		controlMOTD.startMOTD();
	}

}

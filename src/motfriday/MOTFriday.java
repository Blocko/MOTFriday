package motfriday;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTFriday extends JavaPlugin{
	
	private final MOTFridayWorldListener worldListener = new MOTFridayWorldListener(this);
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!" );
	}
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
    	pm.registerEvent(Event.Type.WORLD_LOAD, worldListener, Priority.Normal, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
	}

}

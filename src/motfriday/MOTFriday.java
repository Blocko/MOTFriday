package motfriday;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class MOTFriday extends JavaPlugin{
	
	MOTD motd;
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is disabled!" );
		motd.stopMOTD();
	}
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
		motd = new MOTD(this);
		new Thread(motd).start();
	}

}

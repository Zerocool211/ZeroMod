package zerocool211.mods.projectz;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProjectZ {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
	    //Item/Block init and registering
    	//Config handling
    }

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Proxy, TileEntity, entity, Gui and Packet Register
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}

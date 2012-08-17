package axalto.mods.lightningcraft;

import java.util.logging.Level;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "LightningCraft", name = "LightningCraft", version = "In-Dev 1.0")
@NetworkMod(
		channels = { "LightningCraft" },
		clientSideRequired = true,
		serverSideRequired = false,
		packetHandler = PacketHandler.class )
public class MailCraft
{
	@Instance
	public static MailCraft instance;
	
	@SidedProxy(clientSide = "axalto.mods.lightningcraft.ClientProxy", serverSide = "axalto.mods.lightningcraft.CommonProxy")
	public static CommonProxy proxy;
	
	// Blocks
	public static BlockLightningBox lightningBoxBlock;
	
	// Configuration Values
	private int bLightningBoxID;
	private int iLightningDustID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		// Initializing Metadata
		event.getModMetadata().version = "In-Dev 1.0";
		
		// Loading in Configuration Data
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try {
			cfg.load();
			
			// Load Block IDs
			bLightningBoxID = cfg.getOrCreateBlockIdProperty("LightningBox", 140).getInt(140);
			
			// Load Item IDs
			iLightningDustID = cfg.getOrCreateIntProperty("LightningDust", Configuration.CATEGORY_ITEM, 400).getInt(400);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "LightningCraft's configuration failed to load.");
		} finally {
			cfg.save();
		}
	}
	
	@Init
	public void init(FMLInitializationEvent evt)
	{
		// Initialize Blocks
		lightningBoxBlock = new BlockLightningBox(bLightningBoxID);
		
		// Register Blocks
		GameRegistry.registerBlock(lightningBoxBlock);
		
		// Register Recipes
		GameRegistry.addRecipe(new ItemStack(lightningBoxBlock, 1),
				" x ",
				"xyx",
				" x ",
	            'x', Block.stone,
	            'y', Block.wood
	        );
		
		// Register Rendering Information
		proxy.registerRenderInformation();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt)
	{
		// TODO: Add Post-Initialization code such as mod hooks
	}
}

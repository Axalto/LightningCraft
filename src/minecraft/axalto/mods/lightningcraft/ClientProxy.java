package axalto.mods.lightningcraft;

import axalto.mods.lightningcraft.CommonProxy;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/lightningcraft.png");
	}

	@Override
	public void registerTileEntitySpecialRenderer(/*PLACEHOLDER*/)
	{
		
	}

	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
}

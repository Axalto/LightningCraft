package axalto.mods.lightningcraft;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockLightningBox extends Block
{
	public BlockLightningBox(int id)
	{
		super(id, Material.rock);
		setHardness(3.0f);
		
		setBlockName("LightningBox");
		blockIndexInTexture = 0;
		
		setRequiresSelfNotify();
		disableStats();
	}
	
	@Override
	public String getTextureFile() {
		return "/lightningcraft.png";
	}
	
	@Override
	public int getBlockTextureFromSide(int side)
	{
		switch(side)
        {
        case 0:
                return blockIndexInTexture + 1;
        case 1:
                return blockIndexInTexture + 1;
        }
        return blockIndexInTexture;
	}
}

package realtech.block;

import realtech.lib.Reference;
import realtech.proxy.ClientProxy;
import realtech.tileentity.TileCableBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class CableBlock extends BlockContainer implements IRTEnergy{
	private String location;
	
	{
	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	public CableBlock(int par1, Material par2Material, String location) {
		super(par1, par2Material);
		this.location = location;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	public int getRenderType(){
		return ClientProxy.cableType;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":"+location);
	}

	@Override
	public boolean canConnectTo(Block block, ForgeDirection side) {
		if(this.blockID == block.blockID){
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileCableBlock();
	}
}

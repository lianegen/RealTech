package realtech.block;

import realtech.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UnSolidBlock extends Block{
	
	private String location;
	
	public UnSolidBlock(int id, Material material, String location) {
		super(id, material);
		this.location = location;
		this.setCreativeTab(CreativeTabs.tabRedstone);
		}
	//zacatek x y z konec x y z
		{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);	
		}
		
		@Override
		public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
	    {
			if (side == -1)
				return false;
	
			return true;    
	    }
		@Override
		public boolean canProvidePower()
		{
			return true;
		}
		
		@Override
		public boolean isOpaqueCube(){
			return true;
		}
		@Override
		public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
		
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":"+location);
	}
}
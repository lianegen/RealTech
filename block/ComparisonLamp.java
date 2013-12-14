package realtech.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import realtech.RealTech;
import realtech.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ComparisonLamp extends Block{
	
	private String location;
	private boolean powered;
	
	public ComparisonLamp(int id, Material material, String location, boolean light) {
		super(id, material);
		this.location = location;
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.powered = light;
		if(light)
		{
			this.setLightValue(1F);
		}
		}
		
		@Override
		public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
	    {
			if (side == -1)
				return false;
	
			return true;    
	    }
		
		@Override
		public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return RealTech.comparison_lamp_off.blockID;
	    }
		
		public void onBlockAdded(World par1World, int par2, int par3, int par4)
		{
			if (!par1World.isRemote)
	        {
	        	int power = par1World.getStrongestIndirectPower(par2, par3, par4);
	        	if(power == 0){
	        		par1World.setBlock(par2, par3, par4, RealTech.comparison_lamp_off.blockID);
	        	}else{
	        		par1World.setBlock(par2, par3, par4, RealTech.comparison_lamp_on.blockID);
	        		par1World.setBlockMetadataWithNotify(par2, par3, par4, power, 2);	        
	        	}
	        }
		}

		public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	    {
			if (!par1World.isRemote)
	        {
	        	int power = par1World.getStrongestIndirectPower(par2, par3, par4);
	        	if(power == 0){
	        		par1World.setBlock(par2, par3, par4, RealTech.comparison_lamp_off.blockID);
	        	}else{
	        		par1World.setBlock(par2, par3, par4, RealTech.comparison_lamp_on.blockID);
	        		par1World.setBlockMetadataWithNotify(par2, par3, par4, power, 2);	        
	        	}
	        }
	    }
		
	public Icon getIcon(int par1, int par2)
	{
		return this.icons[par2];
	}
		
	@SideOnly(Side.CLIENT)
	private Icon[] icons = new Icon[16];			
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		for(int i = 0; i < 16; i++){
			this.icons[i] = par1.registerIcon(Reference.modid + ":"+location + i);
		}
	}
}
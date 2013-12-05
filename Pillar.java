package testing;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Pillar extends Block{
	
	private String location;
	
	public Pillar(int id, Material material, String location) {
		super(id, material);
		this.location = location;
		}
	//zacatek x y z konec x y z
	{
	this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
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
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		icons = new Icon[6];
		
		for(int i = 0; i<icons.length; i++){
			icons[i] = par1.registerIcon("testing:"+location+i);
		}
	}
	
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z){
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	 {
	        return icons[par2];
	 }
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int var4 = 0; var4 < 6; ++var4)
	    {
	        par3List.add(new ItemStack(par1, 1, var4));
	    }
	}
	 @Override
	public int damageDropped(int par1)
	 {
	     return par1;

	 }
}
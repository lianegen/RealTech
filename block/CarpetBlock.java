package realtech.block;

import realtech.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CarpetBlock extends Block{
	
	private String location;
	
	public CarpetBlock(int id, Material material, String location) {
		super(id, material);
		this.location = location;
		}
	//zacatek x y z konec x y z
		{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":"+location);
	}
}
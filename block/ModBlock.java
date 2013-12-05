package realtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlock extends Block{
	
	private String location;
	
	public ModBlock(int id, Material material, String location) {
		super(id, material);
		this.location = location;
		}
	//zacatek x y z konec x y z
		{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		@Override
		public boolean isOpaqueCube(){
			return true;
		}
		@Override
		public boolean renderAsNormalBlock()
	    {
	        return true;
	    }
		
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon("testing:"+location);
	}
}
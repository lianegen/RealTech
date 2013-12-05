package realtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SolidBlock extends Block{
	
	private String location;
	
	public SolidBlock(int id, Material material, String location) {
		super(id, material);
		this.location = location;
		}
	//zacatek x y z konec x y z

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
	public int getRenderBlockPass(){
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon("testing:"+location);
	}
}
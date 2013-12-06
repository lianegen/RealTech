package realtech.block;

import realtech.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HardOreBlock extends Block{
	
	private String location;
		
		public HardOreBlock(int id, Material material, String location) {
			super(id, material);
			this.location = location;
			}
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			this.blockIcon = par1.registerIcon(Reference.modid + ":"+location);
		}
}
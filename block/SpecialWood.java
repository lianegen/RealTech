package realtech.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import realtech.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SpecialWood extends BlockRotatedPillar{
		
		private String location;
		
		public SpecialWood(int id, Material material, String location) {
			super(id, material);
			this.location = location;
			}
		
		@SideOnly(Side.CLIENT)
		private Icon[] icons;
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			icons = new Icon[2];
			
			for(int i = 0; i<icons.length; i++){
				icons[i] = par1.registerIcon(Reference.modid + ":"+location+i);
			}
		}
		 @Override
		public int damageDropped(int par1)
		 {
		     return par1;
		 }
		@Override
		@SideOnly(Side.CLIENT)
		protected Icon getSideIcon(int i) {
			return icons[0];
		}
		@Override
		protected Icon getEndIcon(int par1){
	        return icons[1];
	    }
	}
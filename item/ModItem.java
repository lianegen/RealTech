package realtech.item;

import realtech.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ModItem extends Item{

	private String location;
	
		public ModItem(int id, String location) {
			super(id);
			
			this.location = location;
		}
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			this.itemIcon = par1.registerIcon(Reference.modid + ":"+location);
		}
}
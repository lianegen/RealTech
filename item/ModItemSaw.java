package realtech.item;

import realtech.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItemSaw extends Item{

	private String location;
	
		public ModItemSaw(int id, String location) {
			super(id);
			
			this.location = location;
		}
		
		@Override
		public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
	    {
	        return false;
	    }
		
		@Override
	    public ItemStack getContainerItemStack(ItemStack itemStack) {

	        ItemStack copiedStack = itemStack.copy();

	        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);

	        copiedStack.stackSize = 1;

	        return copiedStack;
	    }
		
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			this.itemIcon = par1.registerIcon(Reference.modid + ":"+location);
		}
}
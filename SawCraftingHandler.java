package testing;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class SawCraftingHandler implements ICraftingHandler
{
	ICraftingHandler SawCraftingHandler = new ICraftingHandler(){

		@Override
		public void onCrafting(EntityPlayer player, ItemStack item,
				IInventory craftMatrix) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSmelting(EntityPlayer player, ItemStack item) {
			// TODO Auto-generated method stub
			
		}};

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		/*This onCrafting Handle is for Sword and Coconut Recipe
	* 0-1-2
	* 3-4-5
	* 6-7-8
	*/
		
		int slot = 0;
		ItemStack shouldBeSaw = null;
		int i;
		
	for(i = 0; i < 9; i++){
	shouldBeSaw = craftMatrix.getStackInSlot(i);
		
	if(shouldBeSaw != null){
		if(shouldBeSaw.itemID == Main.saw.itemID)
		{
			slot = i;
			i = 20;
		}
	}
	}
	if((i >= 20) && (shouldBeSaw != null)){
	//Put Saw Back
		ItemStack tempItem1 = shouldBeSaw.getItem().getContainerItemStack(shouldBeSaw);
		craftMatrix.setInventorySlotContents(slot, tempItem1);
	}
	}
	

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}
}
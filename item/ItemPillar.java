package realtech.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPillar extends ItemBlock {

	public ItemPillar(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	@Override
	public String getUnlocalizedName(ItemStack par1){
		String name = "";
		switch(par1.getItemDamage()){
		case 0:{
			name = "Oak pillar";
			break;
		}
		
		case 1:{
			name = "Spruce pillar";
			break;
		}
		
		case 2:{
			name = "Birch pillar";
			break;
		}
		
		case 3:{
			name = "Jungle pillar";
			break;
		}
		
		case 4:{
			name = "Rubber pillar";
			break;
		}
		
		case 5:{
			name = "Yew pillar";
			break;
		}
		
		default:name = "broken";
		}
		
		return getUnlocalizedName()+"."+name;	
	}
	
	@Override
	public int getMetadata(int par1){
		return par1;
		}
}
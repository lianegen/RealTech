package realtech.block;

import java.util.Random;

import realtech.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagnetiteOreBlock extends Block{
	
	private String location;
		
		public MagnetiteOreBlock(int id, Material material, String location) {
			super(id, material);
			this.location = location;
			}
		//zacatek x y z konec x y z
			
			 @Override
			public int idDropped(int par1, Random par2Random, int par3)
			    {
			        return Main.magnetite_dust.itemID;
			    }
			 // nahodna sance dropnou item
			 @Override
			public int quantityDropped(Random par1Random)
			    {
			        return 1 + par1Random.nextInt(3);
			    }
			
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1){
			this.blockIcon = par1.registerIcon("testing:"+location);
		}
}
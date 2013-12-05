package testing;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LadderBlock extends Block{

	private String location;
	
		@Override
		public boolean isOpaqueCube(){
			return false;
		}
		@Override
		public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
		
		public LadderBlock(int id, Material blockMaterial,String location) {
			super(id, blockMaterial);
			this.location = location;
		}
		@Override
		public boolean isLadder(World world, int x, int y, int z, EntityLivingBase entity)
	    {
	        return true;
	    }
		
		@Override
		public void setBlockBoundsForItemRender() {
			this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
		}
		  @Override
		public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
		    {
			  int metadata = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
					  switch(metadata){
					  case 4:this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
					  break;
					  case 5:this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
					  break;
					  case 2:this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
					  break;
					  case 3:this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
					  break;
					  }
		    }
		 	@Override
			public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
		    {
		        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		    }
		 	
			@SideOnly(Side.CLIENT)
			private Icon iconSide;
			@SideOnly(Side.CLIENT)
			private Icon iconFront;
				
				@Override
				public void onBlockAdded(World par1World, int par2, int par3, int par4)
			    {
			        super.onBlockAdded(par1World, par2, par3, par4);
			        this.setDefaultDirection(par1World, par2, par3, par4);
			    }
				
				/**
			     * set a blocks direction
			     */
			    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
			    {
			        if (!par1World.isRemote)
			        {
			            int l = par1World.getBlockId(par2, par3, par4 - 1);
			            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			            byte b0 = 3;

			            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
			            {
			                b0 = 3;
			            }

			            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
			            {
			                b0 = 2;
			            }

			            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
			            {
			                b0 = 5;
			            }

			            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
			            {
			                b0 = 4;
			            }

			            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
			        }
			    }
				
			    @Override
				@SideOnly(Side.CLIENT)

			    /**
			     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
			     * is the only chance you get to register icons.
			     */
			    public void registerIcons(IconRegister par1IconRegister)
			    {
			        this.iconFront = par1IconRegister.registerIcon("testing:"+location + "_front");
			        this.iconSide = par1IconRegister.registerIcon("testing:"+location + "_side");
			    } 
				/**
			     * Called when the block is placed in the world.
			     */
			    @Override
				public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
			    {
			        int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

			        if (l == 0)
			        {
			            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			        }

			        if (l == 1)
			        {
			            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			        }

			        if (l == 2)
			        {
			            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			        }

			        if (l == 3)
			        {
			            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			        }
			    }
			    
			    @Override
				@SideOnly(Side.CLIENT)
			    public Icon getIcon(int par1, int par2)
			    {
			        return par1 == 1 ? this.iconSide :
			        		(par1 == 0 ? this.iconSide :
			        		(par1 == 2 ? this.iconFront :
			        		(par1 == 3 ? this.iconFront :
			        		(par1 == 4 ? this.iconFront :
			        		(par1 == 5 ? this.iconFront :
			        		(par1 != par2 ? this.iconSide : this.iconFront))))));
			    }
}
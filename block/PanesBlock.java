package realtech.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PanesBlock extends Block{
	
	private String location;
	//zacatek x y z konec x y z
	{
	this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0625F, 1.0F, 1.0F);
	}
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
	public PanesBlock(int id, Material blockMaterial,String location) {
		super(id, blockMaterial);
		this.location = location;
	}	
	@Override
	public void setBlockBoundsForItemRender() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0625F);
	}
	  @Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    {
		  int metadata = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
				  switch(metadata){
				  case 4:this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0625F, 1.0F, 1.0F);
				  break;
				  case 5:this.setBlockBounds(0.9375F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				  break;
				  case 2:this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0625F);
				  break;
				  case 3:this.setBlockBounds(0.0F, 0.0F, 0.9375F, 1.0F, 1.0F, 1.0F);
				  break;
				  case 0:this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
				  break;
				  case 1:this.setBlockBounds(0.0F, 0.9375F, 0.0F, 1.0F, 1.0F, 1.0F);
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
		private int nl;
		private int ml;
			
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
		        this.blockIcon = par1IconRegister.registerIcon("testing:" + location);
		    } 
		    
		    @Override
			public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
		    {
		        return par5 != 0 && (par5 == 1 || par7 <= 0.5D) ? par9 : par9 | 8;
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
			public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
		    {
		        par5Entity.attackEntityFrom(DamageSource.cactus, 1.0F);
		    }
}
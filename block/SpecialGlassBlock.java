package realtech.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)

public class SpecialGlassBlock extends BlockBreakable{
	
	@SideOnly(Side.CLIENT)
	private String location;
	@SideOnly(Side.CLIENT)
	private Icon iconSide;
	@SideOnly(Side.CLIENT)
	private Icon iconFront;
	
	public SpecialGlassBlock(int id, Material material, String location,boolean par3) {
		super(id, "glass", material, par3);
		this.location = location;
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
		public int getRenderBlockPass()
	    {
	        return 0;
	    }
		
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
	        this.iconSide = par1IconRegister.registerIcon("testing:"+location + "_side");
	    } 
		/**
	     * Called when the block is placed in the world.
	     */
	    @Override
		public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	    {
	        int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
	        
	        Block txt = Block.blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
	        if(txt != null)
	        	iconFront = txt.getBlockTextureFromSide(2);
	        else
	        	iconFront = iconSide;

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

	        if (par6ItemStack.hasDisplayName())
	        {
	            ((TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
	        }
	    }
	    
	    @Override
		@SideOnly(Side.CLIENT)
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? this.iconSide : (par1 == 0 ? this.iconSide : (par1 != par2 ? this.iconSide : this.iconFront));
	    }
	}
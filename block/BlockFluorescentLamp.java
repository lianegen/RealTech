package realtech.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import realtech.lib.Pix;
import realtech.lib.Reference;
import realtech.tileentity.TileEntityFluorescentLamp;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluorescentLamp extends BlockContainer{
	
	private String location;

	public BlockFluorescentLamp(int par1, Material par2Material, String location) {
		super(par1, par2Material);
		this.location = location;
	}
	//16,4,6
	@Override
		public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
		    {
			  int metadata = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
					  switch(metadata){
					  case 5:this.setBlockBounds(Pix.TWELVE,Pix.FIVE,0,Pix.SIXTEEN,Pix.ELEVEN,Pix.SIXTEEN);
					  break;
					  case 4:this.setBlockBounds(0,Pix.FIVE,0,Pix.FOUR,Pix.ELEVEN,Pix.SIXTEEN);
					  break;
					  case 3:this.setBlockBounds(0,Pix.FIVE,0,Pix.SIXTEEN,Pix.ELEVEN,Pix.FOUR);
					  break;
					  case 2:this.setBlockBounds(0,Pix.FIVE,Pix.TWELVE,Pix.SIXTEEN,Pix.ELEVEN,Pix.SIXTEEN);
					  break;
					  case 1:this.setBlockBounds(Pix.FIVE,Pix.TWELVE,0,Pix.ELEVEN,Pix.SIXTEEN,Pix.SIXTEEN);
						  break;
					  case 0:this.setBlockBounds(0,Pix.TWELVE,Pix.FIVE,Pix.SIXTEEN,Pix.SIXTEEN,Pix.ELEVEN);
						  break;
					  }
		    }
		 	@Override
			public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
		    {
		        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
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
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFluorescentLamp();
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		byte meta = (byte) world.getBlockMetadata(x, y, z);
		switch(meta){
		case 4:
			if(world.isBlockSolidOnSide(x - 1, y, z, EAST ))
				return true;
			return false;
		case 5:
			if(world.isBlockSolidOnSide(x + 1, y, z, WEST ))
				return true;
			return false;
		case 3:
			if(world.isBlockSolidOnSide(x, y, z - 1, SOUTH ))
				return true;
			return false;
		case 2:
			if(world.isBlockSolidOnSide(x, y, z + 1, NORTH ))
				return true;
			return false;
		case 1:
			if(world.isBlockSolidOnSide(x, y + 1, z, DOWN ))
				return true;
			return false;
		case 0:
			if(world.isBlockSolidOnSide(x, y + 1, z, DOWN ))
				return true;
			return false;
		default:
			return false;
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if(!this.canBlockStay(par1World, par2, par3, par4)){
			this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
			par1World.setBlockToAir(par2, par3, par4);
		}
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST )) ||
               (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN ));
    }
	
	@Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase ELB, ItemStack par6ItemStack) {
    	if(par1World.getBlockMetadata(par2, par3, par4) == 1){		
    		float rotation = ELB.getRotationYawHead();
    		
    		while(rotation > 360F)
    			rotation -= 360F;
    		
    		while(rotation < -360F)
    			rotation += 360F;
    			
    		if(((rotation < 45F)&&(rotation > -45F))||((rotation < -135F)&&(rotation > -225F))||((rotation > 135F)&&(rotation < 225F))||((rotation > 315F))||(rotation < -315F)){
    			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
    		}	
    	}
    }
	
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        if (par5 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (par5 == 5)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par5 == 4)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (par5 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }
        if (par5 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }
        return par1World.getBlockMetadata(par2, par3, par4);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1){
		this.blockIcon = par1.registerIcon(Reference.modid + ":"+location);
	}

}

package realtech.renderer;

import realtech.block.IRTEnergy;
import realtech.lib.Pix;
import realtech.proxy.ClientProxy;
import realtech.tileentity.TileCableBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import easytessellator.EasyTess;

public class CableRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		Tessellator tes = Tessellator.instance;
		int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
		tes.setBrightness(lightValue);
		tes.setColorOpaque_F(1.0F, 1.0F, 1.0F);
				
		Icon icon = block.getIcon(0, 0);
		
		boolean connected = false;
		int connects = 0;
		Block blockCon = Block.blocksList[world.getBlockId(x + 1, y, z)];
		if(blockCon instanceof IRTEnergy){
			boolean b = ((IRTEnergy) blockCon).canConnectTo(block, ForgeDirection.WEST);
			if(b){
				connected = true;
				connects++;
				EasyTess.renderCube(x + Pix.NINE, y, z + Pix.SEVEN, 7, 1, 2, 0, 0, icon, 0);
			}
		}
		
		blockCon = Block.blocksList[world.getBlockId(x - 1, y, z)];
		if(blockCon instanceof IRTEnergy){
			boolean b = ((IRTEnergy) blockCon).canConnectTo(block, ForgeDirection.EAST);
			if(b){
				connected = true;
				connects++;
				EasyTess.renderCube(x, y, z + Pix.SEVEN, 7, 1, 2, 0, 0, icon, 0);
			}
		}
		
		blockCon = Block.blocksList[world.getBlockId(x, y, z + 1)];
		if(blockCon instanceof IRTEnergy){
			boolean b = ((IRTEnergy) blockCon).canConnectTo(block, ForgeDirection.NORTH);
			if(b){
				connected = true;
				connects++;
				EasyTess.renderCube(x + Pix.SEVEN, y, z + Pix.NINE, 2, 1, 7, 0, 0, icon, 0);
			}
		}
		
		blockCon = Block.blocksList[world.getBlockId(x, y, z - 1)];
		if(blockCon instanceof IRTEnergy){
			boolean b = ((IRTEnergy) blockCon).canConnectTo(block, ForgeDirection.NORTH);
			if(b){
				connected = true;
				connects++;
				EasyTess.renderCube(x + Pix.SEVEN, y, z, 2, 1, 7, 0, 0, icon, 0);
			}
		}
		
		if(connected){
			EasyTess.renderCube(x + Pix.SEVEN, y, z + Pix.SEVEN, 2, 1, 2, 0, 0, icon, 0);
		}else{
			EasyTess.renderCube(x, y, z + Pix.SEVEN, 16, 1, 2, 0, 0, icon, 0);
			EasyTess.renderCube(x + Pix.SEVEN, y, z, 2, 1, 16, 0, 0, icon, 0);
		}
		
		TileCableBlock te = (TileCableBlock)world.getBlockTileEntity(x, y, z);
		te.setIsJunciton(connects > 2);

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.cableType;
	}

}

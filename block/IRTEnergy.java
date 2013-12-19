package realtech.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.ForgeDirection;

public interface IRTEnergy {
	public boolean canConnectTo(Block block, ForgeDirection side);
}

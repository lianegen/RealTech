package realtech.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileCableBlock extends TileEntity implements IRTEnergyTile {
	
	private float resistance = 0.0169e-6F;
	private float current;
	private boolean isJunciton = false;
	
	public void readFromNBT(NBTTagCompound NBT)
    {
		super.readFromNBT(NBT);
		this.resistance = NBT.getFloat("resistance");
		this.current = NBT.getFloat("current");
    }
	
	public void writeToNBT(NBTTagCompound NBT){
		super.writeToNBT(NBT);
		NBT.setFloat("resistance", resistance);
		NBT.setFloat("current", current);
	}

	@Override
	public float getCurrent() {
		return this.current;
	}

	@Override
	public float getResistance() {
		return this.resistance;
	}

	@Override
	public void addResistance(float res) {
		this.resistance += res;
	}

	@Override
	public void calculateCurrent(float voltage) {
		current = voltage / this.resistance;
	}

	@Override
	public void decreseResistance(float res) {
		this.resistance -= res;
	}
	
	public void setIsJunciton(boolean b){
		this.isJunciton = b;
	}
}

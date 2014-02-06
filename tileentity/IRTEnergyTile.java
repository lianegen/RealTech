package realtech.tileentity;

public interface IRTEnergyTile {
	public float getCurrent();
	
	public float getResistance();
	
	public void addResistance(float res);
	
	public void decreseResistance(float res);
	
	public void calculateCurrent(float voltage);
}

package realtech.generator;

import java.util.Random;

import realtech.Main;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }

	}

	private void generateNether(World world, Random random, int i, int j) {
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k = 0; k < 5; k++){
        	int magnetitOreXCoord = i + random.nextInt(16);
        	int magnetitOreYCoord = random.nextInt(20);
        	int magnetitOreZCoord = j + random.nextInt(16);
        	
        	(new WorldGenMinable(Main.magnetite_ore.blockID, 4)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
        }

		for(int k = 0; k < 10; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 48) + 48;
			int magnetitOreZCoord = j + random.nextInt(16);
    	
			(new WorldGenMinable(Main.tin_ore.blockID, 5)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 10; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 48) + 48;
			int magnetitOreZCoord = j + random.nextInt(16);
    	
			(new WorldGenMinable(Main.copper_ore.blockID, 5)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 5; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 32) + 32;
			int magnetitOreZCoord = j + random.nextInt(16);
    	
			(new WorldGenMinable(Main.aluminum_ore.blockID, 5)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 8; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 16) + 16;
			int magnetitOreZCoord = j + random.nextInt(16);
		
			(new WorldGenMinable(Main.bauxite_ore.blockID, 4)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 5; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 16) + 16;
			int magnetitOreZCoord = j + random.nextInt(16);
			
			(new WorldGenMinable(Main.tungsten_ore.blockID, 3)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 5; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 16) + 16;
			int magnetitOreZCoord = j + random.nextInt(16);
			
			(new WorldGenMinable(Main.zinc_ore.blockID, 3)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 5; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64 - 44) + 44;
			int magnetitOreZCoord = j + random.nextInt(16);
			
			(new WorldGenMinable(Main.lead_ore.blockID, 3)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
		
		for(int k = 0; k < 5; k++){
			int magnetitOreXCoord = i + random.nextInt(16);
			int magnetitOreYCoord = random.nextInt(64);
			int magnetitOreZCoord = j + random.nextInt(16);
			
			(new WorldGenMinable(Main.silver_ore.blockID, 3)).generate(world, random, magnetitOreXCoord, magnetitOreYCoord, magnetitOreZCoord);
		}
	}
	private void generateEnd(World world, Random random, int i, int j) {
		
	}
	
}
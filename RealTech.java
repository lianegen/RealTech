package realtech;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import realtech.block.BlockFluorescentLamp;
import realtech.block.CableBlock;
import realtech.block.CarpetBlock;
import realtech.block.ComparisonLamp;
import realtech.block.HardOreBlock;
import realtech.block.LadderBlock;
import realtech.block.MagnetiteOreBlock;
import realtech.block.ModBlock;
import realtech.block.ModBrick;
import realtech.block.NettingFence;
import realtech.block.PanesBlock;
import realtech.block.Pillar;
import realtech.block.SolidBlock;
import realtech.block.SpecialBlock;
import realtech.block.SpecialGlassBlock;
import realtech.block.SpecialWood;
import realtech.block.UnSolidBlock;
import realtech.enumtool.EnumToolMod;
import realtech.generator.OreGenerator;
import realtech.handler.SawCraftingHandler;
import realtech.item.BrassSword;
import realtech.item.ItemPillar;
import realtech.item.ModItem;
import realtech.item.ModItemSaw;
import realtech.lib.Reference;
import realtech.proxy.CommonProxy;
import realtech.tileentity.TileCableBlock;
import realtech.tileentity.TileEntityFluorescentLamp;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.modid, name = Reference.name, version = Reference.version)
@NetworkMod (clientSideRequired = true, serverSideRequired = false)
public class RealTech {
	
	@Instance(value = Reference.modid)
	public static RealTech instance;
	
	@SidedProxy(clientSide = "realtech.proxy.ClientProxy", serverSide = "realtech.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	//BLOKY
	public static Block block1;
	public static Block small_glowstone;
	public static Block windowpane;
	public static Block special_glass;
	public static Block invisible_glass1;
	public static Block invisible_glass2;
	public static Block block7;
	public static Block special_wool;
	public static Block block9;
	public static Block netting_fence;
	public static Block magnetite_ore;
	public static Block special_ladder;
	public static Block rubber_wood;
	public static Block yew_wood;
	public static Block tin_ore;
	public static Block copper_ore;
	public static Block aluminum_ore;
	public static Block bauxite_ore;
	public static Block tungsten_ore;
	public static Block zinc_ore;
	public static Block lead_ore;
	public static Block silver_ore;
	public static Block end_brick;
	public static Block mossy_end_brick;
	public static Block chiseled_end_brick;
	public static Block cracked_end_brick;
	public static Block rubber_planks;
	public static Block yew_planks;
	public static Block fluorescent_lamp;
	public static Block comparison_lamp_off;
	public static Block comparison_lamp_on;
	public static Block cable;
	public static Block glass_carpet;
	public static Block obsidian_plate;
	//ITEMY
	public static Item paintBrush;
	public static Item saw;
	public static Item roller;
	public static Item magnet;
	public static Item brush;
	public static Item magnetite_dust;
	public static Item magnet_ingot;
	public static Item steel_ingot;
	public static Item tin_ingot;
	public static Item copper_ingot;
	public static Item aluminum_ingot;
	public static Item bauxite_ingot;
	public static Item tungsten_ingot;
	public static Item brass_ingot;
	public static Item bronze_ingot;
	public static Item zinc_ingot;
	public static Item lead_ingot;
	public static Item silver_ingot;
	public static Item wheel;
	public static Item hammer;
	public static Item brass_sword;
	public static Item steel_sword;
	public static Item yew_stick;
	public static Item yew_arrow;
	//vytvareni craftingu pro vraceni itemu
	SawCraftingHandler craftingHandler = new SawCraftingHandler();
	
	@EventHandler
	public void load(FMLInitializationEvent event){
	//vytvateni noveho bloku a jeho vlastnosti
		block1 = new ModBlock(1000, Material.wood, "block1")
			.setUnlocalizedName("block1")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(25.0F)
			.setResistance(10.0F)
			.setLightValue(1.1F)
			.setStepSound(Block.soundClothFootstep);
		
		small_glowstone = new SpecialBlock(1001, Material.glass, "smallGlowstone")
			.setUnlocalizedName("smallGlowstone")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(0.3F)
			.setLightValue(0.3F)
			.setStepSound(Block.soundGlassFootstep);
			
		windowpane = new PanesBlock(1002, Material.glass, "windowpane")
			.setUnlocalizedName("windowpane")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(0.3F)
			.setStepSound(Block.soundGlassFootstep);
	
		special_glass = new SpecialGlassBlock(1003, Material.glass, "specialGlass", false)
			.setUnlocalizedName("specialGlass")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(0.5F)
			.setStepSound(Block.soundStoneFootstep);
		
		invisible_glass1 = new SolidBlock(1004, Material.glass, "invisibleGlass1")
			.setUnlocalizedName("invisibleGlass1")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(0.2F)
			.setResistance(10.0F)
			.setStepSound(Block.soundGlassFootstep);
		
		invisible_glass2 = new SolidBlock(1005, Material.glass, "invisibleGlass2")
			.setUnlocalizedName("invisibleGlass2")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(0.2F)
			.setResistance(10.0F)
			.setStepSound(Block.soundGlassFootstep);
		
		block7 = new UnSolidBlock(1006, Material.piston, "block7")
			.setUnlocalizedName("block7")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(25.0F)
			.setResistance(10.0F)
			.setLightValue(0.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		special_wool = new ModBlock(1007, Material.rock, "specialWool")
			.setUnlocalizedName("specialWool")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(25.0F)
			.setResistance(10.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		block9 = new Pillar(1008, Material.glass, "block9")
			.setUnlocalizedName("block9")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundWoodFootstep);
		
		netting_fence = new NettingFence(1014, Material.glass, "nettingFence")
			.setUnlocalizedName("nettingFence")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(5.0F)
			.setResistance(10.0F)
			.setStepSound(Block.soundMetalFootstep);
		
		magnetite_ore = new MagnetiteOreBlock(1015, Material.rock, "magnetiteOre")
			.setUnlocalizedName("magnetiteOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		special_ladder = new LadderBlock(1016, Material.glass, "specialLadder")
			.setUnlocalizedName("specialLadder")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		rubber_wood = new SpecialWood(1017, Material.wood, "rubberWood")
			.setUnlocalizedName("rubberWood")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundWoodFootstep);
		
		yew_wood = new SpecialWood(1018, Material.wood, "yewWood")
			.setUnlocalizedName("yewWood")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundWoodFootstep);
		
		tin_ore = new HardOreBlock(1019, Material.rock, "tinOre")
			.setUnlocalizedName("tinOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		copper_ore = new HardOreBlock(1020, Material.rock, "copperOre")
			.setUnlocalizedName("copperOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		aluminum_ore = new HardOreBlock(1021, Material.rock, "aluminumOre")
			.setUnlocalizedName("aluminumOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
			
		bauxite_ore = new HardOreBlock(1022, Material.rock, "bauxiteOre")
			.setUnlocalizedName("bauxiteOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		tungsten_ore = new HardOreBlock(1023, Material.rock, "tungstenOre")
			.setUnlocalizedName("tungstenOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		zinc_ore = new HardOreBlock(1024, Material.rock, "zincOre")
			.setUnlocalizedName("zincOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
			
		lead_ore = new HardOreBlock(1025, Material.rock, "leadOre")
			.setUnlocalizedName("leadOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		silver_ore = new HardOreBlock(1026, Material.rock, "silverOre")
			.setUnlocalizedName("silverOre")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		end_brick = new ModBrick(1027, Material.rock, "endBrick")
			.setUnlocalizedName("endBrick")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(15.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		mossy_end_brick = new ModBrick(1028, Material.rock, "mossyEndBrick")
			.setUnlocalizedName("mossyEndBrick")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(15.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		chiseled_end_brick = new ModBrick(1029, Material.rock, "chiseledEndBrick")
			.setUnlocalizedName("chiseledEndBrick")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(15.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		cracked_end_brick = new ModBrick(1030, Material.rock, "crackedEndBrick")
			.setUnlocalizedName("crackedEndBrick")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(3.0F)
			.setResistance(15.0F)
			.setStepSound(Block.soundStoneFootstep);

		yew_planks = new ModBlock(1031, Material.wood, "yewPlanks")
			.setUnlocalizedName("yewPlanks")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundWoodFootstep);
			
		rubber_planks = new ModBlock(1032, Material.wood, "rubberPlanks")
			.setUnlocalizedName("rubberPlanks")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundWoodFootstep);
		
		fluorescent_lamp = new BlockFluorescentLamp(1033, Material.glass, "fluorescentLamp")
			.setUnlocalizedName("fluorescentLamp")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F);
		
		comparison_lamp_off = new ComparisonLamp(1034, Material.rock, "comparisonLampOff", false)
			.setUnlocalizedName("comparisonLampOff")
			.setCreativeTab(CreativeTabs.tabRedstone)
			.setHardness(25.0F)
			.setResistance(10.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		comparison_lamp_on = new ComparisonLamp(1035, Material.rock, "comparisonLampOn", true)
			.setHardness(25.0F)
			.setResistance(10.0F)
			.setStepSound(Block.soundStoneFootstep);
		
		cable = new CableBlock(1036, Material.glass, "cable")
			.setUnlocalizedName("cable")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F);
		
		glass_carpet = new CarpetBlock(1037, Material.glass, "glassCarpet")
			.setUnlocalizedName("glassCarpet")
			.setCreativeTab(CreativeTabs.tabBlock)
			.setHardness(2.0F)
			.setResistance(5.0F)
			.setStepSound(Block.soundGlassFootstep);
		
		//vytvareni novych itemu a jejich vlastnosti
		paintBrush = new ModItem(1100, "paintBrush")
			.setUnlocalizedName("paintBrush")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(1);
		
		saw = new ModItemSaw(1101, "saw")
			.setUnlocalizedName("saw")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(1)
			.setContainerItem(saw);
		
		roller = new ModItem(1102, "roller")
			.setUnlocalizedName("roller")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(64);
		
		magnet = new ModItem(1103, "magnet")
			.setUnlocalizedName("magnet")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(1);
			
		brush = new ModItem(1104, "brush")
			.setUnlocalizedName("brush")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(1);
		
		magnetite_dust = new ModItem(1105, "magnetiteDust")
			.setUnlocalizedName("magnetiteDust")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(64);
		
		magnet_ingot = new ModItem(1106, "magnetIngot")
			.setUnlocalizedName("magnetIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		steel_ingot = new ModItem(1107, "steelIngot")
			.setUnlocalizedName("steelIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		tin_ingot = new ModItem(1108, "tinIngot")
			.setUnlocalizedName("tinIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		copper_ingot = new ModItem(1109, "copperIngot")
			.setUnlocalizedName("copperIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		aluminum_ingot = new ModItem(1110, "aluminumIngot")
			.setUnlocalizedName("aluminumIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		bauxite_ingot = new ModItem(1111, "bauxiteIngot")
			.setUnlocalizedName("bauxiteIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		tungsten_ingot = new ModItem(1112, "tungstenIngot")
			.setUnlocalizedName("tungstenIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		brass_ingot = new ModItem(1113, "brassIngot")
			.setUnlocalizedName("brassIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
			
		bronze_ingot = new ModItem(1114, "bronzeIngot")
			.setUnlocalizedName("bronzeIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		zinc_ingot = new ModItem(1115, "zincIngot")
			.setUnlocalizedName("zincIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		lead_ingot = new ModItem(1116, "leadIngot")
			.setUnlocalizedName("leadIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		silver_ingot = new ModItem(1117, "silverIngot")
			.setUnlocalizedName("silverIngot")
			.setCreativeTab(CreativeTabs.tabMaterials)
			.setMaxStackSize(64);
		
		wheel = new ModItem(1118, "wheel")
			.setUnlocalizedName("wheel")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(64);
			
		hammer = new ModItem(1119, "hammer")
			.setUnlocalizedName("hammer")
			.setCreativeTab(CreativeTabs.tabMisc)
			.setMaxStackSize(1);

		brass_sword = new BrassSword(1120, EnumToolMod.BRASS, "brassSword")
			.setUnlocalizedName("brassSword")
			.setCreativeTab(CreativeTabs.tabCombat)
			.setMaxStackSize(1);
		
		steel_sword = new BrassSword(1121, EnumToolMod.STEEL, "steelSword")
			.setUnlocalizedName("steelSword")
			.setCreativeTab(CreativeTabs.tabCombat)
			.setMaxStackSize(1);
		
		yew_stick = new ModItem(1122, "yewStick")
			.setUnlocalizedName("yewStick")
			.setCreativeTab(CreativeTabs.tabCombat)
			.setMaxStackSize(64);
		
		yew_arrow = new ModItem(1123, "yewArrow")
			.setUnlocalizedName("yewArrow")
			.setCreativeTab(CreativeTabs.tabCombat)
			.setMaxStackSize(64);
	//crafting recepty (neni urceno kde presne budou itemi v craftingu)
		//itemi
		GameRegistry.addShapelessRecipe(new ItemStack(roller, 4), new Object[]{
			new ItemStack(Block.cloth, 1), new ItemStack(Item.stick, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(brass_ingot, 5), new Object[]{
			new ItemStack(copper_ingot, 1),
			new ItemStack(copper_ingot, 1),
			new ItemStack(copper_ingot, 1),
			new ItemStack(zinc_ingot, 1),
			new ItemStack(zinc_ingot, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(bronze_ingot, 4), new Object[]{
			new ItemStack(copper_ingot, 1),
			new ItemStack(copper_ingot, 1),
			new ItemStack(copper_ingot, 1),
			new ItemStack(aluminum_ingot, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.stick, 4), new Object[]{
			new ItemStack(rubber_planks, 1),
			new ItemStack(rubber_planks, 1),
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(yew_stick, 4), new Object[]{
			new ItemStack(yew_planks, 1),
			new ItemStack(yew_planks, 1),
		});
		
		//blocky
		GameRegistry.addShapelessRecipe(new ItemStack(small_glowstone,1), new Object[]{
			new ItemStack(Item.glowstone, 1)
		});

		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,0), new Object[]{
			new ItemStack(Block.wood, 4, 0), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,1), new Object[]{
			new ItemStack(Block.wood, 4, 1), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,2), new Object[]{
			new ItemStack(Block.wood, 4, 2), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,3), new Object[]{
			new ItemStack(Block.wood, 4, 3), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,4), new Object[]{
			new ItemStack(rubber_wood, 4), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(block9,4,5), new Object[]{
			new ItemStack(yew_wood, 4), new ItemStack(saw, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks,1,0), new Object[]{
			new ItemStack(block9, 1, 0)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks,1,1), new Object[]{
			new ItemStack(block9, 1, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks,1,2), new Object[]{
			new ItemStack(block9, 1, 2)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.planks,1,3), new Object[]{
			new ItemStack(block9, 1, 3)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(rubber_planks), new Object[]{
			new ItemStack(block9, 1, 4)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(yew_planks), new Object[]{
			new ItemStack(block9, 1, 5)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(rubber_planks,4), new Object[]{
			new ItemStack(rubber_wood, 1)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(yew_planks,4), new Object[]{
			new ItemStack(yew_wood, 1)
		});
	//crafting recepty (maji urceno kde presne budou itemi/bloky v craftingu)
		//itemi
		GameRegistry.addShapedRecipe(new ItemStack(saw,1), new Object[]{
			"CCA",
			"BBA",
			"   ",
			'A', new ItemStack(roller,1),
			'B', new ItemStack(Item.ingotIron,1),
			'C', new ItemStack(Item.stick,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(paintBrush,1), new Object[]{
			"AAB",
			" BB",
			" A ",
			'A', new ItemStack(roller,1),
			'B', new ItemStack(Item.stick,1)
		});

		GameRegistry.addShapedRecipe(new ItemStack(magnet,1), new Object[]{
			"A A",
			"B B",
			" B ",
			'A', new ItemStack(magnet_ingot,1),
			'B', new ItemStack(Item.ingotIron,1)
		});

		GameRegistry.addShapedRecipe(new ItemStack(brush,1), new Object[]{
			"A  ",
			" B ",
			"  C",
			'A', new ItemStack(Block.cloth,1),
			'B', new ItemStack(roller,1),
			'C', new ItemStack(Item.stick,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(hammer,1), new Object[]{
			"AA ",
			"ABA",
			" B ",
			'A', new ItemStack(steel_ingot,1),
			'B', new ItemStack(Item.stick,1)
		});

		GameRegistry.addShapedRecipe(new ItemStack(brass_sword,8), new Object[]{
			" A ",
			" A ",
			" B ",
			'A', new ItemStack(brass_ingot,1),
			'B', new ItemStack(Item.stick,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(steel_sword,1), new Object[]{
			" A ",
			" A ",
			" B ",
			'A', new ItemStack(steel_ingot,1),
			'B', new ItemStack(Item.stick,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(wheel,1), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(Block.planks,1),
			'B', new ItemStack(Item.ingotIron,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(yew_arrow,4), new Object[]{
			" C ",
			" B ",
			" A ",
			'A', new ItemStack(Item.feather,1),
			'B', new ItemStack(yew_stick,1),
			'C', new ItemStack(Item.flint,1)
			});
		//blocky
		GameRegistry.addShapedRecipe(new ItemStack(special_wool,8), new Object[]{
			"ABA",
			"BCB",
			"ABA",
			'A', new ItemStack(Block.cloth,1,14),
			'B', new ItemStack(Block.cloth,1,15),
			'C', new ItemStack(Block.cloth,1,4)
		});
			
		GameRegistry.addShapedRecipe(new ItemStack(netting_fence,16), new Object[]{
			"A A",
			" A ",
			"A A",
			'A', new ItemStack(Item.ingotIron,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Block.stoneBrick,8,3), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(Block.stoneBrick,1),
			'B', new ItemStack(Block.stone,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Block.stoneBrick,8,2), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(Block.stoneBrick,1),
			'B', new ItemStack(Item.flint,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Block.stoneBrick,8,1), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(Block.stoneBrick,1),
			'B', new ItemStack(Block.vine,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Block.cobblestoneMossy,8,2), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(Block.cobblestone,1),
			'B', new ItemStack(Block.vine,1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(end_brick,4), new Object[]{
			"AA ",
			"AA ",
			"   ",
			'A', new ItemStack(Block.whiteStone,1)});
		GameRegistry.addShapedRecipe(new ItemStack(end_brick,4), new Object[]{
			"   ",
			" AA",
			" AA",
			'A', new ItemStack(Block.whiteStone,1)});
		GameRegistry.addShapedRecipe(new ItemStack(end_brick,4), new Object[]{
			"   ",
			"AA ",
			"AA ",
			'A', new ItemStack(Block.whiteStone,1)});
		GameRegistry.addShapedRecipe(new ItemStack(end_brick,4), new Object[]{
			" AA",
			" AA",
			"   ",
			'A', new ItemStack(Block.whiteStone,1)});
		
		GameRegistry.addShapedRecipe(new ItemStack(mossy_end_brick,8), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(end_brick,1),
			'B', new ItemStack(Block.vine,1)
			});
		
		GameRegistry.addShapedRecipe(new ItemStack(chiseled_end_brick,8), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(end_brick,1),
			'B', new ItemStack(Block.whiteStone,1)
			});
		
		GameRegistry.addShapedRecipe(new ItemStack(cracked_end_brick,8), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', new ItemStack(end_brick,1),
			'B', new ItemStack(Item.flint,1)
			});
		
		GameRegistry.addShapedRecipe(new ItemStack(special_ladder,8), new Object[]{
			"ABA",
			"ABA",
			"ABA",
			'A', new ItemStack(Item.silk,1),
			'B', new ItemStack(Item.stick,1)
			});
		
		GameRegistry.addShapedRecipe(new ItemStack(windowpane,8), new Object[]{
			"   ",
			" A ",
			" B ",
			'A', new ItemStack(saw,1),
			'B', new ItemStack(Block.glass,1)
			});
		
		GameRegistry.addShapedRecipe(new ItemStack(glass_carpet,4), new Object[]{
			"   ",
			"   ",
			"AA ",
			'A', new ItemStack(Block.glass,1)
			});
		
		//specialni krafteni
		GameRegistry.registerCraftingHandler(craftingHandler);
		
	//vypekani ve furnace
		FurnaceRecipes.smelting().addSmelting(magnetite_dust.itemID,new ItemStack(magnet_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(tin_ore.blockID,new ItemStack(tin_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(copper_ore.blockID,new ItemStack(copper_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(aluminum_ore.blockID,new ItemStack(aluminum_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(bauxite_ore.blockID,new ItemStack(bauxite_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(tungsten_ore.blockID,new ItemStack(tungsten_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(zinc_ore.blockID,new ItemStack(zinc_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(lead_ore.blockID,new ItemStack(lead_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(silver_ore.blockID,new ItemStack(silver_ingot,1),0.3F);
		FurnaceRecipes.smelting().addSmelting(Item.ingotIron.itemID,new ItemStack(steel_ingot,1),0.3F);
		
	//tool effectivity // 0 = dreveny / 1 = kameny / 2 = iron / 3 = diamond
		MinecraftForge.setBlockHarvestLevel(magnetite_ore, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tin_ore, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(copper_ore, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(aluminum_ore, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(bauxite_ore, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(tungsten_ore, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(zinc_ore, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(lead_ore, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(silver_ore, "pickaxe", 3);
		
	//vlozeni do generace sveta
		GameRegistry.registerWorldGenerator(new OreGenerator());
		
	//prirazeni jmena itemu
		LanguageRegistry.addName(paintBrush, "Paint brush");
		LanguageRegistry.addName(saw, "Saw");
		LanguageRegistry.addName(roller, "Roller");
		LanguageRegistry.addName(magnet, "Magnet");
		LanguageRegistry.addName(brush, "Brush");
		LanguageRegistry.addName(magnetite_dust, "Magnetite dust");
		LanguageRegistry.addName(magnet_ingot, "Magnet ingot");
		LanguageRegistry.addName(steel_ingot, "Steel ingot");
		LanguageRegistry.addName(tin_ingot, "Tin ingot");
		LanguageRegistry.addName(copper_ingot, "Copper ingot");
		LanguageRegistry.addName(aluminum_ingot, "Aluminum ingot");
		LanguageRegistry.addName(bauxite_ingot, "Bauxite ingot");
		LanguageRegistry.addName(tungsten_ingot,"Tungsten ingot");
		LanguageRegistry.addName(brass_ingot,"Brass ingot");
		LanguageRegistry.addName(bronze_ingot,"Bronze ingot");
		LanguageRegistry.addName(zinc_ingot,"Zinc ingot");
		LanguageRegistry.addName(lead_ingot,"Lead ingot");
		LanguageRegistry.addName(silver_ingot,"Silver ingot");
		LanguageRegistry.addName(wheel,"Wheel");
		LanguageRegistry.addName(hammer,"Hammer");
		LanguageRegistry.addName(brass_sword,"Brass sword");
		LanguageRegistry.addName(steel_sword,"Steel sword");
		LanguageRegistry.addName(yew_stick,"Yew stick");
		LanguageRegistry.addName(yew_arrow,"Yew arrow");
	//registrace bloku do hry
		GameRegistry.registerBlock(block1, "block1");
		GameRegistry.registerBlock(small_glowstone, "smallGlowstone");
		GameRegistry.registerBlock(windowpane, "windowpane");
		GameRegistry.registerBlock(special_glass, "specialGlass");
		GameRegistry.registerBlock(invisible_glass1, "invisibleGlass1");
		GameRegistry.registerBlock(invisible_glass2, "invisibleGlass2");
		GameRegistry.registerBlock(block7, "block7");
		GameRegistry.registerBlock(special_wool, "specialWool");
		GameRegistry.registerBlock(block9, ItemPillar.class, "testing" + (block9.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(netting_fence, "nettingFence");
		GameRegistry.registerBlock(magnetite_ore, "magnetiteOre");
		GameRegistry.registerBlock(special_ladder, "specialLadder");
		GameRegistry.registerBlock(rubber_wood, "rubberWood");
		GameRegistry.registerBlock(yew_wood, "yewWood");
		GameRegistry.registerBlock(tin_ore, "tinOre");
		GameRegistry.registerBlock(copper_ore, "copperOre");
		GameRegistry.registerBlock(aluminum_ore, "aluminumOre");
		GameRegistry.registerBlock(bauxite_ore, "bauxiteOre");
		GameRegistry.registerBlock(tungsten_ore, "tungstenOre");
		GameRegistry.registerBlock(zinc_ore, "zincOre");
		GameRegistry.registerBlock(lead_ore, "leadOre");
		GameRegistry.registerBlock(silver_ore, "silverOre");
		GameRegistry.registerBlock(end_brick, "endBrick");
		GameRegistry.registerBlock(mossy_end_brick, "mossyEndBrick");
		GameRegistry.registerBlock(chiseled_end_brick, "chiseledEndBrick");
		GameRegistry.registerBlock(cracked_end_brick, "crackedEndBrick");
		GameRegistry.registerBlock(rubber_planks, "rubberPlanks");
		GameRegistry.registerBlock(yew_planks, "yewPlanks");
		GameRegistry.registerBlock(fluorescent_lamp, "fluorescentLamp");
		GameRegistry.registerBlock(comparison_lamp_off, "comparisonLampOff");
		GameRegistry.registerBlock(cable, "cable");
		GameRegistry.registerBlock(glass_carpet, "Glass carpet");
	//registrace tileentity
		GameRegistry.registerTileEntity(TileEntityFluorescentLamp.class, "TileFluorescentLamp");
		GameRegistry.registerTileEntity(TileCableBlock.class, "TileCable");
	//prirazeni jmena bloku
		LanguageRegistry.addName(block1, "block1");
		LanguageRegistry.addName(small_glowstone, "Small glowstone");
		LanguageRegistry.addName(windowpane, "Windowpane");
		LanguageRegistry.addName(special_glass, "Special glass");
		LanguageRegistry.addName(invisible_glass1, "invisible glass1");
		LanguageRegistry.addName(invisible_glass2, "invisible glass2");
		LanguageRegistry.addName(block7, "test block7");
		LanguageRegistry.addName(special_wool, "Special wool");
		LanguageRegistry.addName(new ItemStack(block9,1,0), "Oak wood");
		LanguageRegistry.addName(new ItemStack(block9,1,1), "Spruce wood");
		LanguageRegistry.addName(new ItemStack(block9,1,2), "Birch wood");
		LanguageRegistry.addName(new ItemStack(block9,1,3), "Jungle wood");
		LanguageRegistry.addName(new ItemStack(block9,1,4), "Rubber wood");
		LanguageRegistry.addName(new ItemStack(block9,1,5), "Yew wood");
		LanguageRegistry.addName(netting_fence, "Netting fence");
		LanguageRegistry.addName(magnetite_ore, "Magnetite ore");
		LanguageRegistry.addName(special_ladder, "Special ladder");
		LanguageRegistry.addName(rubber_wood, "Rubber wood");
		LanguageRegistry.addName(yew_wood, "Yew wood");
		LanguageRegistry.addName(tin_ore, "Tin ore");
		LanguageRegistry.addName(copper_ore, "Copper ore");
		LanguageRegistry.addName(aluminum_ore, "Aluminum ore");
		LanguageRegistry.addName(bauxite_ore, "Bauxite ore");
		LanguageRegistry.addName(tungsten_ore, "Tungsten ore");
		LanguageRegistry.addName(zinc_ore, "Zinc ore");
		LanguageRegistry.addName(lead_ore, "Lead ore");
		LanguageRegistry.addName(silver_ore, "Silver ore");
		LanguageRegistry.addName(end_brick, "End brick");
		LanguageRegistry.addName(mossy_end_brick, "Mossy end brick");
		LanguageRegistry.addName(chiseled_end_brick, "Chiseled end brick");
		LanguageRegistry.addName(cracked_end_brick, "Cracked end brick");
		LanguageRegistry.addName(rubber_planks, "Rubber planks");
		LanguageRegistry.addName(yew_planks, "Yew planks");
		LanguageRegistry.addName(fluorescent_lamp, "Fluorescent lamp");
		LanguageRegistry.addName(comparison_lamp_off, "Comparison lamp");
		LanguageRegistry.addName(cable, "Cable");
		LanguageRegistry.addName(glass_carpet, "Glass carpet");
	}		
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		proxy.registerRenderers();
	}
}
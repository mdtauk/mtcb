package net.minetrek.mdta.mtcb.init;



import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.objects.blocks.BlockBase;
import net.minetrek.mdta.mtcb.objects.blocks.BlockDiagonalLeft;
import net.minetrek.mdta.mtcb.objects.blocks.BlockFacing;
import net.minetrek.mdta.mtcb.objects.blocks.BlockObj;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTNGCore;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekCarpet;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekDoor;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekDoor2;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekFabric;



/*
 * List of All Blocks to be instantiated and then added to the registration list
 */
public class InitBlocks
{
	public static final List<Block> ALL_BLOCKS = new ArrayList<Block>();

	/*
	 * 
	 * Blocks should be added in this order: BOTTOM | MIDDLE | TOP
	 * 
	 */
	public static final Block BLOCK_tmp_CORE_A = new BlockTNGCore("block_tng_core_a", Material.IRON, Main.TAB_TNG);
	public static final Block BLOCK_tmp_CORE_B = new BlockTNGCore("block_tng_core_b", Material.IRON, Main.TAB_TNG);
	public static final Block BLOCK_TNG_CORE_C = new BlockObj("block_tng_core_c", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	/*
	 * Carpet Flat Blocks
	 */
	public static final Block BLOCK_CARPET_TEAL = new BlockTrekCarpet("block_trek_carpet_teal", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_TAN = new BlockTrekCarpet("block_trek_carpet_tan", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_DEEP_RED = new BlockTrekCarpet("block_trek_carpet_deep_red", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_DARK_GREY = new BlockTrekCarpet("block_trek_carpet_dark_grey", Main.TAB_MISC);
	//
	/*
	 * Carpet Corner Blocks
	 */
	public static final Block BLOCK_CARPET_CORNER_TEAL = new BlockTrekCarpet("block_trek_carpet_corner_teal", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_CORNER_TAN = new BlockTrekCarpet("block_trek_carpet_corner_tan", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_CORNER_DEEP_RED = new BlockTrekCarpet("block_trek_carpet_corner_deep_red", Main.TAB_MISC);
	public static final Block BLOCK_CARPET_CORNER_DARK_GREY = new BlockTrekCarpet("block_trek_carpet_corner_dark_grey", Main.TAB_MISC);
	//
	/*
	 * Carpet Full Blocks
	 */
	public static final Block BLOCK_FABRIC_TEAL = new BlockTrekFabric("block_fabric_teal", Main.TAB_MISC);
	public static final Block BLOCK_FABRIC_TAN = new BlockTrekFabric("block_fabric_tan", Main.TAB_MISC);
	public static final Block BLOCK_FABRIC_DEEP_RED = new BlockTrekFabric("block_fabric_deep_red", Main.TAB_MISC);
	public static final Block BLOCK_FABRIC_DARK_GREY = new BlockTrekFabric("block_fabric_dark_grey", Main.TAB_MISC);
	//
	


	// T N G B L O C K S
	//
	public static final Block DOOR_TNG_ORANGE = new BlockTrekDoor("door_tng_orange", Material.WOOD, Main.TAB_TNG);
	public static final Block DOOR_TNG_GREY = new BlockTrekDoor2("door_tng_grey", Material.WOOD, Main.TAB_TNG, null);
	/*
	 * FILLER WALL BLOCKS
	 */
	public static final Block BLOCK_TNG_TAN = new BlockBase("block_tng_tan", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_SILVER = new BlockBase("block_tng_silver", Material.IRON, Main.TAB_TNG, 1.0f, 8,
			SoundType.METAL);
	public static final Block BLOCK_TNG_PALE = new BlockBase("block_tng_pale", Material.IRON, Main.TAB_TNG, 1.0f, 8,
			SoundType.METAL);
	//	
	/*
	 * PALE ROOM
	 * 
	 */
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_FLUSH = new BlockBase("block_tng_room_pale_btm_flush",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_FLUSH = new BlockBase("block_tng_room_pale_middle_flush",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_FLUSH = new BlockBase("block_tng_room_pale_top_flush",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_LEFT_BRACE = new BlockFacing("block_tng_room_pale_btm_left_brace",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_LEFT_BRACE = new BlockFacing(
			"block_tng_room_pale_middle_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_LEFT_BRACE = new BlockFacing("block_tng_room_pale_top_left_brace",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_RIGHT_BRACE = new BlockFacing(
			"block_tng_room_pale_btm_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_RIGHT_BRACE = new BlockFacing(
			"block_tng_room_pale_middle_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_RIGHT_BRACE = new BlockFacing(
			"block_tng_room_pale_top_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_SPLIT = new BlockFacing("block_tng_room_pale_btm_split",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_SPLIT = new BlockFacing("block_tng_room_pale_middle_split",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_SPLIT = new BlockFacing("block_tng_room_pale_top_split",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	// DIAGONAL BLOCKS
	//
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_btm_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_middle_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_top_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_ROOM_PALE_BTM_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_btm_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);	
	public static final Block BLOCK_TNG_ROOM_PALE_MIDDLE_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_middle_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);	
	public static final Block BLOCK_TNG_ROOM_PALE_TOP_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_room_pale_top_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);	
	//
	/*
	 * CORRIDOR ANGLED
	 * 
	 */
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM = new BlockObj(
			"block_tng_corridor_angled_cargo_btm", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_LEFT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_RIGHT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_SPLIT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_ALERT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_LEFT_ALERT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_left_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_RIGHT_ALERT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_right_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_CARGO_BTM_SPLIT_ALERT = new BlockObj(
			"block_tng_corridor_angled_cargo_btm_split_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_BTM = new BlockObj(
			"block_tng_corridor_angled_btm", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE = new BlockObj(
			"block_tng_corridor_angled_middle", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_TOP = new BlockObj(
			"block_tng_corridor_angled_top", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_BTM_LEFT = new BlockObj(
			"block_tng_corridor_angled_btm_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_BTM_RIGHT = new BlockObj(
			"block_tng_corridor_angled_btm_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_BTM_SPLIT = new BlockObj(
			"block_tng_corridor_angled_btm_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_LEFT = new BlockObj(
			"block_tng_corridor_angled_middle_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_RIGHT = new BlockObj(
			"block_tng_corridor_angled_middle_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_SPLIT = new BlockObj(
			"block_tng_corridor_angled_middle_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_ALERT = new BlockObj(
			"block_tng_corridor_angled_middle_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_LEFT_ALERT = new BlockObj(
			"block_tng_corridor_angled_middle_left_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_RIGHT_ALERT = new BlockObj(
			"block_tng_corridor_angled_middle_right_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_MIDDLE_SPLIT_ALERT = new BlockObj(
			"block_tng_corridor_angled_middle_split_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_TOP_LEFT = new BlockObj(
			"block_tng_corridor_angled_top_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_TOP_RIGHT = new BlockObj(
			"block_tng_corridor_angled_top_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_TOP_SPLIT = new BlockObj(
			"block_tng_corridor_angled_top_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	/*
	 * CORRIDOR ANGLED DIAGONAL
	 * 
	 */
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_BTM = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_btm", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_MIDDLE = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_middle", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_MIDDLE_ALERT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_middle_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_TOP = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_top", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_BTM_SPLIT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_btm_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_MIDDLE_SPLIT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_middle_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_MIDDLE_SPLIT_ALERT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_middle_split_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_A_TOP_SPLIT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_a_top_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_B_BTM = new BlockDiagonalLeft("block_tng_corridor_angled_diag_b_btm", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_B_MIDDLE = new BlockDiagonalLeft("block_tng_corridor_angled_diag_b_middle", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_B_MIDDLE_ALERT = new BlockDiagonalLeft("block_tng_corridor_angled_diag_b_middle_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_ANGLED_DIAG_B_TOP = new BlockDiagonalLeft("block_tng_corridor_angled_diag_b_top", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	/*
	 * CORRIDOR WITH SCREEN
	 * 
	 * Vertical placement - Top, Middle, Bottom | Brace placement - Left, Split,
	 * Right | No brace - Flush
	 * Alert is an animated Red Alert light. Alt0 and Alt1 are flush with LCARS
	 * displays
	 * 
	 */
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_btm_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_middle_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_LEFT_BRACE_ALERT = new BlockFacing(
			"block_tng_corridor_screen_middle_left_brace_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_top_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_FLUSH = new BlockFacing(
			"block_tng_corridor_screen_btm_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_FLUSH = new BlockFacing(
			"block_tng_corridor_screen_middle_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_FLUSH_ALERT = new BlockFacing(
			"block_tng_corridor_screen_middle_flush_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_FLUSH_ALT0 = new BlockFacing(
			"block_tng_corridor_screen_middle_flush_alt0", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_FLUSH_ALT1 = new BlockFacing(
			"block_tng_corridor_screen_middle_flush_alt1", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_FLUSH = new BlockFacing(
			"block_tng_corridor_screen_top_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_SPLIT = new BlockFacing(
			"block_tng_corridor_screen_btm_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_SPLIT = new BlockFacing(
			"block_tng_corridor_screen_middle_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_SPLIT_ALERT = new BlockFacing(
			"block_tng_corridor_screen_middle_split_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_SPLIT = new BlockFacing(
			"block_tng_corridor_screen_top_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_btm_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_middle_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_RIGHT_BRACE_ALERT = new BlockFacing(
			"block_tng_corridor_screen_middle_right_brace_alert", Material.IRON, Main.TAB_TNG, 1.0f, 0,
			SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_screen_top_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	// DIAGONAL BLOCKS
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_btm_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_middle_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_ALERT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_middle_alert_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_top_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_BTM_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_btm_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_middle_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_MIDDLE_SPLIT_ALERT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_middle_split_alert_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_SCREEN_TOP_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_screen_top_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);	
	//
	/*
	 * CORRIDOR FABRIC WITH SCREEN
	 * 
	 * Vertical placement - Top, Middle, Bottom | Brace placement - Left, Split,
	 * Right | No brace - Flush
	 * 
	 */
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_BTM_LEFT = new BlockFacing(
			"block_tng_corridor_fabric_screen_btm_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_MIDDLE_LEFT = new BlockFacing(
			"block_tng_corridor_fabric_screen_middle_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_FLAT_MIDDLE_LEFT = new BlockFacing(
			"block_tng_corridor_fabric_screen_flat_middle_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_TOP_LEFT = new BlockFacing(
			"block_tng_corridor_fabric_screen_top_left", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_BTM_FLUSH = new BlockFacing(
			"block_tng_corridor_fabric_screen_btm_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_MIDDLE_FLUSH = new BlockFacing(
			"block_tng_corridor_fabric_screen_middle_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_FLAT_MIDDLE_FLUSH = new BlockFacing(
			"block_tng_corridor_fabric_screen_flat_middle_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_TOP_FLUSH = new BlockFacing(
			"block_tng_corridor_fabric_screen_top_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_BTM_RIGHT = new BlockFacing(
			"block_tng_corridor_fabric_screen_btm_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_MIDDLE_RIGHT = new BlockFacing(
			"block_tng_corridor_fabric_screen_middle_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_FLAT_MIDDLE_RIGHT = new BlockFacing(
			"block_tng_corridor_fabric_screen_flat_middle_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_FABRIC_SCREEN_TOP_RIGHT = new BlockFacing(
			"block_tng_corridor_fabric_screen_top_right", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	/*
	 * CORRIDOR WITH BULKHEADS
	 * 
	 * Vertical placement - Top, Middle, Bottom | Brace placement - Left, Split,
	 * Right | No brace - Flush
	 * 
	 */
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_btm_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_middle_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_LEFT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_top_left_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_FLUSH = new BlockFacing("block_tng_corridor_bulk_btm_flush",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_FLUSH = new BlockFacing(
			"block_tng_corridor_bulk_middle_flush", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_FLUSH = new BlockFacing("block_tng_corridor_bulk_top_flush",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_SPLIT = new BlockFacing("block_tng_corridor_bulk_btm_split",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_SPLIT_ALT = new BlockFacing(
			"block_tng_corridor_bulk_btm_split_alt", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_SPLIT = new BlockFacing(
			"block_tng_corridor_bulk_middle_split", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_SPLIT_ALT = new BlockFacing(
			"block_tng_corridor_bulk_middle_split_alt", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_SPLIT = new BlockFacing("block_tng_corridor_bulk_top_split",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_btm_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_RIGHT_BRACE_ALT = new BlockFacing(
			"block_tng_corridor_bulk_btm_right_brace_alt", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_middle_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_RIGHT_BRACE_ALT = new BlockFacing(
			"block_tng_corridor_bulk_middle_right_brace_alt", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_RIGHT_BRACE = new BlockFacing(
			"block_tng_corridor_bulk_top_right_brace", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	// DIAGONAL BLOCKS
		public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_btm_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
		public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_middle_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
		public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_top_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
		//
		public static final Block BLOCK_TNG_CORRIDOR_BULK_BTM_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_btm_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
		public static final Block BLOCK_TNG_CORRIDOR_BULK_MIDDLE_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_middle_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
		public static final Block BLOCK_TNG_CORRIDOR_BULK_TOP_SPLIT_DIAG_LEFT = new BlockDiagonalLeft("block_tng_corridor_bulk_top_split_diag", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	/*
	 * CORRIDOR DOORWAYS
	 * [_][_][_]
	 * Placement is in this pattern: [_] [_]
	 * [_] [_]
	 */
	public static final Block BLOCK_TNG_DOORWAY_TAN_BTM_LEFT = new BlockFacing("block_tng_doorway_tan_btm_left",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_BTM_LEFT_JT = new BlockFacing("block_tng_doorway_tan_btm_left_jt",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_MIDDLE_LEFT = new BlockFacing("block_tng_doorway_tan_middle_left",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_MIDDLE_LEFT_LIFT = new BlockFacing(
			"block_tng_doorway_tan_middle_left_lift", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_MIDDLE_LEFT_JT = new BlockFacing(
			"block_tng_doorway_tan_middle_left_jt", Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_TOP_LEFT = new BlockFacing("block_tng_doorway_tan_top_left",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_DOORWAY_TAN_TOP_MIDDLE = new BlockFacing("block_tng_doorway_tan_top_middle",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TNG_DOORWAY_TAN_BTM_RIGHT = new BlockFacing("block_tng_doorway_tan_btm_right",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_MIDDLE_RIGHT = new BlockFacing("block_tng_doorway_tan_middle_right",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TNG_DOORWAY_TAN_TOP_RIGHT = new BlockFacing("block_tng_doorway_tan_top_right",
			Material.IRON, Main.TAB_TNG, 1.0f, 0, SoundType.METAL);
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * MOVIES CORRIDOR ANGLED BROWN
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_brown_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_brown_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_brown_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_brown_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_brown_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_brown_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_brown_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_brown_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_brown_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_brown_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_brown_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BROWN_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_brown_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED BLUE
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_blue_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_blue_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_blue_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_blue_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_blue_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_blue_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_blue_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_blue_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_blue_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_blue_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_blue_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BLUE_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_blue_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED YELLOW
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_yellow_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_yellow_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_yellow_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_yellow_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_yellow_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_yellow_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_yellow_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_yellow_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_yellow_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_yellow_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_yellow_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_YELLOW_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_yellow_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED GREY
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_grey_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_grey_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_grey_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_grey_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_grey_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_grey_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_grey_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_grey_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_grey_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_grey_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_grey_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_GREY_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_grey_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED RED
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_red_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_red_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_red_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_red_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_red_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_red_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_red_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_red_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_red_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_red_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_red_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_RED_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_red_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED WHITE
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_white_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_white_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_white_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_white_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_white_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_white_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_white_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_white_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_white_top_flush", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_white_top_left", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_white_top_right", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_WHITE_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_white_top_split", Material.IRON, Main.TAB_MOVIES, 0.4f, 0, SoundType.METAL);
	//
	/*
	 * MOVIES CORRIDOR ANGLED
	 * 
	 */
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BTM_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_btm_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_middle_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_TOP_FLUSH = new BlockObj(
			"block_tmp_corridor_angled_top_flush", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BTM_LEFT = new BlockObj(
			"block_tmp_corridor_angled_btm_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BTM_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_btm_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_BTM_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_btm_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_LEFT = new BlockObj(
			"block_tmp_corridor_angled_middle_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_middle_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_middle_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_FLUSH_ALERT = new BlockObj(
			"block_tmp_corridor_angled_middle_flush_alert", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_LEFT_ALERT = new BlockObj(
			"block_tmp_corridor_angled_middle_left_alert", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_RIGHT_ALERT = new BlockObj(
			"block_tmp_corridor_angled_middle_right_alert", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_MIDDLE_SPLIT_ALERT = new BlockObj(
			"block_tmp_corridor_angled_middle_split_alert", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_TOP_LEFT = new BlockObj(
			"block_tmp_corridor_angled_top_left", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_TOP_RIGHT = new BlockObj(
			"block_tmp_corridor_angled_top_right", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	public static final Block BLOCK_TMP_CORRIDOR_ANGLED_TOP_SPLIT = new BlockObj(
			"block_tmp_corridor_angled_top_split", Material.IRON, Main.TAB_MOVIES, 1.0f, 0, SoundType.METAL);
	//
	//
}

package net.minetrek.mdta.mtcb.init;



import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minetrek.mdta.mtcb.Main;
import net.minetrek.mdta.mtcb.objects.blocks.BlockBase;
import net.minetrek.mdta.mtcb.objects.blocks.BlockFacing;
import net.minetrek.mdta.mtcb.objects.blocks.BlockTrekDoor;



public class InitBlocks
{
	public static final List<Block> ALL_BLOCKS = new ArrayList<Block>();

	/*
	 * 
	 * Blocks should be added in this order: BOTTOM | MIDDLE | TOP
	 * 
	 */

	// T N G B L O C K S
	//
	public static final Block DOOR_TNG_ORANGE = new BlockTrekDoor("door_tng_orange", Material.WOOD, Main.TAB_TNG);
	public static final Block DOOR_TNG_GREY = new BlockTrekDoor("door_tng_grey", Material.WOOD, Main.TAB_TNG);
	/*
	 * FILLER HULL BLOCKS
	 */
	public static final Block BLOCK_TNG_TAN = new BlockBase("block_tng_tan", Material.IRON, Main.TAB_TNG, 0f, 8,
			SoundType.METAL);
	public static final Block BLOCK_TNG_SILVER = new BlockBase("block_tng_silver", Material.IRON, Main.TAB_TNG, 0f, 8,
			SoundType.METAL);
	public static final Block BLOCK_TNG_PALE = new BlockBase("block_tng_pale", Material.IRON, Main.TAB_TNG, 0f, 8,
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
	//

}

package minecraftbyexample.mbe13_item_tools;

import minecraftbyexample.usefultools.MethodCallLogger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * User: The Grey Ghost
 * Date: 24/12/2014
 *
 * BlockToolTest is a simple block used to test the interactions between tools and blocks
 * For background information see here
 */
public class BlockToolTest extends Block
{
  public BlockToolTest(Material i_material)
  {
    super(i_material);
    this.setCreativeTab(CreativeTabs.tabBlock);   // the block will appear on the Blocks tab in creative
  }

  @Override
  public int getHarvestLevel(IBlockState state) {
    int result = super.getHarvestLevel(state);
    if (MethodCallLogger.shouldLog("Block.getHarvestLevel")) {
      System.out.println("#BlockToolTest.getHarvestLevel(" + state + "), result = " + result);
    }
    return result;

  }

  @Override
  public String getHarvestTool(IBlockState state) {
    String result = super.getHarvestTool(state);
    if (MethodCallLogger.shouldLog("Block.getHarvestTool")) {
      System.out.println("#BlockToolTest.getHarvestTool(" + state + "), result = " + result);
    }
    return result;
  }

  @Override
  public boolean isToolEffective(String type, IBlockState state) {
    boolean result = super.isToolEffective(type, state);
    if (MethodCallLogger.shouldLog("Block.isToolEffective")) {
      System.out.println("#BlockToolTest.isToolEffective(" + state + "), result = " + result);
    }
    return result;
  }

  @Override
  public float getBlockHardness(World worldIn, BlockPos pos) {
    float result = super.getBlockHardness(worldIn, pos);
    if (MethodCallLogger.shouldLog("Block.getBlockHardness")) {
      System.out.println("#BlockToolTest.getBlockHardness({world}, " + pos + "), result = " + result);
    }
    return result;
  }

  @Override
  public float getPlayerRelativeBlockHardness(EntityPlayer playerIn, World worldIn, BlockPos pos) {
    float result = super.getPlayerRelativeBlockHardness(playerIn, worldIn, pos);
    if (MethodCallLogger.shouldLog("Block.getPlayerRelativeBlockHardness")) {
      System.out.println("#BlockToolTest.getPlayerRelativeBlockHardness(" + playerIn.getDisplayNameString() + ", {world}, "
              + pos + "), result = " + result);
    }
    return result;
  }

  /*  Block:
  getHarvestLeve / setHarvestLevel
                   getHarvestTool
        (one tool only per metadata)
  isToolEffective
  getBlockHardness / setBlockHardness (vanilla constructors)
  Resistance is something else (explosion?)
  getPlayerRelativeBlockHardness
*/

  // the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
  @SideOnly(Side.CLIENT)
  public EnumWorldBlockLayer getBlockLayer()
  {
    return EnumWorldBlockLayer.SOLID;
  }

  // used by the renderer to control lighting and visibility of other blocks.
  // set to true because this block is opaque and occupies the entire 1x1x1 space
  // not strictly required because the default (super method) is true
  @Override
  public boolean isOpaqueCube() {
    return true;
  }

  // used by the renderer to control lighting and visibility of other blocks, also by
  // (eg) wall or fence to control whether the fence joins itself to this block
  // set to true because this block occupies the entire 1x1x1 space
  // not strictly required because the default (super method) is true
  @Override
  public boolean isFullCube() {
    return true;
  }

  // render using a BakedModel (mbe13_item_tools.json --> mbe13_item_tools_model.json)
  // not strictly required because the default (super method) is 3.
  @Override
  public int getRenderType() {
    return 3;
  }
}
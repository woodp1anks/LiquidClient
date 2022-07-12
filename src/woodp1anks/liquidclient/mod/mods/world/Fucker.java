package woodp1anks.liquidclient.mod.mods.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class Fucker extends Mod {
    private double range = 4;

    private float damage;

    public Fucker() {
        super("Fucker", Category.World);
    }

    @Override
    public void update() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;

        double minX = player.posX - range;
        double maxX = player.posX + range;
        double minY = player.posY - range;
        double maxY = player.posY + range;
        double minZ = player.posZ - range;
        double maxZ = player.posZ + range;

        boolean damaging = false;

        for (int x = (int) minX;;x++) {
            if (x > maxX) {
                break;
            }
            for (int y = (int) minY;;y++) {
                if (y > maxY) {
                    break;
                }
                for (int z = (int) minZ;;z++) {
                    if (z > maxZ) {
                        break;
                    }
                    IBlockState blockState = Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(x,y,z));
                    Block block = blockState.getBlock();
                    if (block == Blocks.bed) {
                        if (damage == 0F) {
                            Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.START_DESTROY_BLOCK,new BlockPos(x,y,z),EnumFacing.DOWN));
                            Minecraft.getMinecraft().thePlayer.swingItem();
                        }
                        Minecraft.getMinecraft().thePlayer.swingItem();
                        damage += block.getPlayerRelativeBlockHardness(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().theWorld,new BlockPos(x,y,z));
                        Minecraft.getMinecraft().theWorld.sendBlockBreakProgress(Minecraft.getMinecraft().thePlayer.getEntityId(),new BlockPos(Minecraft.getMinecraft().thePlayer.posX,Minecraft.getMinecraft().thePlayer.posY,Minecraft.getMinecraft().thePlayer.posZ), (int) (damage * 10F) - 1);
                        if (damage >= 1F) {
                            Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK,new BlockPos(x,y,z),EnumFacing.DOWN));
                            Minecraft.getMinecraft().playerController.onPlayerDestroyBlock(new BlockPos(x,y,z),EnumFacing.DOWN);
                            damage = 0;
                        }
                    }
                }
            }
        }
    }
}

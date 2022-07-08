package woodp1anks.liquidclient.mod.mods.world;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import woodp1anks.liquidclient.mod.Category;
import woodp1anks.liquidclient.mod.Mod;

public class Scaffold extends Mod {

    public Scaffold() {
        super("Scaffold", Category.World);
    }

    @Override
    public void update() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        WorldClient world = Minecraft.getMinecraft().theWorld;
        Block block = world.getBlockState(new BlockPos(player.posX,player.posY - 1,player.posZ)).getBlock();
        Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = block == Blocks.air;
    }

}

package org.bobisawesome07.aba

import carpet.patches.EntityPlayerMPFake
import net.fabricmc.api.ModInitializer
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack

class AntiBotAbuseMod : ModInitializer {

    override fun onInitialize() {

    }
    fun onInventoryUpdate(slot: Int, stack: ItemStack, player: PlayerEntity) {
        if(player is EntityPlayerMPFake && !player.world.isClient() && slot != 2 || slot != 3){
            player.dropStack(stack)
        }
    }
}

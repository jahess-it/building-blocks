package com.jahessit.minecraft.bblocks

import com.jahessit.minecraft.bblocks.common.ModInfo.MOD_ID
import com.jahessit.minecraft.bblocks.common.registry.*
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT
import me.shedaniel.architectury.platform.forge.EventBuses
import net.minecraftforge.fml.common.Mod

@Mod(MOD_ID)
class BBlocksForgeInit {
    init {
        EventBuses.registerModEventBus(MOD_ID, MOD_CONTEXT.getKEventBus())

        ItemRegistry.registerAll()
        BlockRegistry.registerAll()
    }
}
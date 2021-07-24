package com.jahessit.minecraft.bblocks

import com.jahessit.minecraft.bblocks.common.registry.*
import net.fabricmc.api.ModInitializer

class BBlocksFabricInit: ModInitializer {
    override fun onInitialize() {
        ItemRegistry.registerAll()
        BlockRegistry.registerAll()
    }
}
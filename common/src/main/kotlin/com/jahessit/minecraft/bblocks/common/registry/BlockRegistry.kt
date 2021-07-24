package com.jahessit.minecraft.bblocks.common.registry

import com.jahessit.minecraft.bblocks.common.ModInfo.MOD_ID
import com.jahessit.minecraft.bblocks.common.blocks.ores.PlatinumOreBlock
import me.shedaniel.architectury.registry.*
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block

object BlockRegistry {
    private val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY)

    val PLATINUM_ORE_BLOCK: RegistrySupplier<PlatinumOreBlock> =
        BLOCKS.register(ResourceLocation(MOD_ID, PlatinumOreBlock.ID)) { PlatinumOreBlock }

    fun registerAll() {
        BLOCKS.register()
    }
}
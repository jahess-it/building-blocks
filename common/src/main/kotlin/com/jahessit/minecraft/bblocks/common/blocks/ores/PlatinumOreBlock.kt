package com.jahessit.minecraft.bblocks.common.blocks.ores

import me.shedaniel.architectury.registry.BlockProperties
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material

object PlatinumOreBlock: Block(BlockProperties.of(Material.METAL).strength(2.625f)) {
    const val ID: String = "platinum_ore"
}
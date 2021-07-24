package com.jahessit.minecraft.bblocks.common.items.ores

import com.jahessit.minecraft.bblocks.common.blocks.ores.PlatinumOreBlock
import com.jahessit.minecraft.bblocks.common.registry.ItemRegistry
import net.minecraft.world.item.BlockItem

object PlatinumOreItem: BlockItem(PlatinumOreBlock, Properties().tab(ItemRegistry.BBLOCKS_MATERIALS_TAB)) {
    const val ID: String = PlatinumOreBlock.ID
}
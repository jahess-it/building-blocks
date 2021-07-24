package com.jahessit.minecraft.bblocks.common.registry

import com.jahessit.minecraft.bblocks.common.ModInfo.MOD_ID
import com.jahessit.minecraft.bblocks.common.items.ores.PlatinumOreItem
import me.shedaniel.architectury.registry.*
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.*

object ItemRegistry {
    private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)

    val BBLOCKS_MATERIALS_TAB: CreativeModeTab =
        CreativeTabs.create(ResourceLocation(MOD_ID, PlatinumOreItem.ID)) { ItemStack(PlatinumOreItem) }

    val PLATINUM_ORE_ITEM: RegistrySupplier<PlatinumOreItem> =
        ITEMS.register(ResourceLocation(MOD_ID, PlatinumOreItem.ID)) { PlatinumOreItem }

    fun registerAll() {
        ITEMS.register()
    }
}
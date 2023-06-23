package net.Albez00.my_mod.block;

import net.Albez00.my_mod.My_mod;
import net.Albez00.my_mod.item.ModCreativeModeTab;
import net.Albez00.my_mod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, My_mod.MOD_ID);


    public static final RegistryObject<Block> SVASTIKA_BLOCK = registerBlock(
            "svastika_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.HEAVY_METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.MY_MOD_TAB
    );

    public static final RegistryObject<Block> SVASTIKA_ORE = registerBlock(
            "svastika_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)
            ),
            ModCreativeModeTab.MY_MOD_TAB
    );
    public static final RegistryObject<Block> DEEPSLATE_SVASTIKA_ORE = registerBlock(
            "deepslate_svastika_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)
            ),
            ModCreativeModeTab.MY_MOD_TAB
    );



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package net.Albez00.my_mod.item;

import net.Albez00.my_mod.My_mod;
import net.Albez00.my_mod.item.custom.RockPapperScissorsItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, My_mod.MOD_ID);

    public static final RegistryObject<Item> SVASTIKA = ITEMS.register("svastika",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MY_MOD_TAB)));

    public static final RegistryObject<Item> AKITSAVS = ITEMS.register("akitsavs",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MY_MOD_TAB)));

    public static final RegistryObject<Item> ROCK_PAPER_SCISSORS = ITEMS.register("rock_paper_scissors",
            () -> new RockPapperScissorsItem(new Item.Properties()
                    .tab(ModCreativeModeTab.MY_MOD_TAB)
                    .stacksTo(1)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}

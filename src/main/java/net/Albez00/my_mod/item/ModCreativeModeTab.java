package net.Albez00.my_mod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MY_MOD_TAB = new CreativeModeTab("my_mod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SVASTIKA.get());
        }
    };
}

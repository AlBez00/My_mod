package net.Albez00.my_mod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class RockPapperScissorsItem extends Item {
    public RockPapperScissorsItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomSign(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void outputRandomSign(Player player) {
        player.sendSystemMessage(Component.literal(player.getName().getString() + ": " + getRandomSign()));
    }

    private String getRandomSign() {
        int n = RandomSource.createNewThreadLocalInstance().nextInt(0, 3);
        return n == 0 ? "Ножницы" : n == 1 ? "Бумага" : "Камень";
    }


}

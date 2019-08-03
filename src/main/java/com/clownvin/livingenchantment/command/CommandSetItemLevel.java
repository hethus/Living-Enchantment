package com.clownvin.livingenchantment.command;

import com.clownvin.livingenchantment.LivingEnchantment;
import com.clownvin.livingenchantment.config.Config;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandSetItemLevel {

    public static int setItemLevel(CommandSource source, int level) throws CommandException {
        if (level < 0 || level > Config.COMMON.maxLevel.get()) {
            source.sendErrorMessage(new TranslationTextComponent("commands.setitemlevel.invalid_level_number", Config.COMMON.maxLevel.get()));
            return 1;
        }
        try {
            PlayerEntity player = source.asPlayer();
            ItemStack held = player.getHeldItemMainhand();
            ListNBT tag = LivingEnchantment.getEnchantmentNBTTag(held);
            if (tag == null) {
                source.sendErrorMessage(new TranslationTextComponent("commands.livingenchantment.mainhand_item_not_living"));
                return 2;
            }
            LivingEnchantment.setExp(player, held, tag, LivingEnchantment.lvlToXp(level) + 0.5f); //+0.5f because some levels have rounding underflows for "next level xp"
            source.sendFeedback(new TranslationTextComponent("commands.setitemlevel.success", held.getDisplayName().getFormattedText(), level), true);
        } catch (CommandSyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void register(CommandDispatcher<CommandSource> commandDispatcher) {
        commandDispatcher.register((LiteralArgumentBuilder)(((LiteralArgumentBuilder) Commands.literal("setitemlevel").requires((p_198359_0_) -> p_198359_0_.hasPermissionLevel(2)
        )).then((Commands.argument("level", IntegerArgumentType.integer()).executes((p_198352_0_) ->
                setItemLevel(p_198352_0_.getSource(), IntegerArgumentType.getInteger(p_198352_0_, "level"))
        )))));
    }
}

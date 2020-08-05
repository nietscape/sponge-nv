package io.github.nietscape.spongenv;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.ArrayList;

public class RemoveEffectsCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (! (src instanceof Player)) {
            src.sendMessage(Text.of("You need to be a player to do that!"));
            return CommandResult.empty();
        }
        Player player = (Player)src;
        player.offer(Keys.POTION_EFFECTS, new ArrayList<PotionEffect>());
        player.sendMessage(Text.builder("All potion effects removed.")
                .style(TextStyles.ITALIC)
                .color(TextColors.AQUA)
                .build());
        return CommandResult.success();
    }
}